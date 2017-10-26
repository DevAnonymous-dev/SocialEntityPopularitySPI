package com.popularity.authentification;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuthentification {
	
	  public Twitter auth() throws Exception  {

	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	      .setOAuthConsumerKey("consumer_Key")
	      .setOAuthConsumerSecret("consumer_secret_key")
	      .setOAuthAccessToken("access_token")
	      .setOAuthAccessTokenSecret("access_token_secret");
	    Twitter twitter = new TwitterFactory(cb.build()).getInstance();
	    return twitter;
	  }
	  

}
