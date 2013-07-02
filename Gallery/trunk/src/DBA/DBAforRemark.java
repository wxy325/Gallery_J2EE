package DBA;

import VO.Remarkids;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.shinshi.gallery.dao.RemarkDao;
import sessionfactory.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBAforRemark implements  RemarkDao {
	public Integer getIdByUsername(String name)
	{
			return null;
	}
	public Integer save(Remarkids model) {
		Session session = HibernateSessionFactory.getSession();
		Remarkids test = model;
		Transaction tst = session.beginTransaction();
		session.save(test);
		tst.commit();
		session.close();
		return model.getId();
	}

	
	public void update(Remarkids model) {//����֪��ownerId
		Session session = HibernateSessionFactory.getSession();
		Transaction tst = session.beginTransaction();
		try{
		session.update(model);
		tst.commit();}
		catch(Exception e)
		{
			System.out.println("error");
		}
		
		session.close();
	}

	
	public void delete(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Remarkids user = (Remarkids)session.createQuery("from Remarkids d where d.id = ?").setInteger(0, id).uniqueResult();
		Transaction tst = session.beginTransaction();
		session.delete(user);
		tst.commit();
		session.close();
	}

	
	public Remarkids get(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Remarkids user = (Remarkids)session.createQuery("from Remarkids d where d.id= ?").setInteger(0, id).uniqueResult();
		session.close();
		return user;
		
	}

	
	public int countAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Remarkids> users = session.createQuery("from Remarkids").list();
		int total = 0;
		for(Remarkids user:users)
			{
				total++;
			}
		session.close();
		return total;
	}


	public List<Remarkids> listAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Remarkids> users = session.createQuery("from Remarkids").list();
		session.close();
		return users;
	}

	public List<Remarkids> listPage(int pageNumber, int pageSize) {
		Session session = HibernateSessionFactory.getSession();	
		List<Remarkids> users = session.createQuery("from Remarkids").list();
		Iterator iterator = users.iterator();
		List<Remarkids> ls =  new ArrayList();
		Remarkids m;
		int temp=pageNumber-1;
		for(int j=0;j<pageSize;j++)
		{	
			m = users.get(temp);
			ls.add(m);
			temp++;
		}
		
		return ls;
	}
	//Advanced part
	public List<Integer> getRemarkbyPostmodel(Integer PostId)
	{
		Session session = HibernateSessionFactory.getSession();
		List<Integer> users1 = session.createQuery("select remark from Remarkids b where b.pictureId = ?").setInteger(0, PostId).list();
		return users1;
		
	}
	public List<Remarkids> getRemarkbyUsermodel(Integer UserId)
	{
		Session session = HibernateSessionFactory.getSession();
		List<Remarkids> users1 = session.createQuery("from Remarkids b where b.ownerId = ?").setInteger(0, UserId).list();
		return users1;
	}
	public List<Integer> getRemarkbyUsermodelandPostmodel(Integer UserId,Integer PostId)
	{
		Session session = HibernateSessionFactory.getSession();
		List<Integer> users1 = new ArrayList();
		users1 = session.createQuery("select remark from Remarkids b where b.ownerId = ? and b.pictureId = ?").setInteger(0, UserId).setInteger(1, PostId).list();
		if(users1.isEmpty())
		return null;
		return users1;
	}
	public Float getAverageScore(Integer PostId)
	{
		Session session = HibernateSessionFactory.getSession();
		List<Integer> users1 = session.createQuery("select remark from Remarkids b where b.pictureId= ?").setInteger(0, PostId).list();
		int count = 0;
		int all = 0;
		float average = 0;
		for(Integer user:users1)
		{
			count++;
			all = all+user.intValue();
		}
		average = (float)all/count;
		return average;
	}
	public static void main(String[] args) {
		DBAforRemark D = new DBAforRemark();
		Remarkids C2 = new Remarkids();
//		List<Remarkids> C  = new ArrayList();
//		C = D.listPage(1, 1);
//		System.out.println(C.get(0).getId());
//		System.out.println(D.countAll());
		C2 = D.get(1);
		System.out.println(C2.getId());
//		C.setComment("~~~");
//		D.update(C2);
//		String s = D.get(121).getComment();
//		System.out.println(s);
//		List<String> list = new ArrayList(); 
//		list = D.getCommentbyUserId(123);
//		for(String user:list)
//		{
//			System.out.println(user);
//		}

	}

}
