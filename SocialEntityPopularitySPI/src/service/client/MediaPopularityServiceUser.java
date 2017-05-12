package service.client;

import populaity.service.loader.PopularityService;


public class MediaPopularityServiceUser {
	//service loader
private static PopularityService service;
public void main (String []args){
	service= PopularityService.getInstance();
	System.out.println(service.getMediaPopularityMetrics("urlText"));
}

}
