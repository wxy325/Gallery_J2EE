package VO;

import java.sql.Timestamp;

/**
 * Poolmodel entity. @author MyEclipse Persistence Tools
 */

public class Poolmodel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Postids postids;
	private String name;
	private String description;
	private Integer visible;
	private Integer creatorId;
	private Timestamp updateAt;

	// Constructors

	/** default constructor */
	public Poolmodel() {
	}

	/** full constructor */
	public Poolmodel(Postids postids, String name, String description,
			Integer visible, Integer creatorId, Timestamp updateAt) {
		this.postids = postids;
		this.name = name;
		this.description = description;
		this.visible = visible;
		this.creatorId = creatorId;
		this.updateAt = updateAt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Postids getPostids() {
		return this.postids;
	}

	public void setPostids(Postids postids) {
		this.postids = postids;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVisible() {
		return this.visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

}