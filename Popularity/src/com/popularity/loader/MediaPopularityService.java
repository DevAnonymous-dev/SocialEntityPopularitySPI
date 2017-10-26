package com.popularity.loader;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import com.popularity.media.feedback.MediaUserFeedBackMetrics;
import com.popularity.media.metadata.MediaMetadataMetrics;
import com.popularity.spi.MediaPopularity;
import com.popularity.user.metrcis.UserPopularityMetrics;

public class MediaPopularityService {
	private static MediaPopularityService service;

	ServiceLoader<MediaPopularity> medialoader;

	MediaPopularity provider = null;

	public MediaPopularityService() {
		medialoader = ServiceLoader.load(MediaPopularity.class);
	
	}
	 public static synchronized  MediaPopularityService getInstance() {
	        if (service == null) {
	            service = new  MediaPopularityService ();
	            
	        }
	        return service;
	    }

	public MediaPopularity searchProvider(String media_Type, String social_media) {
	
		
		boolean find = false;
		try {

			Iterator<MediaPopularity> providers = medialoader.iterator();

			while ((providers.hasNext() == true) && (find == false)) {
				provider = providers.next();

				if ((provider.getClass().getName().contains(media_Type) == true) &&((provider.getClass().getName().contains(social_media) == true) )){
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
	
	public  MediaMetadataMetrics getPopularityMetadataMetrics (String media_Type, String media_id, String social_media){
		//search provider
		provider= searchProvider(media_Type, social_media);	
		return provider.getmetadata(media_id);
		

		
	}
	
	public  MediaUserFeedBackMetrics getPopularityFeedBackMetrics(String media_Type, String media_id, String social_media) {
		provider= searchProvider(media_Type, social_media);
		return provider.getUserFeeBack(media_id);
		
	}
	public UserPopularityMetrics getAuthorPopularityMetrics(String media_Type, String media_id, String social_media) {
		System.out.println ("Media popularity service");
		provider= searchProvider(media_Type, social_media);
		
		return provider.getAuthorPopularity(media_id);
		
	}
   
	
	
	
}
