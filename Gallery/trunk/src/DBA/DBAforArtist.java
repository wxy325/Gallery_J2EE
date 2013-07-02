package DBA;


import VO.Artistmodel;
import VO.Postmodel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.shinshi.gallery.dao.ArtistDao;
import sessionfactory.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBAforArtist implements ArtistDao {
	public Integer getIdByUsername(String name)
	{
		Session session = HibernateSessionFactory.getSession();
		Artistmodel user = (Artistmodel)session.createQuery("from Artistmodel d where d.name = ?").setString(0, name).uniqueResult();
		Integer id = 0;
		try{id = user.getId();
		}
		catch(Exception e){
			return null;
		}
		session.close();
		return id;
	}
	public Integer save(Artistmodel model) {
		Session session = HibernateSessionFactory.getSession();
		Artistmodel test = model;
		Transaction tst = session.beginTransaction();
		session.save(test);
		tst.commit();
		session.close();
		return model.getId();
	}

	
	public void update(Artistmodel model) {
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
		Artistmodel user = (Artistmodel)session.createQuery("from Artistmodel d where d.id = ?").setInteger(0, id).uniqueResult();
		Transaction tst = session.beginTransaction();
		session.delete(user);
		tst.commit();
		session.close();
	}

	
	public Artistmodel get(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Artistmodel user = (Artistmodel)session.createQuery("from Artistmodel d where d.id= ?").setInteger(0, id).uniqueResult();
		session.close();
		return user;
		
	}

	
	public int countAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Artistmodel> users = session.createQuery("from Artistmodel").list();
		int total = 0;
		for(Artistmodel user:users)
			{
				total++;
			}
		session.close();
		return total;
	}


	public List<Artistmodel> listAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Artistmodel> users = session.createQuery("from Artistmodel").list();
		session.close();
		return users;
	}

	public List<Artistmodel> listPage(int pageNumber, int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Artistmodel");
		
		List<Artistmodel> users = session.createQuery("from Artistmodel").list();
		Iterator iterator = users.iterator();
		List<Artistmodel> ls =  new ArrayList();
		Artistmodel m;
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
	////ADVANCED PART
	public List<Postmodel> getPostIdbyArtistId(Integer id)
	{
		Session session = HibernateSessionFactory.getSession();
		List<Postmodel> users = session.createQuery("from Postmodel d where d.artistId= ?").setInteger(0, id).list();
		return users;
	}
//
//	public static void main(String[] args) {
//		DBAforArtistAdvanced D = new DBAforArtistAdvanced();
//		List<Postmodel> list = new ArrayList();
//		list = D.getPostIdbyArtistId(111);
//		for(Postmodel user:list)
//		{
//			System.out.println(user.getName());
//		}
//
//	}
}