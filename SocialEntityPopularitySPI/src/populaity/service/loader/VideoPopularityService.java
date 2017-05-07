package populaity.service.loader;

import java.util.ServiceLoader;

import popularity.spi.VideoPopularity;

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

}
