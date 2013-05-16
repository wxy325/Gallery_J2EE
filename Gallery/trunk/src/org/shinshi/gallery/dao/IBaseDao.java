package org.shinshi.gallery.dao;

import java.io.Serializable;
import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-4-17
 * Time: 下午6:04
 */

/**
 * 基本DAO接口
 *
 * @param <M> 模型类型
 * @param <PK> 主键类型
 */
public interface IBaseDao<M extends Serializable, PK extends Serializable> {
    public PK save(M model);
    public void update(M model);
    public void delete(PK id);
    public M get(PK id);
    public int countAll();
    public List<M> listAll();
    public List<M> listPage(int pageNumber, int pageSize);
}
