package com.wxy.action.ajax;

import VO.Poolmodel;
import VO.Usermodel;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.shinshi.gallery.service.PoolService;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-3
 * Time: 上午6:00
 * To change this template use File | Settings | File Templates.
 */
public class UserAddPoolAction extends ActionSupport  implements SessionAware
{
    //Param
    private String poolName;
    @JSON(serialize=false)
    public String getPoolName() {
        return poolName;
    }
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    //Constructor
    public UserAddPoolAction()
    {
        super();
    }
    public UserAddPoolAction(PoolService poolService)
    {
        super();
        this.setPoolService(poolService);
    }

    //SessionAware
    private Map session;
    @JSON(serialize=false)
    public Map getSession() {
        return session;
    }
    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    //Service
    private PoolService poolService;
    @JSON(serialize=false)
    public PoolService getPoolService() {
        return poolService;
    }
    public void setPoolService(PoolService poolService) {
        this.poolService = poolService;
    }

    //result
    private Boolean success;
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String execute()
    {
        Usermodel user = (Usermodel)getSession().get("UserModel");
        if (user == null)
        {
            this.setSuccess(false);
            return SUCCESS;
        }

        Poolmodel pool = new Poolmodel();
        pool.setName(getPoolName());
        pool.setCreatorId(user.getId());
        getPoolService().save(pool);
        this.setSuccess(true);
        return SUCCESS;
    }
}
