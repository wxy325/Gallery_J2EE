package com.wxy.action.upload;

import VO.Postmodel;
import VO.Usermodel;
import com.opensymphony.xwork2.ActionSupport;
import com.wxy.md5.MD5Util;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.shinshi.gallery.service.ImageService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-23
 * Time: 下午7:29
 * To change this template use File | Settings | File Templates.
 */
public class ImageUploadAction extends ActionSupport implements SessionAware
{
    //Constructor
    public ImageUploadAction()
    {
        super();
    }
    public ImageUploadAction(ImageService imageService)
    {
        super();
        this.imageService = imageService;
    }

    //Service
    ImageService imageService;
    public ImageService getImageService() {
        return imageService;
    }

    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    //Session Aware
    private Map session;
    public Map getSession(){return this.session;}
    @Override
    public void setSession(Map session){this.session = session;}

    //Getter And Setter Method
    private List<File> images = new ArrayList<File>();
    private List<String> imagesContentType = new ArrayList<String>();
    private List<String> imagesFileName = new ArrayList<String>();

    public List<File> getImages(){return this.images;}
    public void setImages(List<File> images){this.images = images;}

    public List<String>getImagesContentType(){return this.imagesContentType;}
    public void setImagesContentType(List<String> imagesContentType){this.imagesContentType = imagesContentType;}

    public List<String>getImagesFileName(){return this.imagesFileName;}
    public void setImagesFileName(List<String> imagesFileName){this.imagesFileName = imagesFileName;}



    private List<String> imageFileName = new ArrayList<String>();

    public List<String> getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(List<String> imageFileName) {
        this.imageFileName = imageFileName;
    }


    private List<String> tagStrings = new ArrayList<String>();
    public List<String> getTagStrings()
    {
        return this.tagStrings;
    }
    public void setTagStrings(List<String> tagStrings)
    {
        this.tagStrings = tagStrings;
    }

    @Override
    public String execute()
    {
        try
        {
            for (int i = 0; i < getImages().size(); i++)
            {
                String md5Str = MD5Util.getFileMD5String(getImages().get(i));
                String extensionStr = getExtention(this.getImagesFileName().get(i));
                String imageFileNameStr = md5Str +  extensionStr;
                imageFileName.add(imageFileNameStr);
                File imageFile = new File(ServletActionContext.getServletContext().getRealPath("ImageFolder")+ "/" + imageFileNameStr);
                copy(getImages().get(i), imageFile);  //将图片写入本地

                //model部分
                Postmodel postModel = new Postmodel();
                postModel.setMd5(md5Str);
                postModel.setName(imageFileNameStr);
//                postModel.setExtension(extensionStr);
                postModel.setSize( (int)(getImages().get(i).length() / 1024) );

                BufferedImage imageBuffer = ImageIO.read(getImages().get(i));
                postModel.setWidth(imageBuffer.getWidth());
                postModel.setHeight(imageBuffer.getHeight());

//                long time = System.currentTimeMillis();
//                Date time = new Date();
                Timestamp time = new Timestamp(System.currentTimeMillis());
                postModel.setCreatedAt(time);
                postModel.setUpdateAt(time);
                postModel.setScore(0);
                postModel.setVisited(0);
//                postModel.setRating(Postmodel.RatingSafe);
//                postModel.setStatus(Postmodel.StatusActive);
                Usermodel userModel = (Usermodel)getSession().get("UserModel");
                if (userModel != null && (userModel instanceof Usermodel))
                {
                    postModel.setCreatorId(userModel.getId());
                }
                else
                {
                    postModel.setCreatorId(0);
                }

                this.imageService.save(postModel);

            }
            return SUCCESS;
        }
        catch (Exception e)
        {
            return ERROR;
        }
    }

    @Override
    public void validate()
    {

        if (getImages() == null || getImages().size() == 0)
        {
            addFieldError("images","You must select at least one image");
        }
        //TODO 继续检查
    }


    private static final int BUFFER_SIZE = 16 * 1024;
    private static void copy(File src, File dst) {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(src),
                        BUFFER_SIZE);
                out = new BufferedOutputStream(new FileOutputStream(dst),
                        BUFFER_SIZE);
                byte[] buffer = new byte[BUFFER_SIZE];
                while (in.read(buffer) > 0) {
                    out.write(buffer);
                }
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
    }

}
