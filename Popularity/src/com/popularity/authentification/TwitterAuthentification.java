package com.popularity.authentification;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuthentification {
	
	  public Twitter auth() throws Exception  {

	    ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	      .setOAuthConsumerKey("PABFihu6l8UMSPui1Deu9EXIi")
	      .setOAuthConsumerSecret("8deCW4hAw1t7LL1OaTiy5Z2qcE0YGoQb1s88bfLL1LO4mNk5XG")
	      .setOAuthAccessToken("4220969668-U6GjUpCzhgjNuOIyp5lISqgm8N2o1B5comhhyOb")
	      .setOAuthAccessTokenSecret("FcVx2whqhTfxlQ3YY8tWS6pL8gNVOjIqH3kPlkGClhjB9");
	    Twitter twitter = new TwitterFactory(cb.build()).getInstance();
	    return twitter;
	  }
	  

}
