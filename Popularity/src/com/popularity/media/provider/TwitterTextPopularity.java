package com.popularity.media.provider;

import com.popularity.media.feedback.MediaUserFeedBackMetrics;
import com.popularity.media.metadata.MediaMetadataMetrics;
import com.popularity.search.TwitterTextSearch;
import com.popularity.spi.MediaPopularity;
import com.popularity.user.metrcis.UserPopularityMetrics;

public class TwitterTextPopularity implements MediaPopularity {

	@Override
	public String getProviderName() {
	
		return "Text";
	}

	//text metadata metrics 
	@Override
	public MediaMetadataMetrics getmetadata(String id_media) {
		TwitterTextSearch tts= new TwitterTextSearch ();
		return tts.getTextMetadataById(id_media);
	}

	//text Feed back metrics
	@Override
	public MediaUserFeedBackMetrics getUserFeeBack(String id_media) {
		TwitterTextSearch tts= new TwitterTextSearch ();
		return tts.getTextFeedBackById(id_media);
	}
	
	//text author metrics
	@Override
	public UserPopularityMetrics getAuthorPopularity(String id_media) {
		System.out.println ("TwitterTextPopularity author popularity");
		TwitterTextSearch tts= new TwitterTextSearch ();
		return tts.getAuthorPopularity(id_media);
	}

	
	
	
}
