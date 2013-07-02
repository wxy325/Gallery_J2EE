package VO;

/**
 * Childids entity. @author MyEclipse Persistence Tools
 */

public class Childids implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer childId;
	private Integer ownerId;

	// Constructors

	/** default constructor */
	public Childids() {
	}

	/** full constructor */
	public Childids(Integer childId, Integer ownerId) {
		this.childId = childId;
		this.ownerId = ownerId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChildId() {
		return this.childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

}