package VO;

import java.sql.Timestamp;

/**
 * Artistmodel entity. @author MyEclipse Persistence Tools
 */

public class Artistmodel implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer aliasId;
	private String name;
	private Integer creatorId;
	private Timestamp createdAt;
	private Timestamp updateAt;

	// Constructors

	/** default constructor */
	public Artistmodel() {
	}

	/** full constructor */
	public Artistmodel(Integer aliasId, String name, Integer creatorId,
			Timestamp createdAt, Timestamp updateAt) {
		this.aliasId = aliasId;
		this.name = name;
		this.creatorId = creatorId;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAliasId() {
		return this.aliasId;
	}

	public void setAliasId(Integer aliasId) {
		this.aliasId = aliasId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
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

}