package com.wxy.action.stream.image;

import VO.Postmodel;
import com.wxy.action.stream.StreamBaseAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-6-17
 * Time: 下午9:09
 * To change this template use File | Settings | File Templates.
 */
public class ImageStreamBaseAction extends StreamBaseAction
{
    //ImageStreamBaseAction
    private List<Postmodel> imagesList = new ArrayList<Postmodel>();
    public List<Postmodel> getImagesList()
    {
        return this.imagesList;
    }


}
