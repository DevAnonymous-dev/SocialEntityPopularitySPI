package com.popularity.spi;

import com.popularity.user.metrcis.UserActivitiesMetadata;
import com.popularity.user.metrcis.UserConnectivityMetadata;
import com.popularity.user.metrcis.UserPopularityMetrics;
import com.popularity.user.metrcis.UserProfileMetadata;

public interface UserPopularity {
	
	// service for encapsulate the metadata metrics of the user entity 
public UserProfileMetadata getMetadata(String names);

// service for encapsulate the  metrics describes the activities of the user entity 
public UserActivitiesMetadata getActivities(String name);

// service for encapsulate the metrics of the connectivity  of the user entity 
public UserConnectivityMetadata getConnectivity(String name);

// service for encapsulate all the metrics of the user popularity 
public UserPopularityMetrics getPopularity (String name);
	
}
