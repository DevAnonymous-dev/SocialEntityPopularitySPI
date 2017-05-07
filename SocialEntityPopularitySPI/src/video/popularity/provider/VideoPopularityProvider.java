package video.popularity.provider;

import java.util.SortedMap;
import java.util.TreeMap;

import popularity.spi.VideoPopularity;

public class VideoPopularityProvider implements VideoPopularity{
	
	private SortedMap<String, VideoFeedBackMetrics>feedBackMetrics;
	private SortedMap<String,VideoMetadataMetrics> metadataMetrics;
	private SortedMap<String, VideoAuthorMetrics> authorMetrics;
	
	public VideoPopularityProvider (){
		feedBackMetrics= new TreeMap <String, VideoFeedBackMetrics>();
		 metadataMetrics= new TreeMap <String, VideoMetadataMetrics>();
		 authorMetrics= new TreeMap <String, VideoAuthorMetrics>();
	}

	@Override
	public VideoFeedBackMetrics getVideoFeedBackMetada(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoMetadataMetrics getVideoMetadaMetrics(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoAuthorMetrics getVideoAuthorMetrics(String url) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
