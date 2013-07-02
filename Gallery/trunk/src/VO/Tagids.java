package VO;

/**
 * Tagids entity. @author MyEclipse Persistence Tools
 */

public class Tagids implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer tagid;
	private Integer ownerId;

	// Constructors

	/** default constructor */
	public Tagids() {
	}

	/** full constructor */
	public Tagids(Integer tagid, Integer ownerId) {
		this.tagid = tagid;
		this.ownerId = ownerId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTagid() {
		return this.tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

}