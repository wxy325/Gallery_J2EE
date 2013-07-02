package org.shinshi.gallery.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-7
 * Time: 下午9:21
 * To change this template use File | Settings | File Templates.
 */
/**
 * Pool接口
 *
 * @param <POOL> 图片类型 PostModel
 * @param <PK> 主键类型
 */
public interface PoolService <POOL extends Serializable, PK extends Serializable>
{
    public PK save(POOL pool);          //pool带创建者
    public void remove(PK id);
    public void addImage(PK poolId, PK imageId);

    public List<PK> getUserPool(PK creatorId);
    public void addPostModel(PK poolId,PK postId);
    public List<PK> getPostModelByPool(PK poolId);

}
