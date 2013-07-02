package DBA;
import VO.Poolmodel;
import VO.Postids;
import VO.Postmodel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.shinshi.gallery.dao.PoolDao;
import sessionfactory.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBAforPool implements  PoolDao {
	public Integer getIdByUsername(String name)
	{
		Session session = HibernateSessionFactory.getSession();
		Poolmodel user = (Poolmodel)session.createQuery("from Poolmodel d where d.name = ?").setString(0, name).uniqueResult();
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
		String s = "�ϼ���";
		DBAforPool D = new DBAforPool();
		D.listPage(1, 3);
	
	}


	public Integer save(Poolmodel model) {
		Session session = HibernateSessionFactory.getSession();
		Poolmodel test = model;
		Transaction tst = session.beginTransaction();
		session.save(test);
		tst.commit();
		session.close();
		return model.getId();
	}

	
	public void update(Poolmodel model) {
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
		Poolmodel user = (Poolmodel)session.createQuery("from Poolmodel d where d.id = ?").setInteger(0, id).uniqueResult();
		Transaction tst = session.beginTransaction();
		session.delete(user);
		tst.commit();
		session.close();
	}

	
	public Poolmodel get(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Poolmodel user = (Poolmodel)session.createQuery("from Poolmodel d where d.id= ?").setInteger(0, id).uniqueResult();
		session.close();
		return user;
		
	}

	
	public int countAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Poolmodel> users = session.createQuery("from Poolmodel").list();
		int total = 0;
		for(Poolmodel user:users)
			{
				total++;
			}
		session.close();
		return total;
	}


	public List<Poolmodel> listAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Poolmodel> users = session.createQuery("from Poolmodel").list();
		session.close();
		return users;
	}


	public List<Poolmodel> listPage(int pageNumber, int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Poolmodel");
		
		List<Poolmodel> users = session.createQuery("from Poolmodel").list();
		Iterator iterator = users.iterator();
		List<Poolmodel> ls =  new ArrayList();
		Poolmodel m;
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
	public void AddImage(Integer postId,Integer poolId)
	{
		Session session = HibernateSessionFactory.getSession();
		Postids test = new Postids(postId,poolId);
		Transaction tst = session.beginTransaction();
		session.save(test);
		tst.commit();
	}
	public List<Postmodel> getPostmodelbyPool(Integer Poolid)
	{
		Session session = HibernateSessionFactory.getSession();
		List<Postids> users1 = session.createQuery("from Postids b where b.poolid = ?").setInteger(0, Poolid).list();
		List<Postmodel> users2 = session.createQuery("from Postmodel d").list();
		List<Integer> users3 = new ArrayList();
		List<Postmodel> users4 = new ArrayList();
		for(Postids user:users1)
		{
			users3.add(user.getPostid());
		}
		for(Postmodel user2:users2)
		{
			for(Integer user3:users3)
			{
				if(user2.getId().equals(user3) )//���������Щpostmodel����˭�Ǹ�pool ��
				{	
					users4.add(user2);
					continue;
				}
			}
		}
		return users4;
	}
	public List<Poolmodel> getPoolbyuser(Integer UserId)
	{
		Session session = HibernateSessionFactory.getSession();
		List<Poolmodel> users1 = session.createQuery("from Poolmodel b where b.creatorId = ?").setInteger(0, UserId).list();
	
		return users1;
	}

}
