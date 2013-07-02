package com.wxy.action.ajax;

import VO.Remarkids;
import VO.Usermodel;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.shinshi.gallery.service.ImageService;
import org.shinshi.gallery.service.RemarkService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-1
 * Time: 下午6:51
 * To change this template use File | Settings | File Templates.
 */
public class ImageAddRemarkAction extends ActionSupport implements SessionAware
{
    //Param
    private Integer postId;
    private Integer score;
    @JSON(serialize=false)
    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    @JSON(serialize=false)
    public Integer getScore() {
        return score;
    }
    public void setScore(Integer score) {
        this.score = score;
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
    private ImageService imageService;
    private RemarkService remarkService;
    @JSON(serialize=false)
    public ImageService getImageService() {
        return imageService;
    }
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }
    @JSON(serialize=false)
    public RemarkService getRemarkService() {
        return remarkService;
    }
    public void setRemarkService(RemarkService remarkService) {
        this.remarkService = remarkService;
    }

    //Constructor
    public ImageAddRemarkAction()
    {
        super();
    }
    public ImageAddRemarkAction(ImageService imageService, RemarkService remarkService)
    {
        super();
        setImageService(imageService);
        setRemarkService(remarkService);
    }

    //Result
    private Boolean success;
    private Float avgRemark;

    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public Float getAvgRemark() {
        return avgRemark;
    }
    public void setAvgRemark(Float avgRemark) {
        this.avgRemark = avgRemark;
    }

    public String execute()
    {
        if (getImageService().get(getPostId()) == null)
        {
            setSuccess(false);
            return SUCCESS;
        }

        Remarkids remark = new Remarkids();
        remark.setPictureId(getPostId());
        remark.setRemark(getScore());
        java.sql.Timestamp date = new Timestamp(new Date().getTime());
        remark.setDate(date);
        try
        {
            Usermodel  currentUser = (Usermodel) getSession().get("UserModel");
            remark.setOwnerId(currentUser.getId());
        }
        catch (Exception e){}
        try
        {
            getRemarkService().save(remark);
            float avg = getRemarkService().getAverageRemark(getPostId());
            setAvgRemark(avg);
            this.setSuccess(true);
        }
        catch (Exception e)
        {
            this.setSuccess(false);
        }
        return SUCCESS;
    }
}
