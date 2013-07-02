package VO;

import java.sql.Timestamp;

/**
 * Tagmodel entity. @author MyEclipse Persistence Tools
 */

public class Tagmodel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer count;
	private String type;
	private Integer createId;
	private Timestamp creatAt;
	private Timestamp updateAt;
	private Integer ambiguous;

	// Constructors

	/** default constructor */
	public Tagmodel() {
	}

	/** full constructor */
	public Tagmodel(String name, Integer count, String type, Integer createId,
			Timestamp creatAt, Timestamp updateAt, Integer ambiguous) {
		this.name = name;
		this.count = count;
		this.type = type;
		this.createId = createId;
		this.creatAt = creatAt;
		this.updateAt = updateAt;
		this.ambiguous = ambiguous;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCreateId() {
		return this.createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public Timestamp getCreatAt() {
		return this.creatAt;
	}

	public void setCreatAt(Timestamp creatAt) {
		this.creatAt = creatAt;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public Integer getAmbiguous() {
		return this.ambiguous;
	}

	public void setAmbiguous(Integer ambiguous) {
		this.ambiguous = ambiguous;
	}

}