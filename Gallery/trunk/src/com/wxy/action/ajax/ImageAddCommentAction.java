package com.wxy.action.ajax;

import VO.Commentsids;
import VO.Usermodel;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.shinshi.gallery.service.CommentService;
import org.shinshi.gallery.service.IAccountService;
import org.shinshi.gallery.service.ImageService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-7-2
 * Time: 下午6:31
 * To change this template use File | Settings | File Templates.
 */
public class ImageAddCommentAction extends ActionSupport implements SessionAware
{
    //Param
    private Integer postId;
    private String commentContent;

    @JSON(serialize=false)
    public Integer getPostId() {
        return postId;
    }
    public void setPostId(Integer postId) {
        this.postId = postId;
    }
    @JSON(serialize=false)
    public String getCommentContent() {
        return commentContent;
    }
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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
    private IAccountService accountService;
    private ImageService imageService;
    private CommentService commentService;

    @JSON(serialize=false)
    public IAccountService getAccountService() {
        return accountService;
    }
    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
    @JSON(serialize=false)
    public ImageService getImageService() {
        return imageService;
    }
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }
    @JSON(serialize=false)
    public CommentService getCommentService() {
        return commentService;
    }
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    //Constructor
    public ImageAddCommentAction()
    {
        super();
    }
    public ImageAddCommentAction(IAccountService accountService,
                                 ImageService imageService,
                                 CommentService commentService)
    {
        super();
        this.setAccountService(accountService);
        this.setImageService(imageService);
        this.setCommentService(commentService);
    }

    //Result
    private Boolean success;
    private List<Commentsids> newComments;

    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public List<Commentsids> getNewComments() {
        return newComments;
    }
    public void setNewComments(List<Commentsids> newComments) {
        this.newComments = newComments;
    }

    public String execute()
    {
//        this.setCommentContent("啊啊啊");
        if(getImageService().get(getPostId()) == null)
        {
            this.setSuccess(false);
            return SUCCESS;
        }


        Commentsids comment = new Commentsids();
        Usermodel currentUser = (Usermodel)getSession().get("UserModel");

        if(currentUser != null)
        {
            comment.setOwnerId(currentUser.getId());
        }
        else
        {
            comment.setOwnerId(null);
        }

        try
        {

            comment.setComment(getCommentContent());
            comment.setPictureId(getPostId());
            java.sql.Timestamp date = new Timestamp(new Date().getTime());
            comment.setDate(date);
            getCommentService().save(comment);
            this.setSuccess(true);
            this.setNewComments(this.getCommentService().getByPostId(getPostId()));
        }
        catch (Exception e)
        {
            this.setSuccess(false);
        }

        return SUCCESS;
    }

}
