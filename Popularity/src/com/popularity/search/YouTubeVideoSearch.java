package com.popularity.search;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoGetRatingResponse;
import com.google.api.services.youtube.model.VideoListResponse;
import com.popularity.authentification.Auth;
import com.popularity.media.feedback.VideoUserFeedBackMetrics;
import com.popularity.media.metadata.VideoMetadataMetrics;

public class YouTubeVideoSearch {

	/**
	 * Define a global variable that identifies the name of a file that contains
	 * the developer's API key.
	 */
	private static final String PROPERTIES_FILENAME = "youtube.properties";

	private static final long NUMBER_OF_VIDEOS_RETURNED = 2;

	/**
	 * Define a global instance of a Youtube object, which will be used to make
	 * YouTube Data API requests.
	 */
	private static YouTube youtube;
	List<ResourceId> resources;

	public Video searchVideo (String id) {
		Video video = null ;
		// Read the developer key from the properties file.
		Properties properties = new Properties();
		try {
			InputStream in = YouTubeVideoSearch.class.getResourceAsStream("/"
					+ PROPERTIES_FILENAME);
			properties.load(in);
		} catch (IOException e) {
			System.err.println("There was an error reading "
					+ PROPERTIES_FILENAME + ": " + e.getCause() + " : "
					+ e.getMessage());
			System.exit(1);
		}

		try {
			// This object is used to make YouTube Data API requests. The last
			// argument is required, but since we don't need anything
			// initialized when the HttpRequest is initialized, we override
			// the interface and provide a no-op function.
			youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT,
					Auth.JSON_FACTORY, new HttpRequestInitializer() {
						public void initialize(HttpRequest request)
								throws IOException {
						}
					}).setApplicationName("YouTubeSearch").build();

			
			// Define the API request for retrieving search results.

			HashMap<String, String> parameters = new HashMap<>();
			parameters.put("part", "snippet,contentDetails,statistics");
			parameters.put("id", id);
			 parameters.put("onBehalfOfContentOwner", "");

		     
			com.google.api.services.youtube.YouTube.Videos.List list = youtube
					.videos().list(parameters.get("part").toString());
			 if (parameters.containsKey("id") && parameters.get("id") != "") {
		           list.setId(parameters.get("id").toString());
		        }
			   YouTube.Videos.GetRating videosGetRatingRequest = youtube.videos().getRating(parameters.get("id").toString());
		        if (parameters.containsKey("onBehalfOfContentOwner") && parameters.get("onBehalfOfContentOwner") != "") {
		            videosGetRatingRequest.setOnBehalfOfContentOwner(parameters.get("onBehalfOfContentOwner").toString());
		        }

		    	// Set your developer key from the Google API Console for
				// non-authenticated requests. See:
				// https://console.developers.google.com/
				String apiKey = properties.getProperty("youtube.apikey");
				
				list.setKey(apiKey);
				VideoGetRatingResponse rating = videosGetRatingRequest.execute();
			
			VideoListResponse response = list.execute();
		video = response.getItems().get(0);
			System.out.println("video" + video.toString());
			

		} catch (GoogleJsonResponseException e) {
			System.err.println("There was a service error: "
					+ e.getDetails().getCode() + " : "
					+ e.getDetails().getMessage());
		} catch (IOException e) {
			System.err.println("There was an IO error: " + e.getCause() + " : "
					+ e.getMessage());
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return video;
	}
	
	// search video metadata
		public VideoMetadataMetrics getVideoMetadataById(String VideoId) {
			Date date = null ;
			System.out.println ("********video popularity metadata************^n");
			Video v =searchVideo(VideoId);
			
			
			SimpleDateFormat dateDisplayFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			try {
				 date = dateDisplayFormat.parse(v.getSnippet().getPublishedAt().toString());
			} catch (ParseException e) {
				
				e.printStackTrace();
			} 
		
			String url = "youtube.com/watch?v=" + VideoId;
		
			VideoMetadataMetrics videoMetadata = new VideoMetadataMetrics(url,date,v.getSnippet().getTitle(), v.getSnippet().getDescription(),  v.getSnippet().getCategoryId(), v.getSnippet().getTags().toString(), v.getFileDetails().getDurationMs().toString());
			System.out.println ("Video popularity metadata: "+ videoMetadata.toString());
			
			return videoMetadata;
		}
		// search video feedback
		public VideoUserFeedBackMetrics getVideoFeedBackById(String VideoId) {
			Video v =searchVideo(VideoId);
			VideoUserFeedBackMetrics videofeedBack= new VideoUserFeedBackMetrics(0,v.getStatistics().getCommentCount().intValue(),
					v.getStatistics().getFavoriteCount().intValue()+v.getStatistics().getLikeCount().intValue(),
					v.getStatistics().getDislikeCount().intValue(),
				"",
					v.getStatistics().getViewCount().intValue());
			System.out.println (" video feedback "+ videofeedBack.toString());
		
			return videofeedBack;

		}

	

}
