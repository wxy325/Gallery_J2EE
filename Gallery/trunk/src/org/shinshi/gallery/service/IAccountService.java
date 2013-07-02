package org.shinshi.gallery.service;

import java.io.Serializable;

/**
 * User: SpringNyan
 * Date: 13-4-17
 * Time: 下午1:24
 */
/**
 * 用户接口
 *
 * @param <M> 用户信息类型
 * @param <PK> 主键类型
 */
public interface IAccountService<M extends Serializable, PK extends Serializable> {
    public boolean userExists(String userName);
    public PK register(M model);
    public PK login(M model);
    public void updateInfo(M model);
    public M get(PK id);
}
