package com.wxy.action.single;

import VO.Descriptionids;
import VO.Postmodel;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.DescriptionService;
import org.shinshi.gallery.service.ImageService;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-2
 * Time: 上午11:01
 * To change this template use File | Settings | File Templates.
 */
public class SingleEditDescriptionAction extends ActionSupport implements SessionAware
{
    //Constructor
    public SingleEditDescriptionAction()
    {
        super();
    }
    public SingleEditDescriptionAction(ImageService imageService, DescriptionService descriptionService)
    {
        super();
        this.setImageService(imageService);
        this.setDescriptionService(descriptionService);
    }

    //Param
    private Integer imageId;
    public Integer getImageId() {
        return imageId;
    }
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
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
    private DescriptionService descriptionService;

    public ImageService getImageService() {
        return imageService;
    }
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }
    public DescriptionService getDescriptionService() {
        return descriptionService;
    }
    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }



    private Postmodel postmodel;
    public Postmodel getPostmodel() {
        return postmodel;
    }
    public void setPostmodel(Postmodel postmodel) {
        this.postmodel = postmodel;
    }
    private List<Descriptionids> descriptionList;
    public List<Descriptionids> getDescriptionList() {
        return descriptionList;
    }
    public void setDescriptionList(List<Descriptionids> descriptionList) {
        this.descriptionList = descriptionList;
    }




    //Action Support
    public String execute()
    {

        try {
            setPostmodel((Postmodel)getImageService().get(imageId));
            if (getPostmodel() == null)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            return ERROR;
        }

        this.setDescriptionList(this.getDescriptionService().getImageDes(getPostmodel().getId()));
        return SUCCESS;
    }
}
