package org.shinshi.gallery.service.Impl;

import VO.Poolmodel;
import org.shinshi.gallery.dao.PoolDao;
import org.shinshi.gallery.helper.ParseHelper;
import org.shinshi.gallery.service.PoolService;

import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-6-18
 * Time: 下午3:45
 */
public class PoolServiceImpl implements PoolService<Poolmodel, Integer> {
    private PoolDao dao;

    public PoolServiceImpl(PoolDao dao) {
        this.dao = dao;
    }

    @Override
    public Integer save(Poolmodel poolmodel) {
        return dao.save(poolmodel);
    }

    @Override
    public void remove(Integer id) {
        dao.delete(id);
    }

    @Override
    public void addImage(Integer poolId, Integer imageId) {
        dao.AddImage(poolId, imageId);
    }

    @Override
    public List<Integer> getUserPool(Integer creatorId) {
        return ParseHelper.poolModelToInteger(dao.getPoolbyuser(creatorId));
    }

    @Override
    public void addPostModel(Integer poolId,Integer postId)
    {
        dao.AddImage(postId, poolId);
    }

    @Override
    public List<Integer> getPostModelByPool(Integer poolId)
    {
        return ParseHelper.postModelToInteger(dao.getPostmodelbyPool(poolId));
    }
}
