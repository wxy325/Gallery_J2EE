package VO;

import java.sql.Timestamp;

/**
 * Commentsids entity. @author MyEclipse Persistence Tools
 */

public class Commentsids implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer ownerId;
	private String comment;
	private Timestamp date;
	private Integer pictureId;

	// Constructors

	/** default constructor */
	public Commentsids() {
	}

	/** full constructor */
	public Commentsids(Integer ownerId, String comment, Timestamp date,
			Integer pictureId) {
		this.ownerId = ownerId;
		this.comment = comment;
		this.date = date;
		this.pictureId = pictureId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getPictureId() {
		return this.pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

}