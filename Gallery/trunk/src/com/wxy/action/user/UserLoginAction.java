package com.wxy.action.user;

import VO.Usermodel;
import com.opensymphony.xwork2.ActionSupport;
import com.wxy.md5.MD5Util;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.IAccountService;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

//import org.shinshi.gallery.model.UserModel;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-21
 * Time: 下午5:21
 * To change this template use File | Settings | File Templates.
 */
public class UserLoginAction extends ActionSupport implements SessionAware
{
    public UserLoginAction()
    {
        super();
//        System.out.println("aaa");
    }
    public UserLoginAction(IAccountService service)
    {
        super();
        this.setAccountService(service);
//        System.out.println("bbb");
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
    public Usermodel getUser(){return this.user;}
    public void setUser(Usermodel user){this.user = user;}
    public IAccountService getAccountService(){return this.accountService;}
    public void setAccountService(IAccountService accountService){this.accountService = accountService;}

    @Override
    public String execute()
    {

        try
        {
            String password = MD5Util.getMD5String(getUser().getPassword());
            getUser().setPassword(password);

            Serializable userId = getAccountService().login(getUser());

            setUser((Usermodel)getAccountService().get(userId));
            java.sql.Timestamp date = new Timestamp(new Date().getTime());
            getUser().setLastLoginAt(date);
            getAccountService().updateInfo(getUser());
            getSession().put("UserModel",getUser());

            return SUCCESS;
        }
        catch (Exception e)
        {
//            e.printStackTrace();

            return ERROR;
        }

    }

    @Override
    public void validate()
    {
        if (getUser().getName().length() == 0)
        {
            addFieldError("user.name","UserName is required.");
        }
        if (getUser().getPassword().length() == 0)
        {
            addFieldError("user.password","Password is required.");
        }
    }
}
