package com.wxy.action.search;

import VO.Postmodel;
import com.wxy.action.stream.image.ImageStreamBaseAction;
import org.shinshi.gallery.service.ImageService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-3
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
public class TitleSearch  extends ImageStreamBaseAction
{
    //Param
    private String keyword;
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    //Constructor
    public TitleSearch()
    {
        super();
    }
    public TitleSearch(ImageService imageService)
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

    public String execute()
    {
        if (getCurrentPage() == null)
        {
            setCurrentPage(0);
        }
        List<Integer> idList =  getImageService().search(getKeyword());

        int from = 0, to = 0;

        int totalCount = idList.size();

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

        for (int i = from; i < to; i++)
        {
            Postmodel postmodel = (Postmodel)getImageService().get(idList.get(i));
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
