package user.popularity.provider;

import java.util.SortedMap;
import java.util.TreeMap;

import popularity.media.metrics.UserActivitiesMetadata;
import popularity.media.metrics.UserConnectivityMetadata;
import popularity.media.metrics.UserPopularityMetrics;
import popularity.media.metrics.UserProfileMetadata;
import popularity.spi.UserPopularity;

public class UserPopularityProvider implements UserPopularity {

	private SortedMap<String, UserPopularityMetrics>userPopularityMap;

	
	//Constructor without parameter
		public UserPopularityProvider (){
			userPopularityMap= new TreeMap <String,UserPopularityMetrics>();
			
			 //charger les données
			UserProfileMetadata	profileMetrics =new UserProfileMetadata	(null, null, null, null, null, null, null);
			UserActivitiesMetadata activitiesMetrics =new UserActivitiesMetadata(0);
			UserConnectivityMetadata connectivityMetrics =new 	UserConnectivityMetadata (0, 0);
			
			//Remplir les stordMap
			
		}
	@Override
	public UserProfileMetadata defineProfileMetadata(String url_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserConnectivityMetadata defineUserConnectivity(String url_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserActivitiesMetadata defineUserConnectivityMetadata(String url_user) {
		// TODO Auto-generated method stub
		return null;
	}

}
