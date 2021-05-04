package com.mycompany.domain;

public class User {
	private Integer id;
	private String username;
	private String password;
	private Boolean isActive = true;
	private Boolean isEnabled = true;
	private Boolean isAccountLocked = false;
	private Boolean isCredentialsExpired = false;
	private String[] grantedAuthorities = { "ROLE_ADMIN", "ROLE_USER" };

	public User() {
	}

	public User(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isEnabled
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * @return the isAccountLocked
	 */
	public Boolean getIsAccountLocked() {
		return isAccountLocked;
	}

	/**
	 * @param isAccountLocked the isAccountLocked to set
	 */
	public void setIsAccountLocked(Boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}

	/**
	 * @return the isCredentialsExpired
	 */
	public Boolean getIsCredentialsExpired() {
		return isCredentialsExpired;
	}

	/**
	 * @param isCredentialsExpired the isCredentialsExpired to set
	 */
	public void setIsCredentialsExpired(Boolean isCredentialsExpired) {
		this.isCredentialsExpired = isCredentialsExpired;
	}

	/**
	 * @return the grantedAuthorities
	 */
	public String[] getGrantedAuthorities() {
		return grantedAuthorities;
	}

	/**
	 * @param grantedAuthorities the grantedAuthorities to set
	 */
	public void setGrantedAuthorities(String[] grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

}
