package org.shinshi.gallery.service;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-7
 * Time: 下午8:38
 * To change this template use File | Settings | File Templates.
 */

import java.io.Serializable;
import java.util.List;

/**
 * 评论接口
 *
 * @param <COMMENT> 评论类型
 * @param <PK> 主键类型
 */

public interface CommentService <PK extends  Serializable, COMMENT extends  Serializable>
{
    public PK save(COMMENT comment);
    public void remove(PK id);      //TODO 自动解除与图片之间的关联？
    public COMMENT get(PK id);
    public List<PK> getImageComment(PK imageId);    //TODO 或者把返回值类型改成 List<COMMENT>? 另外需要按时间排序

    public List<PK> getByPostId(PK id);
    public List<PK> getByUserId(PK id);
    public List<PK> search(String keyword);

}
