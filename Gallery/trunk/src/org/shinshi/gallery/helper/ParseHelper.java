package org.shinshi.gallery.helper;

import VO.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-6-18
 * Time: 下午3:31
 */
public class ParseHelper {
    public static List<Integer> stringToInteger(List<String> list)
    {
        List<Integer> result = new ArrayList<Integer>(list.size());

        for (String str : list)
        {
            result.add(Integer.parseInt(str));
        }

        return result;
    }

    public static List<Integer> postModelToInteger(List<Postmodel> list)
    {
        List<Integer> result = new ArrayList<Integer>(list.size());

        for (Postmodel model : list)
        {
            result.add(model.getId());
        }

        return result;
    }

    public static List<Integer> poolModelToInteger(List<Poolmodel> list)
    {
        List<Integer> result = new ArrayList<Integer>(list.size());

        for (Poolmodel model : list)
        {
            result.add(model.getId());
        }

        return result;
    }

    public static List<Integer> tagModelToInteger(List<Tagmodel> list)
    {
        List<Integer> result = new ArrayList<Integer>(list.size());

        for (Tagmodel model : list)
        {
            result.add(model.getId());
        }

        return result;
    }

    public static List<Integer> remarkModelToInteger(List<Remarkids> list)
    {
        List<Integer> result = new ArrayList<Integer>(list.size());

        for (Remarkids model : list)
        {
            result.add(model.getId());
        }

        return result;
    }

    public static List<Integer> commentModelToInteger(List<Commentsids> list)
    {
        List<Integer> result = new ArrayList<Integer>(list.size());

        for (Commentsids model : list)
        {
            result.add(model.getId());
        }

        return result;
    }

    public static List<Integer> descriptionModelToInteger(List<Descriptionids> list)
    {
        List<Integer> result = new ArrayList<Integer>(list.size());

        for (Descriptionids model : list)
        {
            result.add(model.getId());
        }

        return result;
    }

}
