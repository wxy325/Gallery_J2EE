package VO;

import java.sql.Timestamp;

/**
 * Descriptionids entity. @author MyEclipse Persistence Tools
 */

public class Descriptionids implements java.io.Serializable {

	// Fields

	private Integer id;
	private String description;
	private Integer ownerId;
	private Integer pictureId;
	private Timestamp date;

	// Constructors

	/** default constructor */
	public Descriptionids() {
	}

	/** full constructor */
	public Descriptionids(String description, Integer ownerId,
			Integer pictureId, Timestamp date) {
		this.description = description;
		this.ownerId = ownerId;
		this.pictureId = pictureId;
		this.date = date;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getPictureId() {
		return this.pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

}