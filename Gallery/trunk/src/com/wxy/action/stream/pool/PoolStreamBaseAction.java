package com.wxy.action.stream.pool;

import VO.Poolmodel;
import com.wxy.action.stream.StreamBaseAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-17
 * Time: 下午10:46
 * To change this template use File | Settings | File Templates.
 */
public class PoolStreamBaseAction extends StreamBaseAction
{
    private List<Poolmodel> poolList = new ArrayList<Poolmodel>();
    public List<Poolmodel> getPoolList()
    {
        return this.poolList;
    }

}
