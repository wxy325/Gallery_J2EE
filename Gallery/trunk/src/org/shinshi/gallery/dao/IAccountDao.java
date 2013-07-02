package org.shinshi.gallery.dao;


import java.io.Serializable;
import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-5-23
 * Time: 下午2:29
 */
public interface IAccountDao<M extends Serializable, PK extends Serializable> extends IBaseDao<M, PK> {
    public PK getIdByUsername(String name);
}
