package com.popularity.search;

import java.util.ArrayList;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import com.popularity.authentification.TwitterAuthentification;
import com.popularity.media.feedback.MediaUserFeedBackMetrics;
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
	public TextMetadataMetrics getTextMetadataById(String tweet_id) {

		try {
			twitter = twitterAuth.auth();
			Status status = twitter.showStatus(Long.parseLong(tweet_id));
			if (status == null) {
				System.out.println("no tweet correspond to this id");

			} else {
				// return tweet metadata

				textmetadata = new TextMetadataMetrics(status.getSource(),
						status.getCreatedAt(), status.getText());
				System.out.println("textmetadata " + textmetadata.toString());

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

			}
		} catch (TwitterException te) {
			System.out.println("Couldn't connect: " + te);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return feedback;

	}

	// search feedback

		public UserPopularityMetrics getAuthorPopularity(String tweet_id) {

			try {
				twitter = twitterAuth.auth();
				Status status = twitter.showStatus(Long.parseLong(tweet_id));
				if (status == null) {
					System.out.println("no tweet correspond to this id");

				} else {
					// return tweet metadata

					String authorName= status.getUser().getName();
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

	public UserProfileMetadata getUserPopularityMetricsById(String name) {

		try {
			twitter = twitterAuth.auth();

			User user = twitter.showUser(name);

			if (user == null) {
				System.out.println("no user correspond to this id");

			} else {
				// return user metadata
				userMetadata = new UserProfileMetadata(user.getURL(),
						user.getName(), "", user.getDescription(), "",
						user.getCreatedAt());

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
				// return user metadata
				Activity activity = new Activity("Status",
						user.getStatusesCount());
				ArrayList<Activity> activities = new ArrayList<Activity>();
				activities.add(activity);
				userActivities = new UserActivitiesMetadata(activities);
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

			}
		} catch (TwitterException te) {
			System.out.println("Couldn't connect: " + te);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return userPopularity;

	}

}
