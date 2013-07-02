package com.wxy.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-8
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */
public class UserSpaceAction extends ActionSupport implements SessionAware
{
    //Session Aware
    private Map session;
    public Map getSession(){return this.session;}
    @Override
    public void setSession(Map session)
    {
        this.session = session;
    }

    private String type;
    public String getType(){return this.type;}
    public void setType(String type){this.type = type;}



    @Override
    public String execute()
    {
        try
        {
//            System.out.print(this.getType());
            if (this.getSession().get("UserModel") == null)
            {
                return INPUT;
            }
            return this.getType();
        }
        catch (Exception e)
        {
            return ERROR;
        }

    }

}
