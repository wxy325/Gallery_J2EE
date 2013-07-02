package org.shinshi.gallery.dao;

import VO.Postmodel;
import VO.Tagmodel;

import java.util.List;

public interface TagDao extends IBaseDao<Tagmodel,Integer> {
	public Tagmodel getTagbyName(String name);
	public List<Tagmodel> getAllTagByPostId(Integer PostId);
	public void AttachTagtoPostmodel(Integer PostId,Integer TagId);
	public void DeleteTagfromPostmodel(Integer PostId,Integer TagId);
	public Integer countTag(Integer id);
	public List<Tagmodel> searchTagByString(String string);
}
