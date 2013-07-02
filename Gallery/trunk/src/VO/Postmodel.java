package VO;

import java.sql.Timestamp;

/**
 * Postmodel entity. @author MyEclipse Persistence Tools
 */

public class Postmodel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String md5;
	private Integer size;
	private Integer width;
	private Integer height;
	private Integer creatorId;
	private Integer artistId;
	private Timestamp createdAt;
	private Timestamp updateAt;
	private String rating;
	private Integer score;
	private Integer visited;
	private String status;
	private String name;
	private String title;

	// Constructors

	/** default constructor */
	public Postmodel() {
	}

	/** full constructor */
	public Postmodel(String md5, Integer size, Integer width, Integer height,
			Integer creatorId, Integer artistId, Timestamp createdAt,
			Timestamp updateAt, String rating, Integer score, Integer visited,
			String status, String name, String title) {
		this.md5 = md5;
		this.size = size;
		this.width = width;
		this.height = height;
		this.creatorId = creatorId;
		this.artistId = artistId;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.rating = rating;
		this.score = score;
		this.visited = visited;
		this.status = status;
		this.name = name;
		this.title = title;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMd5() {
		return this.md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getWidth() {
		return this.width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getArtistId() {
		return this.artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getVisited() {
		return this.visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}