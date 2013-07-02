package DBA;

import VO.Usermodel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.shinshi.gallery.dao.IAccountDao;
import sessionfactory.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class DBAforUser implements IAccountDao<Usermodel,Integer>{
	private boolean add;

	public Integer getIdByUsername(String name)//�������򷵻�null�����ھͷ���id
	{	
		Session session = HibernateSessionFactory.getSession();
		Usermodel user = null;
		user = (Usermodel)session.createQuery("from Usermodel d where d.name = ?").setString(0, name).uniqueResult();
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
		String s = "��2";
		DBAforUser D = new DBAforUser();
		Usermodel U = new Usermodel();
		U.setName(s);
		U.setPassword("hahah");
		D.update(U);
		System.out.println("Operation success");
	}

	
	public Integer save(Usermodel model) {
		Session session = HibernateSessionFactory.getSession();
		Usermodel test = model;
		Transaction tst = session.beginTransaction();
		session.save(test);
		tst.commit();
		session.close();
		return model.getId();
	}

	
	public void update(Usermodel model) {//������һ��û��id��model
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
		Usermodel user = (Usermodel)session.createQuery("from Usermodel d where d.id = ?").setInteger(0, id).uniqueResult();
		Transaction tst = session.beginTransaction();
		session.delete(user);
		tst.commit();
		session.close();
	}


	public Usermodel get(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		Usermodel user = (Usermodel)session.createQuery("from Usermodel d where d.id= ?").setInteger(0, id).uniqueResult();
		session.close();
		return user;
		
	}

	
	public int countAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Usermodel> users = session.createQuery("from Usermodel").list();
		int total = 0;
		for(Usermodel user:users)
			{
				total++;
			}
		session.close();
		return total;
	}


	public List<Usermodel> listAll() {
		Session session = HibernateSessionFactory.getSession();
		List<Usermodel> users = session.createQuery("from Usermodel").list();
		session.close();
		return users;
	}


	public List<Usermodel> listPage(int pageNumber, int pageSize) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Usermodel");
		
		List<Usermodel> users = session.createQuery("from Usermodel").list();
		Iterator iterator = users.iterator();
		List<Usermodel> ls =  new ArrayList();
		Usermodel m;
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

}
