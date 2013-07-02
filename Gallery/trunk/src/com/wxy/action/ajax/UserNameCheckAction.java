package com.wxy.action.ajax;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.json.annotations.JSON;
import org.shinshi.gallery.service.IAccountService;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-2
 * Time: 下午6:32
 * To change this template use File | Settings | File Templates.
 */
public class UserNameCheckAction extends ActionSupport
{
    //Param
    private String userName;
    @JSON(serialize=false)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    //Service
    private IAccountService accountService;
    @JSON(serialize=false)
    public IAccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
    //Constructor
    public UserNameCheckAction()
    {
        super();
    }
    public UserNameCheckAction(IAccountService accountService)
    {
        super();
        this.setAccountService(accountService);
    }

    //Result
    private Boolean result;
    public Boolean getResult() {
        return result;
    }
    public void setResult(Boolean result) {
        this.result = result;
    }

    //Action Support
    public String execute()
    {
        this.setResult(this.accountService.userExists(this.getUserName()));
        return SUCCESS;
    }
}
