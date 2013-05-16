package org.shinshi.gallery.service;

import java.io.Serializable;

/**
 * User: SpringNyan
 * Date: 13-4-17
 * Time: 下午1:24
 */
public interface IAccountService<M extends Serializable, PK extends Serializable> {
    public void register(M model);
    public void login(M model);
    public void updateInfo(M model);
    public void updateSecurity(M model);
    public M get(PK id);
}
