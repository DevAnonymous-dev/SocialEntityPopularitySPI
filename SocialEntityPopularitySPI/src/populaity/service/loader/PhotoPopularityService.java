package populaity.service.loader;

import java.util.ServiceLoader;

import popularity.spi.PhotoPopularity;
//implements singleton pattern
public class PhotoPopularityService {
	// ensures only one instance of ImagePopularityService exists
	private static PhotoPopularityService service;
    private ServiceLoader<PhotoPopularity> loader;
 // prevents all other classes, except ImagePopularityService, from creating instances of it
    private PhotoPopularityService() {
        loader = ServiceLoader.load(PhotoPopularity.class);
    }

    public static synchronized PhotoPopularityService getInstance() {
        if (service == null) {
            service = new PhotoPopularityService();
        }
        return service;
    }
}
