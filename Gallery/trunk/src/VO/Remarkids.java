package VO;

import java.sql.Timestamp;

/**
 * Remarkids entity. @author MyEclipse Persistence Tools
 */

public class Remarkids implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer remark;
	private Integer ownerId;
	private Timestamp date;
	private Integer pictureId;

	// Constructors

	/** default constructor */
	public Remarkids() {
	}

	/** full constructor */
	public Remarkids(Integer remark, Integer ownerId, Timestamp date,
			Integer pictureId) {
		this.remark = remark;
		this.ownerId = ownerId;
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

	public Integer getRemark() {
		return this.remark;
	}

	public void setRemark(Integer remark) {
		this.remark = remark;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
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