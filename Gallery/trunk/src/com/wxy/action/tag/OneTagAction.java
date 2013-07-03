package com.wxy.action.tag;

import VO.Postmodel;
import VO.Tagmodel;
import com.wxy.action.stream.image.ImageStreamBaseAction;
import org.shinshi.gallery.service.ImageService;
import org.shinshi.gallery.service.TagService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-3
 * Time: 上午8:13
 * To change this template use File | Settings | File Templates.
 */
public class OneTagAction extends ImageStreamBaseAction
{
    //Param
    private Integer tagId;
    public Integer getTagId() {
        return tagId;
    }
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }


    //Service
    private TagService tagService;
    private ImageService imageService;

    public TagService getTagService() {
        return tagService;
    }
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }
    public ImageService getImageService() {
        return imageService;
    }
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    //Constructor
    public OneTagAction()
    {
        super();
    }
    public OneTagAction(TagService tagService,ImageService imageService)
    {
        super();
        this.setTagService(tagService);
        this.setImageService(imageService);
    }

    //Model
    private Tagmodel tagmodel;
    public Tagmodel getTagmodel() {
        return tagmodel;
    }
    public void setTagmodel(Tagmodel tagmodel) {
        this.tagmodel = tagmodel;
    }

    public String execute()
    {
        Tagmodel tag = null;
        try
        {
            tag = (Tagmodel) getTagService().get(tagId);
            this.setTagmodel(tag);
        }
        catch (Exception e){}
        if (tag == null)
        {
            return ERROR;
        }



        Integer totalCount = getTagService().countTag(tag.getId());
        int totalPage = totalCount / 20 + 1;
        int from = 0, to = 0;
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

        idList = getImageService().getImageOfTopRemark(from,to - from, tag.getId());
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
