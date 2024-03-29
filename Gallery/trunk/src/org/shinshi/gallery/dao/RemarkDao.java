package org.shinshi.gallery.dao;
import VO.Postmodel;
import VO.Remarkids;

import java.util.List;


public interface RemarkDao extends IBaseDao<Remarkids,Integer>{
	public List<Integer> getRemarkbyPostmodel(Integer PostId);
	public List<Remarkids> getRemarkbyUsermodel(Integer UserId);
	public List<Integer> getRemarkbyUsermodelandPostmodel(Integer UserId,Integer PostId);
	public Integer getAverageScore(Integer PostId);
}
