package com.popularity.media.provider;

import com.popularity.media.feedback.MediaUserFeedBackMetrics;
import com.popularity.media.metadata.MediaMetadataMetrics;
import com.popularity.spi.MediaPopularity;
import com.popularity.user.metrcis.UserPopularityMetrics;

public class YouTubeVideoPopularity implements MediaPopularity{
	
	@Override
	public String getProviderName() {
	
		return "Video";
	}

	@Override
	public MediaMetadataMetrics getmetadata(String id_media) {
		
		return null;
	}

	@Override
	public MediaUserFeedBackMetrics getUserFeeBack(String id_media) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPopularityMetrics getAuthorPopularity(String id_media) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
