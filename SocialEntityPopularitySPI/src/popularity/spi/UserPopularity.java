package popularity.spi;

import popularity.media.metrics.UserActivitiesMetadata;
import popularity.media.metrics.UserConnectivityMetadata;
import popularity.media.metrics.UserProfileMetadata;

public interface UserPopularity {
	//provided service to define user popularity 
	public UserProfileMetadata defineProfileMetadata (String url_user);
	public UserConnectivityMetadata defineUserConnectivity (String url_user);
	public UserActivitiesMetadata defineUserConnectivityMetadata (String url_user);

}
