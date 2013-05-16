package org.shinshi.gallery.model;

import java.io.Serializable;

/**
 * User: SpringNyan
 * Date: 13-4-16
 * Time: 下午10:25
 */
public class ArtistModel implements Serializable {
    private int id;
    private int aliasId;
    private String name;
    private int creatorId;
    private long createdAt;
    private long updatedAt;
}
