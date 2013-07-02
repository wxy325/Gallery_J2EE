package org.shinshi.gallery.dao;

import VO.Commentsids;

import java.util.List;

public interface CommentDao  extends IBaseDao<Commentsids,Integer>  {
    public List<Commentsids> getCommentbyPostId(Integer id);
    public List<Commentsids> getCommentbyUserId(Integer id);
    public List<Commentsids> searchCommentByString(String string);
}
