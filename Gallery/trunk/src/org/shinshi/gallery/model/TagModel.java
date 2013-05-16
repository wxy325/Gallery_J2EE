package org.shinshi.gallery.model;

import java.io.Serializable;

/**
 * User: SpringNyan
 * Date: 13-4-16
 * Time: 下午11:24
 */
public class TagModel implements Serializable {
    private int id;
    private String name;
    private int count;
    private TagType type;
    private boolean ambiguous;
    private int creatorId;
    private long createdAt;
    private long updatedAt;
}
