package VO;

/**
 * Poolids entity. @author MyEclipse Persistence Tools
 */

public class Poolids implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer ownerId;
	private Integer poolId;

	// Constructors

	/** default constructor */
	public Poolids() {
	}

	/** full constructor */
	public Poolids(Integer ownerId, Integer poolId) {
		this.ownerId = ownerId;
		this.poolId = poolId;
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

	public Integer getPoolId() {
		return this.poolId;
	}

	public void setPoolId(Integer poolId) {
		this.poolId = poolId;
	}

}