package org.shinshi.gallery.service.Impl;

import VO.Tagmodel;
import org.shinshi.gallery.dao.TagDao;
import org.shinshi.gallery.helper.ParseHelper;
import org.shinshi.gallery.service.TagService;

import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-6-18
 * Time: 下午3:49
 */
public class TagServiceImpl implements TagService<Tagmodel, Integer> {
    private TagDao dao;

    public TagServiceImpl(TagDao dao) {
        this.dao = dao;
    }

    @Override
    public Integer save(Tagmodel tagmodel) {
        return dao.save(tagmodel);
    }

    @Override
    public Tagmodel get(Integer id) {
        return dao.get(id);
    }

    @Override
    public Tagmodel get(String tagString) {
        return dao.getTagbyName(tagString);
    }

    @Override
    public List<Integer> getImageTag(Integer imageId) {
//        List aa = dao.getAllTagByPostId(imageId);
//        System.out.println(aa.size());
        return ParseHelper.tagModelToInteger(dao.getAllTagByPostId(imageId));
    }

    @Override
    public void addTagToImage(Integer imageId, Integer tagId) {
        dao.AttachTagtoPostmodel(imageId, tagId);
    }

    @Override
    public void removeTagFromImage(Integer imageId, Integer tagId) {
        dao.DeleteTagfromPostmodel(imageId, tagId);
    }

    @Override
    public List<Integer> searchTag(String keyword)
    {
        return ParseHelper.tagModelToInteger(dao.searchTagByString(keyword));
    }
}
