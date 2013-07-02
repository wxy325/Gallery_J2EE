package org.shinshi.gallery.dao;

import VO.Descriptionids;

import java.util.List;

public interface DescriptionDao  extends IBaseDao<Descriptionids,Integer>   {
    public List<Descriptionids> getDescriptionbyPictureId(Integer id);
    public List<Descriptionids> getDescriptionbyUserId(Integer id);
    public List<Descriptionids> searchDescriptionByString(String string);
}
