package com.popularity.loader;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import com.popularity.spi.UserPopularity;
import com.popularity.user.metrcis.UserActivitiesMetadata;
import com.popularity.user.metrcis.UserConnectivityMetadata;
import com.popularity.user.metrcis.UserPopularityMetrics;
import com.popularity.user.metrcis.UserProfileMetadata;

public class UserPopularityService {
	private static UserPopularityService service;

	ServiceLoader<UserPopularity>loader;

	UserPopularity provider = null;

	public UserPopularityService() {
		
		loader = ServiceLoader.load(UserPopularity.class);
	}
	 public static synchronized  UserPopularityService getInstance() {
	        if (service == null) {
	            service = new  UserPopularityService ();
	            
	        }
	        return service;
	    }

	public UserPopularity searchProvider( String social_media) {
	
		boolean find = false;
		try {

			Iterator<UserPopularity> providers = loader.iterator();

			while ((providers.hasNext() == true) && (find == false)) {
				provider = providers.next();

				if (((provider.getClass().getName().contains(social_media) == true) )){
					find = true;
					System.out.println("provider name = "
							+ provider.getClass().getName()+ "\n");
				
				}

			}

		} catch (ServiceConfigurationError e) {
			e.printStackTrace();
		}
		return provider;
	}

	public  UserProfileMetadata getProfileMetadata(String socialMedia, String name){
		System.out.println ("User profile data");
	    provider=	searchProvider(socialMedia);
		return provider.getMetadata(name);
	}
	public UserActivitiesMetadata getUserActivities(String socialMedia, String name) {
		System.out.println ("User activities");
		  provider=	searchProvider(socialMedia);
			return provider.getActivities(name);
	}
	public UserConnectivityMetadata getUserConnectivity(String socialMedia, String name) {
		
		System.out.println ("User Connectivity");
		 provider=	searchProvider(socialMedia);
			return provider.getConnectivity(name);
	}
	public UserPopularityMetrics getUserPopularityMetrics(String socialMedia, String name) {
	
		System.out.println ("User Popularity Metrics: profile + activities + connectivity");
		 provider=	searchProvider(socialMedia);
			return provider.getPopularity(name);
	}


	
}
