package com.popularity.client.demo;

import com.popularity.loader.MediaPopularityService;
import com.popularity.loader.UserPopularityService;

public class SearchProviderDemo {
	public static void main(String[] args) {

		MediaPopularityService mps = new MediaPopularityService();
		UserPopularityService ups = new UserPopularityService();
		// Demo user popularity
		ups.getProfileMetadata("Twitter", "FRANCE24");
		ups.getUserActivities("Twitter", "FRANCE24");
		ups.getUserConnectivity("Twitter", "France24");
		ups.getUserPopularityMetrics("Twitter", "France24");

		// Demo Media: text popularity
		mps.getPopularityMetadataMetrics("Text", "868985285207629825",
				"Twitter");
		mps.getPopularityFeedBackMetrics("Text", "868985285207629825",
				"Twitter");
		mps.getAuthorPopularityMetrics("Text", "868985285207629825", "Twitter");

	}

}
