package com.popularity.search;

import java.util.ArrayList;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import com.popularity.authentification.TwitterAuthentification;
import com.popularity.media.feedback.MediaUserFeedBackMetrics;
import com.popularity.media.metadata.MediaMetadataMetrics;
import com.popularity.media.metadata.TextMetadataMetrics;
import com.popularity.user.metrcis.Activity;
import com.popularity.user.metrcis.Connectivity;
import com.popularity.user.metrcis.ConnectivityType;
import com.popularity.user.metrcis.UserActivitiesMetadata;
import com.popularity.user.metrcis.UserConnectivityMetadata;
import com.popularity.user.metrcis.UserPopularityMetrics;
import com.popularity.user.metrcis.UserProfileMetadata;

public class TwitterTextSearch {

	TwitterAuthentification twitterAuth = new TwitterAuthentification();
	Twitter twitter;
	TextMetadataMetrics textmetadata;
	MediaUserFeedBackMetrics feedback;
	UserProfileMetadata userMetadata;
	UserConnectivityMetadata userConnectivity;
	UserActivitiesMetadata userActivities;
	UserPopularityMetrics userPopularity;
	

	// search metadata
	public MediaMetadataMetrics getTextMetadataById(String tweet_id) {

		try {
			twitter = twitterAuth.auth();
			Status status = twitter.showStatus(Long.parseLong(tweet_id));
			if (status == null) {
				System.out.println("no tweet correspond to this id");

			} else {
				// return tweet metadata

				textmetadata = new TextMetadataMetrics(status.getSource(),
						status.getCreatedAt(), status.getText());
			
				System.out.println("**********textmetadatPopularityMetrics********** \n");
				System.out.println("text:" +textmetadata.getText()+"\n");
				System.out.println("URL: "+textmetadata.getUrl()+"\n");
				System.out.println("CreatedAT: "+ textmetadata.getCreatedAt()+"\n");
				
		
			

			}
		} catch (TwitterException te) {
			System.out.println("Couldn't connect: " + te);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return textmetadata;

	}

	// search feedback

	public MediaUserFeedBackMetrics getTextFeedBackById(String tweet_id) {

		try {
			twitter = twitterAuth.auth();
			Status status = twitter.showStatus(Long.parseLong(tweet_id));
			if (status == null) {
				System.out.println("no tweet correspond to this id");

			} else {
				// return tweet metadata

				feedback = new MediaUserFeedBackMetrics(0,
						status.getRetweetCount(), status.getFavoriteCount(), 0);
				System.out.println ("**************** MediaFeedBackMetrics********** \n");
				System.out.println ("#Comments = "+ feedback.getNbComments()+"\n");
				System.out.println ("#NegativeVote= "+ feedback.getNbNegativeVote()+"\n");
				System.out.println ("#PositiveVote = "+ feedback.getNbPositiveVote()+"\n");
				System.out.println ("#Shares = "+ feedback.getNbShare()+"\n");
				

			}
		} catch (TwitterException te) {
			System.out.println("Couldn't connect: " + te);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return feedback;

	}
//search author popularity metrics
		public UserPopularityMetrics getAuthorPopularity(String tweet_id) {
           
			System.out.println ("search author popularity");
			try {
				twitter = twitterAuth.auth();
				Status status = twitter.showStatus(Long.parseLong(tweet_id));
				if (status == null) {
					System.out.println("no tweet correspond to this id");

				} else {
					// return tweet metadata
			
					String authorName= status.getUser().getScreenName();
					System.out.println ("author name = "+ authorName);
					userPopularity = getUserPopularityById( authorName);

				}
			} catch (TwitterException te) {
				System.out.println("Couldn't connect: " + te);
			} catch (Exception e) {

				e.printStackTrace();
			}
			return userPopularity;

		}

	// search user metadata by id

	public UserProfileMetadata getUserPopularityMetricsById(String Screenname) {
       System.out.println (" Twitter search user profile");
		try {
			twitter = twitterAuth.auth();
			User user = twitter.showUser(Screenname);
			if (user == null) {
							System.out.println("no user correspond to this id");

			} else {
				// return user metadata
				userMetadata = new UserProfileMetadata(user.getURL(),
						user.getName(), "", user.getDescription(), "",
						user.getCreatedAt());
				   System.out.println ("***************User Profile Metadata*******\n");
				   System.out.println ("Category = "+ userMetadata.getCategory()+"\n");
				   System.out.println (" description = "+ userMetadata.getDescription()+"\n");
				   System.out.println ("gender= "+ userMetadata.getGender()+"\n");

			}
		} catch (TwitterException te) {
			System.out.println("Couldn't connect: " + te);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return userMetadata;

	}

	// search user connectivity by id

	public UserConnectivityMetadata getUserConnectivityById(String name) {

		try {
			twitter = twitterAuth.auth();

			User user = twitter.showUser(name);

			if (user == null) {
				System.out.println("no user correspond to this id");

			} else {
				// retur user metadata

				Connectivity friends = new Connectivity(
						ConnectivityType.indegree, "friend",
						user.getFriendsCount());
				Connectivity followers = new Connectivity(
						ConnectivityType.indegree, "follow by",
						user.getFollowersCount());
				Connectivity favorites = new Connectivity(
						ConnectivityType.outdegree, "favorite",
						user.getFavouritesCount());
				ArrayList<Connectivity> connectivities = new ArrayList<Connectivity>();
				connectivities.add(favorites);
				connectivities.add(followers);
				connectivities.add(friends);
				userConnectivity = new UserConnectivityMetadata(connectivities);
				System.out.println (" *******************User Connectivity************\n");
			for (int i=0; i<connectivities.size(); i++){
				
				System.out.println ("connectivity metric " + i+ ": "+userConnectivity.getConnectivity().get(i).toString()+ "\n");
			}

			}
		} catch (TwitterException te) {
			System.out.println("Couldn't connect: " + te);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return userConnectivity;

	}

	// search user activities by id

	public UserActivitiesMetadata getUserActivitiesById(String name) {

		try {
			twitter = twitterAuth.auth();

			User user = twitter.showUser(name);

			if (user == null) {
				System.out.println("no user correspond to this id");

			} else {
				// return user activities 
				//activity on twitter is a one activity Tweet
				Activity activity = new Activity ("Tweet",
						user.getStatusesCount());
				ArrayList<Activity> activities = new ArrayList<Activity>();
				activities.add(activity);
				userActivities = new UserActivitiesMetadata(activities);
				System.out.println ("************User Activities************ \n");
				for (int i=0; i<activities.size(); i++){
				System.out.println ("Le" + i +"éme activity: "+ userActivities.getActivities().get(i).toString()+ "\n");
				}
				
			}
		} catch (TwitterException te) {
			System.out.println("Couldn't connect: " + te);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return userActivities;

	}

	// search user popularity metrics by id

	public UserPopularityMetrics getUserPopularityById(String name) {
		System.out.println ("search author popularity by id");

		try {
			twitter = twitterAuth.auth();

			User user = twitter.showUser(name);

			if (user == null) {
				System.out.println("no user correspond to this id");

			} else {
				// return user metadata

				userPopularity = new UserPopularityMetrics(
						getUserPopularityMetricsById(name),
						getUserActivitiesById(name),
						getUserConnectivityById(name));
                System.out.println ("****************user popularity metrics**************** \n");
				System.out.println (" user Popularity :" + "\n"+ "profile metadata: "+ userPopularity.getUserprofile().toString()+ "\n"+ 
					"user connectivity: "+	userPopularity.getConnectivity().toString()+ "\n"+ "user activities: "+ userPopularity.getUseractivities().toString());
			}
		} catch (TwitterException te) {
			System.out.println("Couldn't connect: " + te);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return userPopularity;

	}

}
