package media.popularity.provider;

import java.util.SortedMap;
import java.util.TreeMap;

import popularity.media.metrics.MediaMetadataMetrics;
import popularity.media.metrics.MediaPopularityMetrics;
import popularity.media.metrics.MediaUserFeedBackMetrics;
import popularity.media.metrics.UserActivitiesMetadata;
import popularity.media.metrics.UserConnectivityMetadata;
import popularity.media.metrics.UserPopularityMetrics;
import popularity.media.metrics.UserProfileMetadata;
import popularity.media.metrics.VideoMetadataMetrics;
import popularity.spi.MediaPopularity;


public class VideoPopularityProvider implements MediaPopularity{
	
private SortedMap<String,  MediaPopularityMetrics> videoPopularityMap;
	

	//Constructor without parameter
	public VideoPopularityProvider(){
		videoPopularityMap= new TreeMap <String,  MediaPopularityMetrics>();
		
		 //charger les données
		MediaMetadataMetrics VideoMetadataMetrics = new VideoMetadataMetrics(null, null, null, null, null, null, null, null);
		MediaUserFeedBackMetrics VideoFeedBackMetrics =new MediaUserFeedBackMetrics(0, 0, 0, 0);
		UserActivitiesMetadata  authorActivity =new UserActivitiesMetadata (0);
		UserConnectivityMetadata authorConnectivity =new UserConnectivityMetadata(0, 0);
		UserProfileMetadata authorProfile =new UserProfileMetadata(null, null, null, null, null, null, null);
		UserPopularityMetrics authorMetrics =new UserPopularityMetrics(authorProfile,authorActivity,authorConnectivity) ;
		MediaPopularityMetrics VideoPopularityMetrics =new  MediaPopularityMetrics(VideoMetadataMetrics,VideoFeedBackMetrics,authorMetrics);
		
		//Remplir les stordMap
		videoPopularityMap.put("url", VideoPopularityMetrics);
	
		 
	}
	



	@Override
	public MediaPopularityMetrics defineMediaPopularityMetrics(String media_url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaUserFeedBackMetrics defineMediaUserFeedBackMetadataPopularityMetrics(
			String media_url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaMetadataMetrics defineMediaMetadataPopularityMetrics(
			String media_url) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public UserPopularityMetrics defineAuthorPopularity(String media_url) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public UserProfileMetadata defineMediaAuthorProfile(String media_url) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public UserConnectivityMetadata defineMediaAuthorConnectivity(
			String media_url) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public UserActivitiesMetadata defineMediaAuthorActivities(String media_url) {
		// TODO Auto-generated method stub
		return null;
	}

}
