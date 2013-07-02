package DBA;

import VO.Descriptionids;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.shinshi.gallery.dao.DescriptionDao;
import sessionfactory.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBAforDescription implements  DescriptionDao {
    public Integer save(Descriptionids model) {
        Session session = HibernateSessionFactory.getSession();
        Descriptionids test = model;
        Transaction tst = session.beginTransaction();
        session.save(test);
        tst.commit();
        session.close();
        return model.getId();
    }


    public void update(Descriptionids model) {//±ÿ–Î÷™µ¿ownerId
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
        Descriptionids user = (Descriptionids)session.createQuery("from Descriptionids d where d.id = ?").setInteger(0, id).uniqueResult();
        Transaction tst = session.beginTransaction();
        session.delete(user);
        tst.commit();
        session.close();
    }


    public Descriptionids get(Integer id) {
        Session session = HibernateSessionFactory.getSession();
        Descriptionids user = (Descriptionids)session.createQuery("from Descriptionids d where d.id= ?").setInteger(0, id).uniqueResult();
        session.close();
        return user;

    }


    public int countAll() {
        Session session = HibernateSessionFactory.getSession();
        List<Descriptionids> users = session.createQuery("from Descriptionids").list();
        int total = 0;
        for(Descriptionids user:users)
        {
            total++;
        }
        session.close();
        return total;
    }


    public List<Descriptionids> listAll() {
        Session session = HibernateSessionFactory.getSession();
        List<Descriptionids> users = session.createQuery("from Descriptionids").list();
        session.close();
        return users;
    }

    public List<Descriptionids> listPage(int pageNumber, int pageSize) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery("from Descriptionids");

        List<Descriptionids> users = session.createQuery("from Descriptionids").list();
        Iterator iterator = users.iterator();
        List<Descriptionids> ls =  new ArrayList();
        Descriptionids m;
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
    public List<Descriptionids> getDescriptionbyPictureId(Integer id)
    {
        Session session = HibernateSessionFactory.getSession();
        List<Descriptionids> users = session.createQuery("from Descriptionids d where d.pictureId= ? order by date desc").setInteger(0, id).list();
        List<String> list = new ArrayList();
        for(Descriptionids user:users)
        {
            list.add(user.getDescription());
        }
        return users;

    }
    public List<Descriptionids> getDescriptionbyUserId(Integer id)
    {
        Session session = HibernateSessionFactory.getSession();
        List<Descriptionids> users = session.createQuery("from Descriptionids d where d.ownerId= ? order by date desc").setInteger(0, id).list();
        List<String> list = new ArrayList();
        for(Descriptionids user:users)
        {
            list.add(user.getDescription());
        }
        return users;
    }
    public List<Descriptionids> searchDescriptionByString(String string)
    {
        Session session = HibernateSessionFactory.getSession();
        List<Descriptionids> tags = session.createQuery("from Descriptionids d where d.description like :des")
                .setString("des","%"+string+"%")
                .list();
        return tags;
    }
    public static void main(String[] args) {
        DBAforDescription D = new DBAforDescription();
        List<Descriptionids> C = new ArrayList();
        C = D.searchDescriptionByString("few");

//		Descriptionids C = new Descriptionids();
//		C.setPictureId(1341);
//		C.setDescription("!!!");
//		
//		C.setId(4);
//		D.save(C);
//		C = D.listPage(1, 1);
        System.out.println(C.get(0).getDescription());
//		System.out.println(D.countAll());
//		C.setOwnerId(421);
//		C.setId(113);
//		C.setComment("~~~");
//		D.update(C);
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