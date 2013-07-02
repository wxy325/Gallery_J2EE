package org.shinshi.gallery.service.Impl;

import org.shinshi.gallery.dao.IAccountDao;
//import interfacePackage.IAccountDao;
//import org.shinshi.gallery.model.UserModel;
import VO.Usermodel;
import org.shinshi.gallery.service.IAccountService;

/**
 * User: SpringNyan
 * Date: 13-5-23
 * Time: 下午2:23
 */
public class AccountServiceImpl implements IAccountService<Usermodel, Integer> {

    private IAccountDao<Usermodel, Integer> dao;

    public AccountServiceImpl(IAccountDao<Usermodel, Integer> dao) {
        this.dao = dao;
    }

    @Override
    public boolean userExists(String userName) {

        return dao.getIdByUsername(userName) != null;
    }

    @Override
    public Integer register(Usermodel model) {
        return dao.save(model);
    }

    @Override
    public Integer login(Usermodel model) {
        Integer id = dao.getIdByUsername(model.getName());
        return id != null && dao.get(id).getPassword().equals(model.getPassword()) ? id : null;
    }

    @Override
    public void updateInfo(Usermodel model) {
        dao.update(model);
    }

    @Override
    public Usermodel get(Integer id) {
        return dao.get(id);
    }
}
