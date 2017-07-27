# Popularity metrics’ normalization for social media entities
===========

### Overview

The application defines a Service Provider Interface (SPI) as a set of java interfaces: 

* Providing services to encapsulate popularity metrics of social entities: media (i.e. text, photo and video) and user (i.e profile) independently of the social networks they belong to. 

 * Implementing the provided services to encapsulate popularity metrics related to a YouTube video, a Facebook user and a tweet (i.e. textual entity) on Twitter.
 
 * Ensuring extensibility by allowing users to implement the provided services to encapsulate social entities popularity metrics in other social networks.

### SPI developpement

The application provides a set of auxiliary classes, two SPI and three implementation of the two SPI:
###### 1. Auxiliary classes
These classes are used for 
> encapsulating the different popularity metrics coming from several social networks and related to a specific social entity (i.e. text, photo, video and user) in a single object. 
>  So, each auxiliary class  regroups all the attributes corresponding to the popularity of social entity and provides getters and setters allowing the access to those attributes.
>  The application provides for each social entity type (media and user)  three main auxiliary classes that ensure the categorization of attributes.

    User 
       * [UserProfileMetadata] - It exists under the package com.popularity.user.metrcis and encapsulates attributes related to the user metadata
       * [UserActivitiesMetadata] -It exists under the package com.popularity.user.metrcis and encapsulates attributes related to the user activities
       * [UserConnectivityMetadata] - It exists under the package com.popularity.user.metrcis and encapsulates attributes related to the user connectivity
> 
    Media
       * [MediaMetadataMetric]: It exists under the package com.popularity.media.metadata, regroups the commun metadata attributes between media entities and extended by three other auxiliary classes corresponding to the specific metadata  of each media type (i.e.  text, photo and video)
       * [MediaUserFeedBackMetrics]:  It exists under the package com.popularity.media.Feedback, regroups the commun user feedback attributes between media entities and extended by another auxiliary class which corresponds to the specific feedbacks of the video entity    
       * [UserPopularityMetrics]: It corresponds to the user auxiliary classes, the user is the author of the media entity.
###### 2. SPI
* Media Popularity SPI: 
> It defines the services exploited to encapsulate media (i.e. text, photo and video) popularity metrics.

```java
public interface MediaPopularity {
	//For identifying the appropriate provider
	public String getProviderName();
	
	// service for encapsulate the metadata metrics of the media entity (i.e. Text, Photo and Video) correpond to the id_media
	public MediaMetadataMetrics getmetadata (String id_media);
	
	// service for encapsulate the feedback of users in front of the target media entity (i.e. Text, Photo and Video) correpond to the id_media
	public MediaUserFeedBackMetrics getUserFeeBack (String id_media);
	
	// service for encapsulate the metrics of the author of the media entity (i.e. Text, Photo and Video) correpond to the id_media
	public UserPopularityMetrics getAuthorPopularity (String id_media);
}
```
* User Popularity SPI: 
> It defines he tservices to encapsulate user popularity metrics.
```java
public interface UserPopularity {

	// service for encapsulate the metadata metrics of the user entity 
public UserProfileMetadata getMetadata(String names);

// service for encapsulate the  metrics describes the activities of the user entity 
public UserActivitiesMetadata getActivities(String name);

// service for encapsulate the metrics of the connectivity  of the user entity 
public UserConnectivityMetadata getConnectivity(String name);

// service for encapsulate all the metrics of the user popularity 
public UserPopularityMetrics getPopularity (String name);
}
```
###### 2. Providers: SPI impelementation

The application includes three service providers. These providers implement the two SPIs (media and user popularity SPIs).They encapsulate popularity metrics corresponding to:
*  Video entity by implementing MediaPopularity for a YouTube Video
*  Text entity via the implementation of the MediaPopularity SPI for a tweet on Twitter and 
*  User through the implementation of the UserPopularity SPI for a Facebook User and Twitter User

In each implementation, the social network API is used in order to extract the appropriate metrics from the social network that would be encapsulated using the SPI.

So, the application contains Twitter search, Facebook search and YouTube search classes that extract data from social networks using respectively the Twitter search API, Facebook Graph API and Youtube Search API. The data is provided to the right service provider in order to encapsulate it. 


### Client Demo:

 The Client Demo is the test part of the implemented SPI. It includes three main classes: 
the client service corresponds to [SearchProviderDemo](https://github.com/hibaSbei/SocialEntityPopularitySPI/blob/master/Popularity/src/com/popularity/client/demo/SearchProviderDemo.java) and the service loader [MediaPoularityService](https://github.com/hibaSbei/SocialEntityPopularitySPI/blob/master/Popularity/src/com/popularity/loader/MediaPopularityService.java).
 
 * The client service: correspond contains the main method, the client of the SPI invokes the appropriate method for executing the UserPopularity SPI or the MediaPopularity SPI. For executing the UserPopularity SPI  the client provides values correspond to the name of the user and the target social network. For the MediaPopularity SPI the client invokes the id of the target media, the type of the media and the desired social network.
 
 
 * The MediaPoularityService: follows the Singleton Design Pattern. It loads the appropriate provider according to the request of the user.

In the case of the absence of desired social network the client can extend the SPI by implementing a new service provider for the desired social network.  
 
 ### References:
 
 Introduction to the Service Provider Interfaces (The Java™ Tutorials > Sound) https://docs.oracle.com/javase/tutorial/sound/SPI-intro.html

Creating Extensible Applications (The Java™ Tutorials > The Extension Mechanism > Creating and Using Extensions) https://docs.oracle.com/javase/tutorial/ext/basics/spi.html

Singleton Design Pattern https://docs.oracle.com/javase/tutorial/ext/basics/spi.html#singleton

