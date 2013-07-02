package com.wxy.action.stream.image;

import VO.Postmodel;
import org.shinshi.gallery.service.ImageService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-3
 * Time: 上午4:16
 * To change this template use File | Settings | File Templates.
 */
public class ImageRankStreamAction extends ImageStreamBaseAction
{
    //Constructor
    public ImageRankStreamAction()
    {
        super();
    }
    public ImageRankStreamAction(ImageService imageService)
    {
        super();
        this.setImageService(imageService);
    }

    //Service
    private ImageService imageService;
    public ImageService getImageService() {
        return imageService;
    }
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    //Param
    private String streamType;
    public void setStreamType(String streamType)
    {
        this.streamType = streamType;
    }
    public String getStreamType()
    {
        return this.streamType;
    }


    //Action Support
    public String execute()
    {

        int from = 0, to = 0;

        int totalCount = getImageService().countAll();
        int totalPage = totalCount / 20 + 1;

        if (getCurrentPage() >= totalPage)
        {
            setCurrentPage(totalPage - 1);
        }
        if (getCurrentPage() < 0)
        {
            setCurrentPage(0);
        }
        from = getCurrentPage() * 20;
        to = (getCurrentPage() + 1) * 20;
        if (to > totalCount)
        {
            to = totalCount;
        }

        List<Integer> idList = null;

        if (this.streamType.equals("New"))  //最新上传
        {
            idList = getImageService().getRecentImage(from,to - from);
        }
        else if (this.streamType.equals("TopHit"))
        {
            idList = getImageService().getImageOfTopHit(from,to - from);
        }
        else if (this.streamType.equals("TopRate"))
        {
            idList = getImageService().getImageOfTopRemark(from,to - from);
        }

        for (Integer postId : idList)
        {
            Postmodel postmodel = (Postmodel)getImageService().get(postId);
            getImagesList().add(postmodel);
        }


        int pageFrom = getCurrentPage() - 5;
        int pageTo = getCurrentPage() + 5;
        if(pageFrom < 0)
        {
            pageFrom = 0;
        }
        if (pageTo > totalPage)
        {
            pageTo = totalPage;
        }

        for (int i = pageFrom; i < pageTo; i++)
        {
            getShowPages().add(i);
        }


        return SUCCESS;
    }

}
