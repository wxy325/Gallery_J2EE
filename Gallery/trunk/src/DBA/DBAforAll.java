package DBA;

import VO.*;
import org.shinshi.gallery.dao.IBaseDao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//����ǵ���DAO�ķ�����ʹ�÷�ʽ��������Ҫʹ�õ���usermodel��           
//DBAforAll<Usermodel,Integer> D = new DBAforAll("user");  ��typename can be 'artist' 'pool' 'tag' 'user' 'post'��
//D.getIdByUsername(String name)
//D.save(model)
//D.update(model)
//D.delete(id)
//D.get(id)
//D.countAll()
//D.listAll()
public class DBAforAll<M extends Serializable, PK extends Serializable>implements IBaseDao<M, PK> {
	public int num;
	public DBAforArtist artist = new DBAforArtist();
	public DBAforPool pool = new DBAforPool();
	public DBAforPost post = new DBAforPost();
	public DBAforTag tag = new DBAforTag();
	public DBAforUser user = new DBAforUser(); 
	public DBAforAll(String typename)//typename can be 'artist' 'pool' 'tag' 'user' 'post'
	{	
		if(typename=="artist")
			{num=1;}
		else if(typename =="pool")
			{num=2;}
		else if(typename == "post")
			{num=3;}
		else if(typename == "tag")
			{num=4;}
		else if(typename == "user")
			{num=5;}
		else
		System.out.println("error");
	}
	public PK getIdByUsername(String name)
	{	
		Integer id = 0;
		switch (num)
		{
		case 1: id = artist.getIdByUsername(name);		
		break;
		case 2: id = pool.getIdByUsername(name);
		break;
		case 3: id = post.getIdByUsername(name);
		break;
		case 4: id = tag.getIdByUsername(name);
		break;
		case 5:id = user.getIdByUsername(name);
		}
		return (PK)id;	
	}
	public PK save(M model) {
		
		Integer id = 0;
		switch (num)
		{
		case 1: id = artist.save((Artistmodel)model);
		break;
		case 2: id = pool.save((Poolmodel)model);
		break;
		case 3: id = post.save((Postmodel)model);
		break;
		case 4: id = tag.save((Tagmodel)model);
		break;
		case 5:	id = user.save((Usermodel)model);
		}
		return (PK)id;
	}
	//������һ��û��id��model
	public void update(M model) {//update������ʵ�Ǹ����������idֵ���ı�ԭ����element��Ϊ��������ֵ
		Integer id = 0;
		switch (num)
		{
		case 1: artist.update((Artistmodel)model);
		break;
		case 2: pool.update((Poolmodel)model);
		break;
		case 3: post.update((Postmodel)model);
		break;
		case 4: tag.update((Tagmodel)model);
		break;
		case 5:	user.update((Usermodel)model);
		}
		
	}
	public void delete(PK id) {
		switch (num)
		{
		case 1: artist.delete((Integer)id);
		break;
		case 2: pool.delete((Integer)id);
		break;
		case 3: post.delete((Integer)id);
		break;
		case 4: tag.delete((Integer)id);
		break;
		case 5:	user.delete((Integer)id);
		}
	}
	public M get(PK id) {
	
		switch (num)
		{
		case 1:
			return (M)artist.get((Integer)id);
		case 2: 
			return (M)pool.get((Integer)id);
		case 3: 
			return (M)post.get((Integer)id);
		case 4: 
			return (M)tag.get((Integer)id);
		case 5:	
			return (M)user.get((Integer)id);
		}
		return null;
	}
	public int countAll() {
		Integer number = -1;
		switch (num)
		{
		case 1: number = artist.countAll();
		break;
		case 2: number = pool.countAll();
		break;
		case 3: number = post.countAll();
		break;
		case 4: number = tag.countAll();
		break;
		case 5:	number = user.countAll();
		}
		return number;
	}
	public List<M> listAll() {//���ص���ʵ�Ǹ�������List��Ҫǿ��ת����ȥ
		List lst = new ArrayList();
		List<M> lst2 = new ArrayList();
		switch (num)
		{
		case 1: lst = artist.listAll();
		case 2: lst = pool.listAll();
		case 3: lst = post.listAll();
		case 4: lst = tag.listAll();
		case 5:	lst = user.listAll();
		}
		lst2 = lst;
		return lst2;
	}
	public List<M> listPage(int pageNumber, int pageSize) //���ص���ʵ�Ǹ�������List��Ҫǿ��ת����ȥ
	{
		List lst = new ArrayList();
		List<M> lst2 = new ArrayList();
		switch (num)
		{
		case 1: lst = artist.listPage(pageNumber,pageSize);
		case 2: lst = pool.listPage(pageNumber,pageSize);
		case 3: lst = post.listPage(pageNumber,pageSize);
		case 4: lst = tag.listPage(pageNumber,pageSize);
		case 5:	lst = user.listPage(pageNumber,pageSize);
		}
		lst2 = lst;
		return lst2;
	}
	
	public static void main(String[] args) {
		DBAforAll<Artistmodel,Integer> D = new DBAforAll("artist");
		Artistmodel U = new Artistmodel();
		U.setName("����Ȫ");
		U.setAliasId(7777);
		System.out.println(D.get(1234).getName());
//		System.out.println(D.getIdByUsername("����Ȫ"));
	
	
	}

}
