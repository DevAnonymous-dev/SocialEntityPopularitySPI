package com.popularity.user.provider;

import com.popularity.search.TwitterTextSearch;
import com.popularity.spi.UserPopularity;
import com.popularity.user.metrcis.UserActivitiesMetadata;
import com.popularity.user.metrcis.UserConnectivityMetadata;
import com.popularity.user.metrcis.UserPopularityMetrics;
import com.popularity.user.metrcis.UserProfileMetadata;

public class TwitterUserPopularityProvider implements UserPopularity{

	@Override
	public UserProfileMetadata getMetadata(String name) {
	
		TwitterTextSearch tts= new TwitterTextSearch();
		return tts.getUserPopularityMetricsById(name);
	}

	@Override
	public UserActivitiesMetadata getActivities(String name) {
		TwitterTextSearch tts= new TwitterTextSearch();
		return tts.getUserActivitiesById(name);
		
	}

	@Override
	public UserConnectivityMetadata getConnectivity(String name) {
		TwitterTextSearch tts= new TwitterTextSearch();
		return tts.getUserConnectivityById(name);
	}

	@Override
	public UserPopularityMetrics getPopularity(String name) {
		TwitterTextSearch tts= new TwitterTextSearch();
		return tts.getUserPopularityById(name);
	}

}
