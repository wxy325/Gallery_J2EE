package com.wxy.action.user;

//Struts2
import com.opensymphony.xwork2.ActionSupport;
import com.wxy.md5.MD5Util;
import org.apache.struts2.interceptor.SessionAware;
//import org.shinshi.gallery.model.UserModel;
//import org.shinshi.gallery.model.UserRole;
import VO.Usermodel;
import org.shinshi.gallery.service.IAccountService;


import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

//Model

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-20
 * Time: 下午5:58
 * To change this template use File | Settings | File Templates.
 */


public class UserRegisterAction extends ActionSupport implements SessionAware
{
    //Data Member
    private Usermodel user;
    private IAccountService accountService;
    private Map session;
    private String testPassword;

    //Getter And Setter Method
    public Usermodel getUser(){return this.user;}
    public void setUser(Usermodel user){this.user = user;}
    public IAccountService getAccountService(){return this.accountService;}
    public void setAccountService(IAccountService accountService){this.accountService = accountService;}
    public Map getSession(){return this.session;}
    public void setSession(Map session){this.session = session;}
    public String getTestPassword(){return this.testPassword;}
    public void setTestPassword(String testPassword){this.testPassword = testPassword;}

    //Constructor
    public UserRegisterAction(){super();}
    public UserRegisterAction(IAccountService accountService)
    {
        super();
        this.setAccountService(accountService);
    }

    //ActionSupport
    public String execute()
    {
//        Date date = new Date();

        java.sql.Timestamp date = new Timestamp(new Date().getTime());
//        long time = System.currentTimeMillis();
        getUser().setJoinedAt(date);
        getUser().setLastLoginAt(date);
//        getUser().setRo(Usermodel.RoleMEMBER);

        String password = MD5Util.getMD5String(getUser().getPassword());
        getUser().setPassword(password);
        try
        {
            getAccountService().register(getUser());
            synchronized (getSession())
            {
                getSession().put("UserModel",getUser());
            }
            return SUCCESS;
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return ERROR;
        }
    }



    public void validate()
    {
        if (getUser().getPassword().length() == 0)
        {
            addFieldError("user.password","Password is required.");
        }
        if (getUser().getEmail().length() == 0)
        {
            addFieldError("user.email","Email is required.");
        }
        if (getUser().getName().length() == 0)
        {
            addFieldError("user.name","UserName is required.");
        }

        if (getAccountService().userExists(getUser().getName()))
        {
            addFieldError("user.name","UserName exist, please changed it.");
        }

        if (!getTestPassword().equals(getUser().getPassword()))
        {
            addFieldError("testPassword","password must the same");
        }
    }


}
