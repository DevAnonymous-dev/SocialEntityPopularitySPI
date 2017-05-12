package popularity.spi;

import popularity.media.metrics.MediaMetadataMetrics;
import popularity.media.metrics.MediaPopularityMetrics;
import popularity.media.metrics.MediaUserFeedBackMetrics;
import popularity.media.metrics.UserActivitiesMetadata;
import popularity.media.metrics.UserConnectivityMetadata;
import popularity.media.metrics.UserPopularityMetrics;
import popularity.media.metrics.UserProfileMetadata;

public interface MediaPopularity {
	
	//provided service to define media (i.e. Text, Photo and Video)  popularity 
	
	//define all the metrics
public MediaPopularityMetrics defineMediaPopularityMetrics (String media_url);

//define metrics related to the user feedback
public MediaUserFeedBackMetrics defineMediaUserFeedBackMetadataPopularityMetrics (String media_url);

//define metrics related to the media metadata 
public MediaMetadataMetrics defineMediaMetadataPopularityMetrics (String media_url);

 public UserPopularityMetrics defineAuthorPopularity(String media_url);
public UserProfileMetadata  defineMediaAuthorProfile(String media_url);
public UserConnectivityMetadata defineMediaAuthorConnectivity(String media_url);
public UserActivitiesMetadata defineMediaAuthorActivities(String media_url);

}
