package service.client;

import populaity.service.loader.TextPopularityService;

public class TextPopularityServiceUser {
	//service loader
private static TextPopularityService service;
public void main (String []args){
	service= TextPopularityService.getInstance();
	System.out.println(service.getTextFeedBackMetrics("url"));
}

}
