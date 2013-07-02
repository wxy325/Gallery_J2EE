package org.shinshi.gallery.service.Impl;

import VO.Remarkids;
import org.shinshi.gallery.dao.RemarkDao;
import org.shinshi.gallery.helper.ParseHelper;
import org.shinshi.gallery.service.RemarkService;

import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-6-18
 * Time: 下午3:48
 */
public class RemarkServiceImpl implements RemarkService<Remarkids, Integer> {
    private RemarkDao dao;

    public RemarkServiceImpl(RemarkDao dao) {
        this.dao = dao;
    }

    @Override
    public Integer save(Remarkids remarkids) {
        return dao.save(remarkids);
    }

    @Override
    public Remarkids get(Integer id) {
        return dao.get(id);
    }

    @Override
    public void remove(Integer id) {
        dao.delete(id);
    }

    @Override
    public float getAverageRemark(Integer imageId) {
        return dao.getAverageScore(imageId);
    }

    @Override
    public List<Integer> getRemarkbyPostmodel(Integer PostId)
    {
        return dao.getRemarkbyPostmodel(PostId);
    }

    @Override
    public List<Integer> getRemarkbyUsermodel(Integer UserId)
    {
        return ParseHelper.remarkModelToInteger(dao.getRemarkbyUsermodel(UserId));
    }

    @Override
    public List<Integer> getRemarkbyUsermodelandPostmodel(Integer UserId,Integer PostId)
    {
        return dao.getRemarkbyUsermodelandPostmodel(UserId, PostId);
    }
}
