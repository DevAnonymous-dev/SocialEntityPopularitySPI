package populaity.service.loader;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import popularity.media.metrics.MediaPopularityMetrics;
import popularity.spi.MediaPopularity;
import popularity.spi.UserPopularity;

public class PopularityService {
	// ensures only one instance of PopularityService exists
		private static  PopularityService service;
	    private ServiceLoader < MediaPopularity> medialoader;
	    private ServiceLoader < UserPopularity> userloader;
	    
	 // prevents all other classes, except PopularityService, from creating instances of it
	    private PopularityService() {
	        medialoader = ServiceLoader.load( MediaPopularity.class);
	        userloader= ServiceLoader.load(UserPopularity.class);
	        
	    }

	    public static synchronized  PopularityService getInstance() {
	        if (service == null) {
	            service = new  PopularityService();
	        }
	        return service;
	    }

	


		public MediaPopularityMetrics getMediaPopularityMetrics(String url_Media) {
			MediaPopularityMetrics mediaPopularityInfo =null;
			try {
				Iterator <MediaPopularity> mediaProviders = medialoader.iterator();
				while ( mediaPopularityInfo ==null && mediaProviders.hasNext()){
					MediaPopularity mediaPopularitySPI = mediaProviders.next();
					mediaPopularityInfo = mediaPopularitySPI.defineMediaPopularityMetrics(url_Media);
					
				}
				
			}
			catch(ServiceConfigurationError serviceError){
				 mediaPopularityInfo =null;
				 serviceError.printStackTrace();
			}
			
			return null;
		}

	

}
