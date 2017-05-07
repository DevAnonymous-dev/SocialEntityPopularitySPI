package service.client;

import populaity.service.loader.VideoPopularityService;

public class VideoPopularityServiceUser {
	//service loader
	private static VideoPopularityService service;
	public void main (String []args){
		service= VideoPopularityService.getInstance();
		System.out.println(service.getVideoFeedBackMetrics("url"));
	}

}
