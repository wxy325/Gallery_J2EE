package org.shinshi.gallery.service.Impl;

import VO.Postmodel;
import org.shinshi.gallery.dao.ImageDao;
import org.shinshi.gallery.helper.ParseHelper;
import org.shinshi.gallery.service.ImageService;

import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-6-18
 * Time: 下午3:34
 */
public class ImageServiceImpl implements ImageService<Postmodel, Integer> {
    private ImageDao dao;

    public ImageServiceImpl(ImageDao dao) {
        this.dao = dao;
    }

    @Override
    public Integer save(Postmodel image) {
        return dao.save(image);
    }

    @Override
    public Integer update(Postmodel image) {
        dao.update(image);
        return image.getId();
    }

    @Override
    public void remove(Integer id) {
        dao.delete(id);
    }

    @Override
    public Postmodel get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Integer> getImageOfTopRemark(Integer position, Integer count) {
        return getImageOfTopRemark(position, count, null);
    }

    @Override
    public List<Integer> getImageOfTopRemark(Integer position, Integer count, Integer tagId) {
        return ParseHelper.postModelToInteger(dao.getImagebyScore(position, count, tagId));
    }

    @Override
    public List<Integer> getImageOfTopHit(Integer position, Integer count) {
        return getImageOfTopHit(position, count, null);
    }

    @Override
    public List<Integer> getImageOfTopHit(Integer position, Integer count, Integer tagId) {
        return ParseHelper.postModelToInteger(dao.getImagebyVisted(position, count, tagId));
    }

    @Override
    public List<Integer> getRecentImage(Integer position, Integer count) {
        return getRecentImage(position, count, null);
    }

    @Override
    public List<Integer> getRecentImage(Integer position, Integer count, Integer tagId) {
        return ParseHelper.postModelToInteger(dao.getImagebyDate(position, count, tagId));
    }

    @Override
    public List<Integer> getRandomImage(Integer count) {
        return getRandomImage(count, null);
    }

    @Override
    public List<Integer> getRandomImage(Integer count, Integer tagId) {
        return ParseHelper.postModelToInteger(dao.getImagebyRandom(count, tagId));
    }

    @Override
    public List<Integer> getByUserId(Integer userId) {
        return ParseHelper.postModelToInteger(dao.getAllPostByUsrId(userId));
    }

    @Override
    public List<Integer> search(String keyword)
    {
        return ParseHelper.postModelToInteger(dao.searchPostByString(keyword));
    }
}
