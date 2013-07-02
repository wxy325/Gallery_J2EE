package org.shinshi.gallery.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-23
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */

/**
 * 标签接口
 *
 * @param <TAG> 图片描述信息类型
 * @param <PK> 主键类型
 */

public interface TagService <TAG extends Serializable, PK extends Serializable>
{
    public PK save(TAG tag);
    public TAG get(PK id);
    public TAG get(String tagString);
    public List<PK> getImageTag(PK imageId);
    public void addTagToImage(PK tagId ,PK imageId);
    public void removeTagFromImage(PK imageId, PK tagId);

//    public Integer countTag(Integer id);
    public List<PK> searchTag(String keyword);


}
