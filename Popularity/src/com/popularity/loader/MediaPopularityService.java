package com.popularity.loader;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import com.popularity.media.metadata.MediaMetadataMetrics;
import com.popularity.spi.MediaPopularity;
import com.popularity.spi.UserPopularity;
import com.popularity.user.metrcis.UserProfileMetadata;

public class MediaPopularityService {
	private static MediaPopularityService service;

	ServiceLoader<MediaPopularity> medialoader;
	ServiceLoader <UserPopularity> userloader;
	MediaPopularity provider = null;

	public MediaPopularityService() {
		medialoader = ServiceLoader.load(MediaPopularity.class);
		userloader = ServiceLoader.load(UserPopularity.class);
	}
	 public static synchronized  MediaPopularityService getInstance() {
	        if (service == null) {
	            service = new  MediaPopularityService ();
	        }
	        return service;
	    }

	public MediaPopularity searchProvider(String media_Type) {
	
		
		boolean find = false;
		try {

			Iterator<MediaPopularity> providers = medialoader.iterator();

			while ((providers.hasNext() == true) && (find == false)) {
				provider = providers.next();

				if (provider.getClass().getName().contains(media_Type) == true) {
					find = true;
					System.out.println("provider name = "
							+ provider.getClass().getName());
				
				}

			}

		} catch (ServiceConfigurationError e) {
			e.printStackTrace();
		}
		return provider;
	}
	
	public  MediaMetadataMetrics getPopularityMetadataMetrics (String media_Type, String media_id){
		//search provider
		provider= searchProvider(media_Type);	
		return provider.getmetadata(media_id);
		

		
	}
	
	public  UserProfileMetadata getProfileMetadata(String name){
		UserProfileMetadata userMetadata = null;
		
		try {
			Iterator <UserPopularity>providers = userloader.iterator();
			if (providers.hasNext()){
				System.out.println("true");
			}
			else 
				System.out.println(" no provider false");
			 
			while (providers.hasNext()){
				
				UserPopularity user = providers.next();
				System.out.println(" userPopularity"+ user.getClass());
				userMetadata= user.getMetadata(name);
				System.out.println("userMetadata"+userMetadata.toString());
			}
			
		}
		catch(ServiceConfigurationError serviceError){
			userMetadata =null;
			 serviceError.printStackTrace();
		}
		
		return userMetadata;
	}
		
	
	
}
