package org.shinshi.gallery.service.Impl;

import VO.Commentsids;
import org.shinshi.gallery.dao.CommentDao;
import org.shinshi.gallery.helper.ParseHelper;
import org.shinshi.gallery.service.CommentService;

import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-6-18
 * Time: 下午3:23
 */
public class CommentServiceImpl implements CommentService<Integer, Commentsids> {

    private CommentDao dao;

    public CommentServiceImpl(CommentDao dao) {
        this.dao = dao;
    }

    @Override
    public Integer save(Commentsids commentsids) {
        return dao.save(commentsids);
    }

    @Override
    public void remove(Integer id) {
        dao.delete(id);
    }

    @Override
    public Commentsids get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Integer> getImageComment(Integer imageId) {

        return ParseHelper.commentModelToInteger(dao.getCommentbyPostId(imageId));
    }

    public List<Integer> getByPostId(Integer id)
    {
        return ParseHelper.commentModelToInteger(dao.getCommentbyPostId(id));
    }
    public List<Integer> getByUserId(Integer id)
    {
        return ParseHelper.commentModelToInteger(dao.getCommentbyUserId(id));
    }
    public List<Integer> search(String keyword)
    {
        return ParseHelper.commentModelToInteger(dao.searchCommentByString(keyword));
    }
}
