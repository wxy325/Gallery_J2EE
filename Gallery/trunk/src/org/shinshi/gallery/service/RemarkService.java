package org.shinshi.gallery.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-7
 * Time: 下午8:48
 * To change this template use File | Settings | File Templates.
 */
/**
 * 评分接口
 *
 * @param <REMARK> 图片描述信息类型
 * @param <PK> 主键类型
 */
public interface RemarkService<REMARK extends Serializable, PK extends Serializable>
{
    public PK save(REMARK remark);
    public REMARK get(PK id);
    public void remove(PK id);

    public float getAverageRemark(PK imageId);

    public List<PK> getRemarkbyPostmodel(PK PostId);
    public List<PK> getRemarkbyUsermodel(PK UserId);
    public List<PK> getRemarkbyUsermodelandPostmodel(PK UserId,PK PostId);

}
