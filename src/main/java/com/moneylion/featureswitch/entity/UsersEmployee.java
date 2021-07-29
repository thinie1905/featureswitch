package com.moneylion.featureswitch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_employee")
public class UsersEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String featureName;
	
	@Column(nullable = false)
	private boolean enable;
	
	public UsersEmployee() {
	}

	public UsersEmployee(String email, String featureName, boolean enable) {
		super();
		this.email = email;
		this.featureName = featureName;
		this.enable = enable;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public boolean isEnable() {
		return enable;
	}
	
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", featureName=" + featureName + ", enable=" + enable + "]";
	}
	
}
