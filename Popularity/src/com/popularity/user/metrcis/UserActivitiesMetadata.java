package com.popularity.user.metrcis;

import java.util.ArrayList;

public class UserActivitiesMetadata {
	 
	
	private ArrayList<Activity> activities ;//tweet, post, share, etc
	
	

	public UserActivitiesMetadata(ArrayList<Activity> activities) {
		super();
		this.activities = activities;
	}



	public ArrayList<Activity> getActivities() {
		return activities;
	}



	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}



	@Override
	public String toString() {
		return "UserActivitiesMetadata [activities=" + activities + "]";
	}

	
	

}
