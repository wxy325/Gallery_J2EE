package com.wxy.action.single;

import VO.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-2
 * Time: 上午12:43
 * To change this template use File | Settings | File Templates.
 */
public class SingleImageAction extends ActionSupport implements SessionAware
{
    //Constructor
    public SingleImageAction()
    {
        super();
    }
    public SingleImageAction(ImageService imageService,
                             IAccountService iAccountService,
                             ArtistService artistService,
                             DescriptionService descriptionService,
                             CommentService commentService,
                             RemarkService remarkService,
                             TagService tagService,
                             PoolService poolService)
    {
        super();
        this.setImageService(imageService);
        this.setAccountService(iAccountService);
        this.setArtistService(artistService);
        this.setDescriptionService(descriptionService);
        this.setCommentService(commentService);
        this.setRemarkService(remarkService);
        this.setTagService(tagService);
        this.setPoolService(poolService);
    }


    //param
    private Integer imageId;
    public Integer getImageId(){return this.imageId;}
    public void setImageId(Integer imageId) {this.imageId = imageId;}

    //Session Aware
    private Map session;
    public Map getSession(){return this.session;}
    @Override
    public void setSession(Map session)
    {
        this.session = session;
    }

    //Model
    //Post
    private Postmodel postmodel;
    public Postmodel getPostmodel(){return this.postmodel;}
    public void setPostmodel(Postmodel postmodel){this.postmodel = postmodel;}
    //User
    private Usermodel creator;
    public Usermodel getCreator(){ return this.creator;}
    public void setCreator(Usermodel creator){this.creator = creator;}
    //Artist
    private Artistmodel artistmodel;
    public Artistmodel getArtistmodel(){return this.artistmodel;}
    public void setArtistmodel(Artistmodel artistmodel){this.artistmodel = artistmodel;}

    //Comment
    private List<Commentsids> commentsList = new ArrayList<Commentsids>();
    public List<Commentsids> getCommentsList() {
        return commentsList;
    }
    public void setCommentsList(List<Commentsids> commentsList) {
        this.commentsList = commentsList;
    }
    //Comment Creator
    private List<Usermodel> commentCreatorsList = new ArrayList<Usermodel>();
    public List<Usermodel> getCommentCreatorsList() {
        return commentCreatorsList;
    }
    public void setCommentCreatorsList(List<Usermodel> commentCreatorsList) {
        this.commentCreatorsList = commentCreatorsList;
    }

//    private List<Descriptionids> descriptionsList = new ArrayList<Descriptionids>();
//    public List<Descriptionids> getDescriptionsList() {
//        return descriptionsList;
//    }
//    public void setDescriptionsList(List<Descriptionids> descriptionsList) {
//        this.descriptionsList = descriptionsList;
//    }
    //Description
    private Descriptionids descriptionids;
    public Descriptionids getDescriptionids() {
        return descriptionids;
    }
    public void setDescriptionids(Descriptionids descriptionids) {
        this.descriptionids = descriptionids;
    }
    private Boolean descriptionEditable;
    public Boolean getDescriptionEditable() {
        return descriptionEditable;
    }
    public void setDescriptionEditable(Boolean descriptionEditable) {
        this.descriptionEditable = descriptionEditable;
    }

    //Pool
    private List<Poolmodel> poolmodelList = new ArrayList<Poolmodel>();

    public List<Poolmodel> getPoolmodelList() {
        return poolmodelList;
    }

    public void setPoolmodelList(List<Poolmodel> poolmodelList) {
        this.poolmodelList = poolmodelList;
    }

    //Avg Remark
    private Boolean canAddRemark;
    private Float averageRemark = null;
    private Integer userRemark = null;
    private Boolean hasUser;
    public Boolean getCanAverage()
    {
        return this.getAverageRemark() != null && this.getAverageRemark() != 0.f;
    }

    public Boolean getCanAddRemark() {
        return canAddRemark;
    }

    public void setCanAddRemark(Boolean canAddRemark) {
        this.canAddRemark = canAddRemark;
    }

    public Float getAverageRemark() {
        return averageRemark;
    }
    public void setAverageRemark(Float averageRemark) {
        this.averageRemark = averageRemark;
    }
    public Integer getUserRemark() {
        return userRemark;
    }
    public void setUserRemark(Integer userRemark) {
        this.userRemark = userRemark;
    }

    public Boolean getHasUser() {
        return hasUser;
    }
    public void setHasUser(Boolean hasUser) {
        this.hasUser = hasUser;
    }


    //Tag
    private List<Tagmodel> tagList = new ArrayList<Tagmodel>();
    public List<Tagmodel> getTagList() {
        return tagList;
    }
    public void setTagList(List<Tagmodel> tagList) {
        this.tagList = tagList;
    }

    //Service
    private ImageService imageService;
    private IAccountService accountService;
    private ArtistService artistService;
    private DescriptionService descriptionService;
    private CommentService commentService;
    private RemarkService remarkService;
    private TagService tagService;
    private PoolService poolService;

    public PoolService getPoolService() {
        return poolService;
    }

    public void setPoolService(PoolService poolService) {
        this.poolService = poolService;
    }

    public ImageService getImageService() {
        return imageService;
    }

    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(IAccountService iAccountService) {
        this.accountService = iAccountService;
    }

    public ArtistService getArtistService() {
        return artistService;
    }

    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    public DescriptionService getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    public CommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    public RemarkService getRemarkService() {
        return remarkService;
    }

    public void setRemarkService(RemarkService remarkService) {
        this.remarkService = remarkService;
    }

    public TagService getTagService() {
        return tagService;
    }

    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }

    public String execute()
    {
        try
        {
            Postmodel pm = (Postmodel)this.getImageService().get(this.getImageId());
            pm.setVisited(pm.getVisited() + 1);
            getImageService().update(pm);
            setPostmodel(pm);

        }
        catch (Exception e){
            return ERROR;
        }

        try
        {
            setAverageRemark(null);
            setAverageRemark(this.getRemarkService().getAverageRemark(this.getPostmodel().getId()));
        }catch (Exception e){}

        try {
            setCreator((Usermodel) this.getAccountService().get(getPostmodel().getCreatorId()));
        }
        catch (Exception e){}

        try {
            setArtistmodel((Artistmodel)this.getAccountService().get(getPostmodel().getArtistId()));
        }
        catch (Exception e){}

        //Comment
        List<Serializable> commentIdList = getCommentService().getByPostId(this.getImageId());
        for (Serializable id : commentIdList)
        {
            Commentsids comment = (Commentsids)getCommentService().get(id);
            getCommentsList().add(comment);
            Serializable commentCreatorId = comment.getOwnerId();

            Usermodel commentCreator = null;
            try
            {
                commentCreator = (Usermodel)getAccountService().get(commentCreatorId);
            }
            catch (Exception e){}

            getCommentCreatorsList().add(commentCreator);
        }


        Serializable desId = null;
        try
        {
            List<Serializable> desIdList = getDescriptionService().getByPostId(getImageId());
            desId = desIdList.get(0);
            setDescriptionids((Descriptionids)getDescriptionService().get(desId));
        }
        catch (Exception e)
        {}

        Usermodel currentUser = (Usermodel)getSession().get("UserModel");
        if (currentUser == null)
        {
            setHasUser(false);
            setUserRemark(null);
        }
        else
        {
            setHasUser(true);
            try
            {
//                List<Remarkids> aa = getRemarkService().getRemarkbyUsermodelandPostmodel(currentUser.getId(),getImageId());
                Integer iRemark = (Integer)getRemarkService().getRemarkbyUsermodelandPostmodel(currentUser.getId(),getImageId()).get(0);
                setUserRemark(iRemark);
            }
            catch (Exception e)
            {}
        }

        if (getCreator() == null)
        {
            this.setDescriptionEditable(true);
        }
        else if (currentUser == null)
        {
            this.setDescriptionEditable(false);
        }
        else if(getCreator().getId().equals(currentUser.getId()))
        {
            this.setDescriptionEditable(true);
        }
        else
        {
            this.setDescriptionEditable(false);
        }

        if (this.getHasUser() && this.getUserRemark() == null)
        {
            this.setCanAddRemark(true);
        }
        else
        {
            this.setCanAddRemark(false);
        }

        List<Integer> tagIds = getTagService().getImageTag(getImageId());
        for (Integer tagId : tagIds)
        {
            getTagList().add((Tagmodel)getTagService().get(tagId));
        }

        if (currentUser != null)
        {
            List<Integer> poolIds = getPoolService().getUserPool(currentUser.getId());
            for (Integer poolId : poolIds)
            {
                Poolmodel poolmodel = (Poolmodel) getPoolService().get(poolId);

                this.getPoolmodelList().add(poolmodel);
            }
        }

        return SUCCESS;
    }
}
