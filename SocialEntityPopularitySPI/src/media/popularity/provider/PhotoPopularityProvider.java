package media.popularity.provider;

import java.util.SortedMap;
import java.util.TreeMap;

import popularity.media.metrics.MediaMetadataMetrics;
import popularity.media.metrics.MediaPopularityMetrics;
import popularity.media.metrics.MediaUserFeedBackMetrics;
import popularity.media.metrics.PhotoMetadataMetrics;
import popularity.media.metrics.UserActivitiesMetadata;
import popularity.media.metrics.UserConnectivityMetadata;
import popularity.media.metrics.UserPopularityMetrics;
import popularity.media.metrics.UserProfileMetadata;
import popularity.spi.MediaPopularity;

public class PhotoPopularityProvider implements MediaPopularity{
	
private SortedMap<String,  MediaPopularityMetrics> photoPopularityMap;
	

	//Constructor without parameter
	public PhotoPopularityProvider(){
		photoPopularityMap= new TreeMap <String,  MediaPopularityMetrics>();
		
		 //charger les données
		MediaMetadataMetrics photoMetadataMetrics = new PhotoMetadataMetrics(null, null, null, null, null, null);
		MediaUserFeedBackMetrics photoFeedBackMetrics =new MediaUserFeedBackMetrics(0, 0, 0, 0);
		UserActivitiesMetadata  authorActivity =new UserActivitiesMetadata (0);
		UserConnectivityMetadata authorConnectivity =new UserConnectivityMetadata(0, 0);
		UserProfileMetadata authorProfile =new UserProfileMetadata(null, null, null, null, null, null, null);
		UserPopularityMetrics authorMetrics =new UserPopularityMetrics(authorProfile,authorActivity,authorConnectivity) ;
		MediaPopularityMetrics photoPopularityMetrics =new  MediaPopularityMetrics(photoMetadataMetrics,photoFeedBackMetrics,authorMetrics);
		
		//Remplir les stordMap
		photoPopularityMap.put("url", photoPopularityMetrics);
	
		 
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


