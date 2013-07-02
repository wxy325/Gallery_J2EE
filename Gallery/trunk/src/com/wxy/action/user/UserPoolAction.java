package com.wxy.action.user;

import VO.Poolmodel;
import VO.Usermodel;
import com.wxy.action.stream.pool.PoolStreamBaseAction;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.PoolService;

import java.util.ArrayList;
import java.util.List;
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
    public UserPoolAction()
    {
        super();
    }
    public UserPoolAction(PoolService poolService)
    {
        super();
        setPoolService(poolService);
    }

    //Session Aware
    private Map session;
    public Map getSession(){return this.session;}
    @Override
    public void setSession(Map session)
    {
        this.session = session;
    }

    //Service
    private PoolService poolService;
    public PoolService getPoolService() {
        return poolService;
    }
    public void setPoolService(PoolService poolService) {
        this.poolService = poolService;
    }


    private List<Poolmodel> poolList = new ArrayList<Poolmodel>();
    public List<Poolmodel> getPoolList() {
        return poolList;
    }
    public void setPoolList(List<Poolmodel> poolList) {
        this.poolList = poolList;
    }

    @Override
    public String execute()
    {
        Usermodel user = (Usermodel)getSession().get("UserModel");
        if (user == null)
        {
            return ERROR;
        }
        List<Integer> poolIds = getPoolService().getUserPool(user.getId());
        for (Integer id : poolIds)
        {
            Poolmodel pool = (Poolmodel)getPoolService().get(id);
            this.getPoolList().add(pool);
        }

        return SUCCESS;
    }


}
