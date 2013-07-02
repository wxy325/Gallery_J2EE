package com.wxy.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-21
 * Time: 下午5:21
 * To change this template use File | Settings | File Templates.
 */
public class UserLogoutAction extends ActionSupport implements SessionAware
{
    //SessionAware
    private Map session;
    public Map getSession(){return this.session;}
    public void setSession(Map session){this.session = session;}

    public String execute()
    {
        getSession().remove("UserModel");

        return SUCCESS;
    }
}
