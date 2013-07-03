package com.wxy.action.stream.pool;

import VO.Poolmodel;
import VO.Postmodel;
import VO.Usermodel;
import com.wxy.action.stream.image.ImageStreamBaseAction;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.ImageService;
import org.shinshi.gallery.service.PoolService;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-3
 * Time: 上午5:49
 * To change this template use File | Settings | File Templates.
 */
public class OnePoolAction extends ImageStreamBaseAction implements SessionAware
{
    //Param
    private Integer poolId;
    public Integer getPoolId() {
        return poolId;
    }
    public void setPoolId(Integer poolId) {
        this.poolId = poolId;
    }

    //Constructor
    public OnePoolAction()
    {
        super();
    }
    public OnePoolAction(PoolService poolService, ImageService imageService)
    {
        super();
        this.setPoolService(poolService);
        this.setImageService(imageService);
    }

    //SessionAware
    private Map session;
    public Map getSession() {
        return session;
    }
    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    //Service
    private PoolService poolService;
    public PoolService getPoolService() {
        return poolService;
    }
    public void setPoolService(PoolService poolService) {
        this.poolService = poolService;
    }

    private ImageService imageService;
    public ImageService getImageService() {
        return imageService;
    }
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }


    private Poolmodel poolmodel;

    public Poolmodel getPoolmodel() {
        return poolmodel;
    }

    public void setPoolmodel(Poolmodel poolmodel) {
        this.poolmodel = poolmodel;
    }

    public String execute()
    {
        Usermodel user = (Usermodel) getSession().get("UserModel");
        Poolmodel poolmodel = (Poolmodel) getPoolService().get(poolId);
        if (user == null)
        {
            return INPUT;
        }
        else
        {
            if (poolmodel == null || !user.getId().equals(poolmodel.getCreatorId()))
            {
                return ERROR;
            }
            else
            {
                this.setPoolmodel(poolmodel);
                List<Integer> idList = getPoolService().getPostModelByPool(poolId);
                for (Integer id : idList)
                {
                    Postmodel postmodel = (Postmodel) getImageService().get(id);
                    getImagesList().add(postmodel);
                }
            }
        }
        return SUCCESS;
    }
}
