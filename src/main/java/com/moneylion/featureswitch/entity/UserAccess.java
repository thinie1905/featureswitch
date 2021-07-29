package com.moneylion.featureswitch.entity;

public class UserAccess {
	
	private boolean canAccess;

	public UserAccess(boolean canAccess) {
		this.canAccess = canAccess;
	}

	public UserAccess() {
		
	}

	public boolean isCanAccess() {
		return canAccess;
	}

	public void setCanAccess(boolean canAccess) {
		this.canAccess = canAccess;
	}

	@Override
	public String toString() {
		return "UserAccess [canAccess=" + canAccess + "]";
	}

}
