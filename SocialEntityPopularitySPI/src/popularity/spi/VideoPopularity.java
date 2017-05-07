package popularity.spi;

import video.popularity.provider.VideoAuthorMetrics;
import video.popularity.provider.VideoFeedBackMetrics;
import video.popularity.provider.VideoMetadataMetrics;


public interface VideoPopularity {


	public VideoFeedBackMetrics getVideoFeedBackMetada( String url) ;
	public VideoMetadataMetrics getVideoMetadaMetrics( String url) ;
	public VideoAuthorMetrics getVideoAuthorMetrics(String url);
	
}
