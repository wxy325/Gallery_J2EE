package DBA;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.shinshi.gallery.dao.ImageDao;
import sessionfactory.HibernateSessionFactory;
import org.hibernate.Session;
import VO.*;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.shinshi.gallery.dao.IAccountDao;

public class DBAforPost implements ImageDao {
	public Integer getIdByUsername(String name)
	{
		Session session = HibernateSessionFactory.getSession();
		Postmodel user = (Postmodel)session.createQuery("from Postmodel d where d.name = ?").setString(0, name).uniqueResult();
		Integer id = 0;
		try{id = user.getId();
		}
		catch(Exception e){
			return null;
		}
		session.close();
		return id;
	}
	
	public static void main(String[] args) {
		
		DBAforPost D = new DBAforPost();
		List<Postmodel> C = new ArrayList();
		C = D.searchPostByString("sd");
		System.out.println(C.get(0).getTitle());
		System.out.println(C.get(1).getTitle());
		System.out.println(C.get(2).getTitle());
	
	}


	public Integer save(Postmodel model) {
		Session session = HibernateSessionFactory.getSession();
		Postmodel test = model;
		Transaction tst = session.beginTransaction();
		session.save(test);
		tst.commit();
		session.close();
		return model.getId();
	}

	
	public void update(Postmodel model) {
//		String name = model.getName();
//		Integer id = getIdByUsername(name);
//		model.setId(id);
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
		Postmodel user = (Postmodel)session.createQuery("from Postmodel d where d.id = ?").setInteger(0, id).uniqueResult();
		Transaction tst = session.beginTransaction();
		session.delete(user);
		tst.commit();
		session.close();
	}


	public Postmodel get(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Postmodel user = (Postmodel)session.createQuery("from Postmodel d where d.id= ?").setInteger(0, id).uniqueResult();
		session.close();
		return user;
		
	}

	
	public int countAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Postmodel> users = session.createQuery("from Postmodel").list();
		int total = 0;
		for(Postmodel user:users)
			{
				total++;
			}
		session.close();
		return total;
	}

	
	public List<Postmodel> listAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Postmodel> users = session.createQuery("from Postmodel").list();
		session.close();
		return users;
	}


	
		public List<Postmodel> listPage(int pageNumber, int pageSize) {
			Session session = HibernateSessionFactory.getSession();
			Query query = session.createQuery("from Postmodel");
			
			List<Postmodel> users = session.createQuery("from Postmodel").list();
			Iterator iterator = users.iterator();
			List<Postmodel> ls =  new ArrayList();
			Postmodel m;
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
		public List<Postmodel> getImagebyVisted(Integer position,Integer count,Integer tagid)
		{

			Session session = HibernateSessionFactory.getSession();
			if(tagid != null)
			{
				//users1������tagid��Tagid
				//users2������postmodel
				//users3��������¼��tagid���д���������Postmodel��ID
				//user4��������¼��������ӵ�и�tagid��postmodel
				List<Tagids> users1 = session.createQuery("from Tagids b where b.tagid = ?").setInteger(0, tagid).list();
				List<Postmodel> users2 = session.createQuery("from Postmodel d order by visited desc").list();
				List<Integer> users3 = new ArrayList();
				List<Postmodel> users4 = new ArrayList();
				List<Postmodel> list1 = new ArrayList(); 
				for(Tagids user:users1)
				{
					users3.add(user.getOwnerId());
				}
				
				for(Postmodel user2:users2)
				{
					for(Integer user3:users3)
					{
						if(user2.getId().equals(user3) )//���������Щpostmodel����˭����ӵ�и�tag
						{	
							users4.add(user2);
							continue;
						}
					}
				}
				
				for(int i=0;i<count;i++)
				{
					list1.add(users4.get(position+i));
				}
				return list1;
			}
			List<Postmodel> users = session.createQuery("from Postmodel d order by visited desc").list();
			List<Postmodel> list2 = new ArrayList(); 
			for(int i=0;i<count;i++)
				{
					list2.add(users.get(position+i));
				}
			return list2;
		
		}
		public List<Postmodel> getImagebyScore(Integer position,Integer count,Integer tagid)
		{

			Session session = HibernateSessionFactory.getSession();
			if(tagid != null)
			{
				//users1������tagid��Tagid
				//users2������postmodel
				//users3��������¼��tagid���д���������Postmodel��ID
				//user4��������¼��������ӵ�и�tagid��postmodel
				List<Tagids> users1 = session.createQuery("from Tagids b where b.tagid = ?").setInteger(0, tagid).list();
				List<Postmodel> users2 = session.createQuery("from Postmodel d order by score desc").list();
				List<Integer> users3 = new ArrayList();
				List<Postmodel> users4 = new ArrayList();
				List<Postmodel> list1 = new ArrayList(); 
				for(Tagids user:users1)
				{
					users3.add(user.getOwnerId());
				}
				
				for(Postmodel user2:users2)
				{
					for(Integer user3:users3)
					{
						if(user2.getId().equals(user3) )//���������Щpostmodel����˭����ӵ�и�tag
						{	
							users4.add(user2);
							continue;
						}
					}
				}
				
				for(int i=0;i<count;i++)
				{
					list1.add(users4.get(position+i));
				}
				return list1;
			}
			List<Postmodel> users = session.createQuery("from Postmodel d order by score desc").list();
			List<Postmodel> list2 = new ArrayList(); 
			for(int i=0;i<count;i++)
				{
					list2.add(users.get(position+i));
				}
			return list2;
		
		}
		public List<Postmodel> getImagebyDate(Integer position,Integer count,Integer tagid)
		{

			Session session = HibernateSessionFactory.getSession();
			if(tagid != null)
			{
				//users1������tagid��Tagid
				//users2������postmodel
				//users3��������¼��tagid���д���������Postmodel��ID
				//user4��������¼��������ӵ�и�tagid��postmodel
				List<Tagids> users1 = session.createQuery("from Tagids b where b.tagid = ?").setInteger(0, tagid).list();
				List<Postmodel> users2 = session.createQuery("from Postmodel d order by createdAt desc").list();
				List<Integer> users3 = new ArrayList();
				List<Postmodel> users4 = new ArrayList();
				List<Postmodel> list1 = new ArrayList(); 
				for(Tagids user:users1)
				{
					users3.add(user.getOwnerId());
				}
				
				for(Postmodel user2:users2)
				{
					for(Integer user3:users3)
					{
						if(user2.getId().equals(user3) )//���������Щpostmodel����˭����ӵ�и�tag
						{	
							users4.add(user2);
							continue;
						}
					}
				}
				
				for(int i=0;i<count;i++)
				{
					list1.add(users4.get(position+i));
				}
				return list1;
			}
			List<Postmodel> users = session.createQuery("from Postmodel d order by createdAt desc").list();
			List<Postmodel> list2 = new ArrayList(); 
			for(int i=0;i<count;i++)
				{
					list2.add(users.get(position+i));
				}
			return list2;
		
		}
		public List<Postmodel> searchPostByString(String string)
		{
			Session session = HibernateSessionFactory.getSession();
			List<Postmodel> tags = session.createQuery("from Postmodel d where d.title like :name")
				.setString("name","%"+string+"%")
				.list();
			return tags;
		}
		public List<Postmodel> getImagebyRandom(Integer count,Integer tagid)
		{
			//users1������tagid��Tagid
			//users2������postmodel
			//users3��������¼��tagid���д���������Postmodel��ID
			//user4��������¼��������ӵ�и�tagid��postmodel
			Session session = HibernateSessionFactory.getSession();
			if(tagid != null)
			{
			List<Tagids> users1 = session.createQuery("from Tagids b where b.tagid = ?").setInteger(0, tagid).list();
			//����������쳣�ܿ�������Ϊ��ݿ��������������
			List<Postmodel> users2 = session.createQuery("from Postmodel d order by rand()").list();
			List<Integer> users3 = new ArrayList();
			List<Postmodel> users4 = new ArrayList();
			List<Postmodel> list1 = new ArrayList(); 
			for(Tagids user:users1)
			{
				users3.add(user.getOwnerId());
			}
			for(Postmodel user2:users2)
			{
				for(Integer user3:users3)
				{
					if(user2.getId().equals(user3) )//���������Щpostmodel����˭����ӵ�и�tag
					{	
						users4.add(user2);
						continue;
					}
				}
			}
			
			for(int i=0;i<count;i++)
			{
				list1.add(users4.get(i));
			}
			return list1;
			}
			
			List<Postmodel> users3 = new ArrayList();
			List<Postmodel> users2 = session.createQuery("from Postmodel order by rand()").list();
			for(int i =0;i<count;i++)
			{
				users3.add(users2.get(i));
			}
			return users3;
		}


    public List<Postmodel> getAllPostByUsrId(Integer id)
    {
        Session session = HibernateSessionFactory.getSession();
        List<Postmodel> users1 = session.createQuery("from Postmodel b where b.creatorId = ?").setInteger(0, id).list();
        return users1;
    }
}
