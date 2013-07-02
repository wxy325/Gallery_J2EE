package com.wxy.action.user;

import com.wxy.action.stream.pool.PoolStreamBaseAction;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-17
 * Time: 下午9:06
 * To change this template use File | Settings | File Templates.
 */
public class UserPoolAction  extends PoolStreamBaseAction implements SessionAware
{
    //Session Aware
    private Map session;
    public Map getSession(){return this.session;}
    @Override
    public void setSession(Map session)
    {
        this.session = session;
    }
    @Override
    public String execute()
    {
        return SUCCESS;
    }
}
