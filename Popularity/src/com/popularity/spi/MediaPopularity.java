package com.popularity.spi;

import com.popularity.media.feedback.MediaUserFeedBackMetrics;
import com.popularity.media.metadata.MediaMetadataMetrics;
import com.popularity.user.metrcis.UserPopularityMetrics;

public interface MediaPopularity {

	public String getProviderName();
	public MediaMetadataMetrics getmetadata (String id_media);
	public MediaUserFeedBackMetrics getUserFeeBack (String id_media);
	public UserPopularityMetrics getAuthorPopularity (String id_media);
}
