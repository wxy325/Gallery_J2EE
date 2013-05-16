package org.shinshi.gallery.model;

import java.io.Serializable;
import java.util.List;

/**
 * User: SpringNyan
 * Date: 13-4-16
 * Time: 下午10:00
 */
public class PostModel implements Serializable {
    private int id;
    private String md5;
    private int size;
    private int width;
    private int height;
    private int creatorId;
    private int artistId;
    private long createdAt;
    private long updatedAt;
    private PostRating rating;
    private int score;
    private int visited;
    private PostStatus status;
    private List<Integer> tagIds;
    private List<Integer> childIds;
    private List<Integer> poolIds;
}
