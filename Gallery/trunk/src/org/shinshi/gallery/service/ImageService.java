package org.shinshi.gallery.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-23
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */


/**
 * 图片接口
 *
 * @param <IMG> 图片类型 PostModel
 * @param <PK> 主键类型
 */


public interface ImageService  <IMG extends Serializable, PK extends Serializable>
{
    public PK save(IMG image);
    public PK update(IMG image);
    public void remove(PK id);
    public IMG get(PK id);

    //获取图片方法
    //position 起始位置
    //count 数量
    //即获取排名从position到position + count - 1 的图片
    public List<PK> getImageOfTopRemark(Integer position, Integer count);   //按平均得分从高到底排列
    public List<PK> getImageOfTopRemark(Integer position, Integer count, PK tagId);    //可以考虑和上面一个接口合起来，TagId == null 时为不限制

    public List<PK> getImageOfTopHit(Integer position, Integer count);      //按点击量排序
    public List<PK> getImageOfTopHit(Integer position, Integer count, PK tagId);

    public List<PK> getRecentImage(Integer position, Integer count);        //按时间排序，最新的排在最前面
    public List<PK> getRecentImage(Integer position, Integer count, PK tagId);

    public List<PK> getRandomImage(Integer count);      //随机获取count张图片
    public List<PK> getRandomImage(Integer count, PK tagId);


    public List<PK> getByUserId(PK userId);
    public List<PK> search(String keyword);


}
