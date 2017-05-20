package com.popularity.spi;

import com.popularity.user.metrcis.UserActivitiesMetadata;
import com.popularity.user.metrcis.UserConnectivityMetadata;
import com.popularity.user.metrcis.UserPopularityMetrics;
import com.popularity.user.metrcis.UserProfileMetadata;

public interface UserPopularity {
	
public UserProfileMetadata getMetadata(String names);
public UserActivitiesMetadata getActivities(String name);
public UserConnectivityMetadata getConnectivity(String name);
public UserPopularityMetrics getPopularity (String name);
	
}
