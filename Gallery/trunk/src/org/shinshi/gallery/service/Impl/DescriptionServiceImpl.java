package org.shinshi.gallery.service.Impl;

import VO.Descriptionids;
import org.shinshi.gallery.dao.DescriptionDao;
import org.shinshi.gallery.helper.ParseHelper;
import org.shinshi.gallery.service.DescriptionService;

import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-6-18
 * Time: 下午3:28
 */
public class DescriptionServiceImpl implements DescriptionService<Integer, Descriptionids> {

    private DescriptionDao dao;

    public DescriptionServiceImpl(DescriptionDao dao) {
        this.dao = dao;
    }

    @Override
    public Integer save(Descriptionids description) {
        return dao.save(description);
    }

    @Override
    public void remove(Integer id) {
        dao.delete(id);
    }

    @Override
    public Descriptionids get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Integer> getImageDes(Integer imageId) {
        return ParseHelper.descriptionModelToInteger(dao.getDescriptionbyPictureId(imageId));
    }

    @Override
    public void update(Descriptionids description) {
        dao.update(description);
    }

    @Override
    public List<Integer> getByPostId(Integer id)
    {
        return ParseHelper.descriptionModelToInteger(dao.getDescriptionbyPictureId(id));
    }
    @Override
    public List<Integer> getByUserId(Integer id)
    {
        return ParseHelper.descriptionModelToInteger(dao.getDescriptionbyUserId(id));
    }
    @Override
    public List<Integer> search(String keyword)
    {
        return ParseHelper.descriptionModelToInteger(dao.searchDescriptionByString(keyword));
    }
}
