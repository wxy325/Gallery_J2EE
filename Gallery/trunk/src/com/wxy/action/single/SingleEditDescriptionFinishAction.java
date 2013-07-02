package com.wxy.action.single;

import VO.Descriptionids;
import VO.Usermodel;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.DescriptionService;
import org.shinshi.gallery.service.ImageService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-2
 * Time: 下午8:55
 * To change this template use File | Settings | File Templates.
 */
public class SingleEditDescriptionFinishAction extends ActionSupport implements SessionAware
{
    //Param
    private Integer imageId;
    public Integer getImageId() {
        return imageId;
    }
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    private String descriptionStr;
    public String getDescriptionStr() {
        return descriptionStr;
    }
    public void setDescriptionStr(String descriptionStr) {
        this.descriptionStr = descriptionStr;
    }

    //Constructor
    public SingleEditDescriptionFinishAction()
    {
        super();
    }
    public SingleEditDescriptionFinishAction(ImageService imageService,
                                             DescriptionService descriptionService)
    {
        super();
        setImageService(imageService);
        setDescriptionService(descriptionService);
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
    private ImageService imageService;
    public ImageService getImageService() {
        return imageService;
    }
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    private DescriptionService descriptionService;
    public DescriptionService getDescriptionService() {
        return descriptionService;
    }
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    //Action Support
    public String execute()
    {
        try
        {
            if (getImageService().get(getImageId()) == null)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            return ERROR;
        }

        Descriptionids des = new Descriptionids();
        des.setDescription(getDescriptionStr());
        des.setPictureId(getImageId());

        Usermodel currentUser = null;
        try
        {
            currentUser = (Usermodel)getSession().get("UserModel");
            des.setOwnerId(currentUser.getId());
        }
        catch (Exception e){}
        java.sql.Timestamp date = new Timestamp(new Date().getTime());
        des.setDate(date);
        getDescriptionService().save(des);
        return SUCCESS;
    }
}
