package com.wxy.action.stream.image;

import VO.Postmodel;
import org.shinshi.gallery.service.ImageService;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-1
 * Time: 下午10:29
 * To change this template use File | Settings | File Templates.
 */
public class RandomImageStreamAction extends ImageStreamBaseAction
{
    //Constructor
    public RandomImageStreamAction()
    {
        super();
    }

    public RandomImageStreamAction(ImageService imageService)
    {
        super();
        this.setImageService(imageService);
    }

    //Service
    private ImageService imageService;
    public ImageService getImageService(){return this.imageService;}
    public void setImageService(ImageService imageService){this.imageService = imageService;}

    @Override
    public String execute()
    {
        List<Serializable> idList = imageService.getRandomImage(20);
        for (Serializable id : idList)
        {
            getImagesList().add((Postmodel)getImageService().get(id));
        }

        return SUCCESS;
    }

}
