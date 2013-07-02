package org.shinshi.gallery.dao;
import VO.Postmodel;

import java.util.List;

public interface ImageDao extends IBaseDao<Postmodel,Integer> {
	public List<Postmodel> getImagebyVisted(Integer position,Integer count,Integer tagid);
	public List<Postmodel> getImagebyScore(Integer position,Integer count,Integer tagid);
	public List<Postmodel> getImagebyDate(Integer position,Integer count,Integer tagid);
	public List<Postmodel> getImagebyRandom(Integer count,Integer tagid);
	public List<Postmodel> searchPostByString(String string);
    public List<Postmodel> getAllPostByUsrId(Integer id);
}
