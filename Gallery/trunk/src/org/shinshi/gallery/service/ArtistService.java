package org.shinshi.gallery.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-7
 * Time: 下午9:56
 * To change this template use File | Settings | File Templates.
 */
/**
 * 评论接口
 *
 * @param <M> 艺术家类型
 * @param <PK> 主键类型
 */
public interface ArtistService<M extends Serializable, PK extends  Serializable>
{
    public M get(PK id);
    public PK save(M artist);
    public void remove(PK id);
    public List<PK> getArtistImg(PK id);

}