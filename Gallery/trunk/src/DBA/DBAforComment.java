package DBA;

import VO.Commentsids;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.shinshi.gallery.dao.CommentDao;
import sessionfactory.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBAforComment implements CommentDao {
        public Integer getIdByUsername(String name)
        {
            return null;
        }
        public Integer save(Commentsids model) {
            Session session = HibernateSessionFactory.getSession();
            Commentsids test = model;
            Transaction tst = session.beginTransaction();
            session.save(test);
            tst.commit();
            session.close();
            return model.getId();
        }


        public void update(Commentsids model) {//±ÿ–Î÷™µ¿ownerId
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
            Commentsids user = (Commentsids)session.createQuery("from Commentsids d where d.id = ?").setInteger(0, id).uniqueResult();
            Transaction tst = session.beginTransaction();
            session.delete(user);
            tst.commit();
            session.close();
        }


        public Commentsids get(Integer id) {
            Session session = HibernateSessionFactory.getSession();
            Commentsids user = (Commentsids)session.createQuery("from Commentsids d where d.id= ?").setInteger(0, id).uniqueResult();
            session.close();
            return user;

        }


        public int countAll() {
            Session session = HibernateSessionFactory.getSession();
            List<Commentsids> users = session.createQuery("from Commentsids").list();
            int total = 0;
            for(Commentsids user:users)
            {
                total++;
            }
            session.close();
            return total;
        }


        public List<Commentsids> listAll() {
            Session session = HibernateSessionFactory.getSession();
            List<Commentsids> users = session.createQuery("from Commentsids").list();
            session.close();
            return users;
        }

        public List<Commentsids> listPage(int pageNumber, int pageSize) {
            Session session = HibernateSessionFactory.getSession();
            Query query = session.createQuery("from Commentsids");

            List<Commentsids> users = session.createQuery("from Commentsids").list();
            Iterator iterator = users.iterator();
            List<Commentsids> ls =  new ArrayList();
            Commentsids m;
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
        public List<Commentsids> getCommentbyPostId(Integer id)
        {
            Session session = HibernateSessionFactory.getSession();
            List<Commentsids> users = session.createQuery("from Commentsids d where d.pictureId= ? order by date desc").setInteger(0, id).list();
            return users;
        }
        public List<Commentsids> getCommentbyUserId(Integer id)
        {
            Session session = HibernateSessionFactory.getSession();
            List<Commentsids> users = session.createQuery("from Commentsids d where d.ownerId= ? order by date desc").setInteger(0, id).list();
            return users;
        }
        public List<Commentsids> searchCommentByString(String string)
        {
            Session session = HibernateSessionFactory.getSession();
            List<Commentsids> comments = session.createQuery("from Commentsids d where d.comment like :comment")
                    .setString("comment","%"+string+"%")
                    .list();
            return comments;
        }
        public static void main(String[] args) {
            DBAforComment D = new DBAforComment();
            List<Commentsids> C  = new ArrayList();
            C = D.searchCommentByString("ha");
//		C = D.listPage(1, 1);
            System.out.println(C.get(0).getId());
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