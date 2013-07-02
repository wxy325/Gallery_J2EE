package VO;

import java.sql.Timestamp;

/**
 * Usermodel entity. @author MyEclipse Persistence Tools
 */

public class Usermodel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ro;
	private String name;
	private String password;
	private String email;
	private Timestamp joinedAt;
	private Timestamp lastLoginAt;

	// Constructors

	/** default constructor */
	public Usermodel() {
	}

	/** full constructor */
	public Usermodel(String ro, String name, String password, String email,
			Timestamp joinedAt, Timestamp lastLoginAt) {
		this.ro = ro;
		this.name = name;
		this.password = password;
		this.email = email;
		this.joinedAt = joinedAt;
		this.lastLoginAt = lastLoginAt;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRo() {
		return this.ro;
	}

	public void setRo(String ro) {
		this.ro = ro;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getJoinedAt() {
		return this.joinedAt;
	}

	public void setJoinedAt(Timestamp joinedAt) {
		this.joinedAt = joinedAt;
	}

	public Timestamp getLastLoginAt() {
		return this.lastLoginAt;
	}

	public void setLastLoginAt(Timestamp lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

}