package org.shinshi.gallery.dao;

import VO.Poolmodel;
import VO.Postmodel;

import java.util.List;

public interface PoolDao extends IBaseDao<Poolmodel,Integer>{
	public void AddImage(Integer postId,Integer poolId);//�൱����postids���poolmodel��postmiodel��ر������һ����¼
	public List<Postmodel> getPostmodelbyPool(Integer Poolid);
	public List<Poolmodel> getPoolbyuser(Integer UserId);
}
