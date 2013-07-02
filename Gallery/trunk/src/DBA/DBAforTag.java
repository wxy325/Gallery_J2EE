package DBA;

import VO.Tagids;
import VO.Tagmodel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.shinshi.gallery.dao.TagDao;
import sessionfactory.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBAforTag implements TagDao {
	public Integer getIdByUsername(String name)
	{
		Session session = HibernateSessionFactory.getSession();
		Tagmodel user = (Tagmodel)session.createQuery("from Tagmodel d where d.name = ?").setString(0, name).uniqueResult();
		Integer id = 0;
		try{id = user.getId();
		}
		catch(Exception e){
			return null;
		}
		session.close();
		return id;
	}
	public Integer save(Tagmodel model) {
		Session session = HibernateSessionFactory.getSession();
		Tagmodel test = model;
		Transaction tst = session.beginTransaction();
		session.save(test);
		tst.commit();
		session.close();
		return model.getId();
	}

	
	public void update(Tagmodel model) {
		String name = model.getName();
		Integer id = getIdByUsername(name);
		model.setId(id);
		Session session = HibernateSessionFactory.getSession();
		Transaction tst = session.beginTransaction();
		try{
		session.update(model);
		tst.commit();}
		catch(Exception e)
		{
			System.out.println("û���ҵ����û���");
		}
		
		session.close();
	}


	public void delete(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Tagmodel user = (Tagmodel)session.createQuery("from Tagmodel d where d.id = ?").setInteger(0, id).uniqueResult();
		Transaction tst = session.beginTransaction();
		session.delete(user);
		tst.commit();
		session.close();
	}

	
	public Tagmodel get(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Tagmodel user = (Tagmodel)session.createQuery("from Tagmodel d where d.id= ?").setInteger(0, id).uniqueResult();
		session.close();
		return user;
		
	}

	
	public int countAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Tagmodel> users = session.createQuery("from Tagmodel").list();
		int total = 0;
		for(Tagmodel user:users)
			{
				total++;
			}
		session.close();
		return total;
	}


	public List<Tagmodel> listAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Tagmodel> users = session.createQuery("from Tagmodel").list();
		session.close();
		return users;
	}



		public List<Tagmodel> listPage(int pageNumber, int pageSize) {
			Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("from Tagmodel");
			
			List<Tagmodel> users = session.createQuery("from Tagmodel").list();
			Iterator iterator = users.iterator();
			List<Tagmodel> ls =  new ArrayList();
			Tagmodel m;
			int temp=pageNumber-1;
			for(int j=0;j<pageSize;j++)
			{	
				m = users.get(temp);
				ls.add(m);
				System.out.println(ls.get(temp).getId());
				temp++;
			}
			
			return ls;
		}
	//Advanced part
		public Tagmodel getTagbyName(String name)
		{
			Session session = HibernateSessionFactory.getSession();
			Tagmodel tag = (Tagmodel)session.createQuery("from Tagmodel b where b.name = ?").setString(0, name).uniqueResult();
			return tag;
		}
		public List<Tagmodel> getAllTagByPostId(Integer PostId)
		{
			Session session = HibernateSessionFactory.getSession();
			List<Integer> tags = session.createQuery("select tagid from Tagids b where b.ownerId = ?").setInteger(0, PostId).list();
			List<Tagmodel> list = new ArrayList();
			for(Integer tag:tags)
			{
				list.add((Tagmodel)session.createQuery("from Tagmodel b where b.id = ?").setInteger(0, tag).uniqueResult());
			}
			return list;
		}
		public void AttachTagtoPostmodel(Integer PostId,Integer TagId)
		{
			Session session = HibernateSessionFactory.getSession();
			Tagids test = new Tagids(PostId,TagId);
			Transaction tst = session.beginTransaction();
			session.save(test);
			tst.commit();
			session.close();
		}
		public void DeleteTagfromPostmodel(Integer PostId,Integer TagId)
		{
			Session session = HibernateSessionFactory.getSession();
			Tagids tag = (Tagids)session.createQuery("from Tagids b where b.ownerId = ? and b.tagid = ?").setInteger(0, PostId).setInteger(1, TagId).uniqueResult();
			Transaction tst = session.beginTransaction();
//			System.out.println("!!!");
			try{session.delete(tag);
			tst.commit();}
			catch(Exception e)
			{}
		}
		public List<Tagids> getPopularTags(Integer n)
		{
			Session session = HibernateSessionFactory.getSession();
			List<Tagids> tags = session.createQuery("from Tagids group by tagid order by count(*) desc").list();
			List<Tagids> tags2 = new ArrayList();
			for(int i = 0; i<n;i++)
			{
				tags2.add(tags.get(i));
			}
			return tags2;
		}
		public Integer countTag(Integer id)
		{
			Integer count = 0;
			Session session = HibernateSessionFactory.getSession();
			List<Tagids> tags = session.createQuery("from Tagids b where b.tagid =?").setInteger(0, id).list();
			for(Tagids tag:tags)
				{	
					count++;
				}
			return count;
		}
		public List<Tagmodel> searchTagByString(String string)
		{
			Session session = HibernateSessionFactory.getSession();
			List<Tagmodel> tags = session.createQuery("from Tagmodel d where d.name like :name")
				.setString("name","%"+string+"%")
				.list();
			return tags;
		}
	
		public static void main(String[] args) {
			DBAforTag D = new DBAforTag();
			List<Tagids> list = new ArrayList();
			
			list = D.getPopularTags(1);
			System.out.println(list.get(1).getOwnerId());
//			for(DBAforTag user:list)
//			{
//				System.out.println(user.getName());
//			}
//			System.out.println(D.countTag(3));
		}
}