package org.shinshi.gallery.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-7
 * Time: 下午8:39
 * To change this template use File | Settings | File Templates.
 */
/**
 * 图片描述信息接口
 *
 * @param <DES> 图片描述信息类型
 * @param <PK> 主键类型
 */
public interface DescriptionService <PK extends Serializable, DES extends Serializable>
{
    public PK save(DES description);
    public void remove(PK id);      //TODO 自动解除与图片之间的关联？
    public DES get(PK id);
    public List<PK> getImageDes(PK imageId);    //TODO 或者把返回值类型改成 List<DES>? 另外需要按时间排序
    public void update(DES description);


    public List<PK> getByPostId(PK id);
    public List<PK> getByUserId(PK id);
    public List<PK> search(String keyword);
}
