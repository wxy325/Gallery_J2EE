package com.wxy.action.user;

import VO.Usermodel;
import com.opensymphony.xwork2.ActionSupport;
import com.wxy.md5.MD5Util;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.IAccountService;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-19
 * Time: 下午1:05
 * To change this template use File | Settings | File Templates.
 */
public class UserEditAction extends ActionSupport implements SessionAware
{
    public UserEditAction()
    {
        super();
    }
    public UserEditAction(IAccountService service)
    {
        super();
        this.setAccountService(service);
    }

    //Session Aware
    private Map session;
    public Map getSession(){return this.session;}
    @Override
    public void setSession(Map session)
    {
        this.session = session;
    }

    private Usermodel user;
    private IAccountService accountService;
    private String newPassword;
    private String rePassword;

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Usermodel getUser() {
        return user;
    }

    public void setUser(Usermodel user) {
        this.user = user;
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }


    @Override
    public String execute()
    {

        try
        {
            Usermodel u = getUser();
            Usermodel currentUser = (Usermodel)session.get("UserModel");
            u.setName(currentUser.getName());
            String password = MD5Util.getMD5String(u.getPassword());
            u.setPassword(password);
            Integer userId = (Integer)getAccountService().login(u);

            if (userId.intValue() == currentUser.getId().intValue())
            {
                currentUser.setPassword(MD5Util.getMD5String(this.getNewPassword()));
                getAccountService().updateInfo(currentUser);
                return SUCCESS;
            }
            else
            {
                return INPUT;
            }
        }
        catch (Exception e)
        {

            return ERROR;
        }

    }

    @Override
    public void validate()
    {

    }

}
