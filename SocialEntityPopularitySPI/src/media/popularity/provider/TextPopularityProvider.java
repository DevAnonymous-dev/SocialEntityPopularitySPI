package media.popularity.provider;

import java.util.SortedMap;
import java.util.TreeMap;

import popularity.media.metrics.MediaMetadataMetrics;
import popularity.media.metrics.MediaPopularityMetrics;
import popularity.media.metrics.MediaUserFeedBackMetrics;
import popularity.media.metrics.TextMetadataMetrics;
import popularity.media.metrics.UserActivitiesMetadata;
import popularity.media.metrics.UserConnectivityMetadata;
import popularity.media.metrics.UserPopularityMetrics;
import popularity.media.metrics.UserProfileMetadata;
import popularity.spi.MediaPopularity;

public class TextPopularityProvider implements MediaPopularity{
	
	
	private SortedMap<String,  MediaPopularityMetrics> textPopularityMap;
	

	//Constructor without parameter
	public TextPopularityProvider(){
		textPopularityMap= new TreeMap <String,  MediaPopularityMetrics>();
		
		 //charger les données
		MediaMetadataMetrics textMetadataMetrics = new TextMetadataMetrics("1", "url", "", "");
		MediaUserFeedBackMetrics textFeedBackMetrics =new MediaUserFeedBackMetrics(0, 0, 0, 0);
		UserActivitiesMetadata  authorActivity =new UserActivitiesMetadata (0);
		UserConnectivityMetadata authorConnectivity =new UserConnectivityMetadata(0, 0);
		UserProfileMetadata authorProfile =new UserProfileMetadata(null, null, null, null, null, null, null);
		UserPopularityMetrics authorMetrics =new UserPopularityMetrics(authorProfile,authorActivity,authorConnectivity) ;
		MediaPopularityMetrics textPopularityMetrics =new  MediaPopularityMetrics(textMetadataMetrics,textFeedBackMetrics,authorMetrics);
		
		//Remplir les stordMap
		textPopularityMap.put("url", textPopularityMetrics);
	
		 
	}
	@Override
	public MediaPopularityMetrics defineMediaPopularityMetrics(String media_url) {
		return textPopularityMap.get(media_url);
		
	}




	@Override
	public MediaMetadataMetrics defineMediaMetadataPopularityMetrics(
			String media_url) {
		
		return textPopularityMap.get(media_url).getMetadata();
	}





	@Override
	public MediaUserFeedBackMetrics defineMediaUserFeedBackMetadataPopularityMetrics(
			String media_url) {
		
		return textPopularityMap.get(media_url).getUserFeedBack();
	}


	@Override
	public UserProfileMetadata defineMediaAuthorProfile(String media_url) {
		return textPopularityMap.get(media_url).getAuthorMetrics().getUserprofile();
		
	}
	@Override
	public UserConnectivityMetadata defineMediaAuthorConnectivity(String media_url) {
		
		return textPopularityMap.get(media_url).getAuthorMetrics().getConnectivity();
	}
	@Override
	public UserActivitiesMetadata defineMediaAuthorActivities(String media_url) {
		return textPopularityMap.get(media_url).getAuthorMetrics().getUseractivities();
				
	}
	@Override
	public UserPopularityMetrics defineAuthorPopularity(String media_url) {
		return textPopularityMap.get(media_url).getAuthorMetrics();
	}




}
