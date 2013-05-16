package org.shinshi.gallery.model;

import java.io.Serializable;
import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-4-16
 * Time: 下午11:05
 */
public class PoolModel implements Serializable {
    private int id;
    private String name;
    private String description;
    private boolean visible;
    private int creatorId;
    private long createdAt;
    private long updatedAt;
    private List<Integer> postIds;
}
