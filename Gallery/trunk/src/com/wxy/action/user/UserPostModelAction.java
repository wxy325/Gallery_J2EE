package com.wxy.action.user;

import VO.Postmodel;
import VO.Usermodel;
import com.wxy.action.stream.image.ImageStreamBaseAction;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.ImageService;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-17
 * Time: 下午9:06
 * To change this template use File | Settings | File Templates.
 */
public class UserPostModelAction extends ImageStreamBaseAction implements SessionAware
{
    //Constructor
    public UserPostModelAction()
    {
        super();
    }
    public UserPostModelAction(ImageService imageService)
    {
        super();
        setImageService(imageService);
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


    //Action Support
    public String execute()
    {
        Usermodel usermodel = (Usermodel)getSession().get("UserModel");
        List<Integer> idList = getImageService().getByUserId(usermodel.getId());

        int from = 0, to = 0;

        int totalPage = idList.size() / 20 + 1;
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
        if (to > idList.size())
        {
            to = idList.size();
        }

        for (int i = from; i < to; i++ )
        {
            Integer postId = idList.get(i);
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
