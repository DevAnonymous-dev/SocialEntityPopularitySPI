package com.popularity.user.metrcis;

public class UserPopularityMetrics {
	
	private UserProfileMetadata userprofile;
	private UserActivitiesMetadata useractivities;
	private UserConnectivityMetadata connectivity;
		



	public UserPopularityMetrics(UserProfileMetadata userprofile,
			UserActivitiesMetadata useractivities,
			UserConnectivityMetadata connectivity) {
		super();
		this.userprofile = userprofile;
		this.useractivities = useractivities;
		this.connectivity = connectivity;
	}





	public UserPopularityMetrics() {
		// TODO Auto-generated constructor stub
	}





	public UserActivitiesMetadata getUseractivities() {
		return useractivities;
	}





	public void setUseractivities(UserActivitiesMetadata useractivities) {
		this.useractivities = useractivities;
	}





	public UserProfileMetadata getUserprofile() {
		return userprofile;
	}





	public void setUserprofile(UserProfileMetadata userprofile) {
		this.userprofile = userprofile;
	}





	public UserConnectivityMetadata getConnectivity() {
		return connectivity;
	}





	public void setConnectivity(UserConnectivityMetadata connectivity) {
		this.connectivity = connectivity;
	}





	@Override
	public String toString() {
		return "UserPopularityMetrics [useractivities=" + useractivities
				+ ", userprofile=" + userprofile + ", connectivity="
				+ connectivity + "]";
	}
	
	

}
