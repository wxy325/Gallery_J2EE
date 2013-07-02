package VO;

import java.util.HashSet;
import java.util.Set;

/**
 * Postids entity. @author MyEclipse Persistence Tools
 */

public class Postids implements java.io.Serializable {

	// Fields

	private Integer fk;
	private Integer postid;
	private Integer poolid;
	private Set poolmodels = new HashSet(0);

	// Constructors

	/** default constructor */
	public Postids() {
	}

	/** full constructor */
	public Postids(Integer postid, Integer poolid) {
		this.postid = postid;
		this.poolid = poolid;
		this.poolmodels = poolmodels;
	}
	public Postids(Integer postid, Integer poolid, Set poolmodels) {
		this.postid = postid;
		this.poolid = poolid;
		this.poolmodels = poolmodels;
	}

	// Property accessors

	public Integer getFk() {
		return this.fk;
	}

	public void setFk(Integer fk) {
		this.fk = fk;
	}

	public Integer getPostid() {
		return this.postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public Integer getPoolid() {
		return this.poolid;
	}

	public void setPoolid(Integer poolid) {
		this.poolid = poolid;
	}

	public Set getPoolmodels() {
		return this.poolmodels;
	}

	public void setPoolmodels(Set poolmodels) {
		this.poolmodels = poolmodels;
	}

}