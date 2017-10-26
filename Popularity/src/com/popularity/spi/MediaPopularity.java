package com.popularity.spi;

import com.popularity.media.feedback.MediaUserFeedBackMetrics;
import com.popularity.media.metadata.MediaMetadataMetrics;
import com.popularity.user.metrcis.UserPopularityMetrics;

public interface MediaPopularity {
//For identifying the appropriate provider
	public String getProviderName();
	
	// service for encapsulate the metadata metrics of the media entity (i.e. Text, Photo and Video) correpond to the id_media
	public MediaMetadataMetrics getmetadata (String id_media);
	
	// service for encapsulate the feedback of users in front of the target media entity (i.e. Text, Photo and Video) correpond to the id_media
	public MediaUserFeedBackMetrics getUserFeeBack (String id_media);
	
	// service for encapsulate the metrics of the author of the media entity (i.e. Text, Photo and Video) correpond to the id_media
	public UserPopularityMetrics getAuthorPopularity (String id_media);
	
	//service to  add media popularity metadata 
	public void defineMediaPopularityMetadataMetrics (String media_url);
	
	//service to  add the media is user popularity metadata 
	public void defineMediaPopularityUsertFeedBackMetrics (String media_url);
}
