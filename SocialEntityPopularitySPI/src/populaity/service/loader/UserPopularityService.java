package populaity.service.loader;

import java.util.ServiceLoader;

import popularity.spi.UserPopularity;
//implements singleton pattern
public class UserPopularityService {
	
	// ensures only one instance of UserPopularityService exists
	private static   UserPopularityService service;
    private ServiceLoader<  UserPopularity> loader;
    
// prevents all other classes, except UserPopularityService, from creating instances of it
    private   UserPopularityService() {
        loader = ServiceLoader.load(UserPopularity.class);
    }

    public static synchronized   UserPopularityService getInstance() {
        if (service == null) {
            service = new   UserPopularityService();
        }
        return service;
    }
}
