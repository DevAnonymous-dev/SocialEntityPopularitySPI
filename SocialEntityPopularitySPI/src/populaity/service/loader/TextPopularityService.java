package populaity.service.loader;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import popularity.spi.TextPopularity;
import text.popularity.provider.TextFeedBackMetrics;

//implements singleton pattern
public class TextPopularityService {
	
	// ensures only one instance of UserPopularityService exists
	private static  TextPopularityService service;
    private ServiceLoader< TextPopularity> loader;
    
 // prevents all other classes, except TextPopularityService, from creating instances of it
    private  TextPopularityService() {
        loader = ServiceLoader.load( TextPopularity.class);
    }

    public static synchronized  TextPopularityService getInstance() {
        if (service == null) {
            service = new  TextPopularityService();
        }
        return service;
    }
    public TextFeedBackMetrics getTextFeedBackMetrics ( String url){
    	TextFeedBackMetrics feedbackMetrics= null;
    	try{
    		Iterator <TextPopularity> providers = loader.iterator();
    		while (feedbackMetrics==null && providers.hasNext()){
    			TextPopularity textPopularity= providers.next();
    			feedbackMetrics =textPopularity.getTextFeedBackMetada(url) ;
    			
    		}
    	}
    		catch (ServiceConfigurationError serviceError){
    			feedbackMetrics=null;
    			
    			serviceError.printStackTrace();
    		}
    	return feedbackMetrics;
    	
    }
}
