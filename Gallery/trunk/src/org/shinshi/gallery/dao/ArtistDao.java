package org.shinshi.gallery.dao;

import VO.Artistmodel;
import VO.Postmodel;

import java.util.List;

public interface ArtistDao extends IBaseDao<Artistmodel,Integer> {
		public List<Postmodel> getPostIdbyArtistId(Integer id);
}
