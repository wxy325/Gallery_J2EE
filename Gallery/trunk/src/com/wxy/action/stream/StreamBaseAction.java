package com.wxy.action.stream;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-17
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
public class StreamBaseAction extends ActionSupport
{
    private Integer currentPage;
    public void setCurrentPage(Integer currentPage)
    {
        this.currentPage = currentPage;
    }
    public Integer getCurrentPage()
    {
        return this.currentPage;
    }
    public Integer getPreviewPage()
    {
        return this.currentPage - 1;
    }
    public Integer getNextPage()
    {
        return this.currentPage + 1;
    }


    private List<Integer> showPages = new ArrayList<Integer>();
    public List<Integer> getShowPages()
    {
        return this.showPages;
    }


}
