package populaity.service.loader;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import popularity.spi.VideoPopularity;
import video.popularity.provider.VideoFeedBackMetrics;

//implements singleton pattern
public class VideoPopularityService {
	
	// ensures only one instance of videoPopularityService exists
	private static VideoPopularityService service;
	private ServiceLoader<VideoPopularity> loader;

	// prevents all other classes, except VideoPopularityService, from creating
	// instances of it
	private VideoPopularityService() {
		loader = ServiceLoader.load(VideoPopularity.class);
	}

	public static synchronized VideoPopularityService getInstance() {
		if (service == null) {
			service = new VideoPopularityService();
		}
		return service;
	}
	 public VideoFeedBackMetrics getVideoFeedBackMetrics ( String url){
	    	VideoFeedBackMetrics feedbackMetrics= null;
	    	try{
	    		Iterator<VideoPopularity> providers = loader.iterator();
	    		while (feedbackMetrics==null && providers.hasNext()){
	    			VideoPopularity videoPopularity= providers.next();
	    			feedbackMetrics =videoPopularity.getVideoFeedBackMetada(url) ;
	    			
	    		}
	    	}
	    		catch (ServiceConfigurationError serviceError){
	    			feedbackMetrics=null;
	    			
	    			serviceError.printStackTrace();
	    		}
	    	return feedbackMetrics;
	    	
	    }

}
