# Social entities popularity metrics SPI across social networks 
===========

Code for the paper
"Popularity metrics’ normalization for social media entities"


### Overview

The application defines a Service Provider Interface (SPI) as a set of java interfaces: 

* provides services to encapsulate popularity metrics of social entities: media (i.e. text, photo and video) and user (i.e profile) independently of the social networks they belong to. 

 * implements the provided services to encapsulate popularity metrics related to a YouTube video, a Facebook user and a tweet (i.e. textual entity) on Twitter.
 
 * ensures extensibility by allowing users to implement the provided services to encapsulate social entities popularity metrics in other social networks.

### SPI developpement

The application provides a set of auxiliary classes, two SPI and three implementation of the two SPI:
###### 1. Auxiliary classes

> encapsulate the different popularity metrics coming from several social networks and related to a specific social entity (i.e. text, photo, video and user) in a single object. 
>  So, each auxiliary classe  regroup all the attributes correspond to a social entity popularity and provide getters and setters allowing the access to those attributes.
>  The application provides for each social entity type (media and user)  three main auxiliary classes that ensure the categorization of attributes.

    User 
       * [UserProfileMetadata] - Exists under the package com.popularity.user.metrcis and encapsulates attributes related to the user metadata
       * [UserActivitiesMetadata] - Exists under the package com.popularity.user.metrcis and encapsulates attributes related to the user activities
       * [UserConnectivityMetadata] - Exists under the package com.popularity.user.metrcis and encapsulates attributes related to the user connectivity
> 
    Media
       * [MediaMetadataMetric]:Exists under the package com.popularity.media.metadata, regroups the commun metadata attributes between media entities and extended by three other auxiliary classes correspond to the  metadata specific of each media type (i.e.  text, photo and video)
        
       * [MediaUserFeedBackMetrics]:  Exists under the package com.popularity.media.Feedback, regroups the commun user feedback attributes between media entities and extended by an other auxiliary classe corresponds to the feedbacks specific of the video entity
       
       * [UserPopularityMetrics]: corresponds to the user auxiliary classes, in this case the user is the author of the media entity.
        
 
       
###### 2. SPI
* Media Popularity SPI: 
> defines services to encapsulate media (i.e. text, photo and video) popularity metrics.

```java
public interface MediaPopularity {
	public String getProviderName();
	public MediaMetadataMetrics getmetadata (String id_media);
	public MediaUserFeedBackMetrics getUserFeeBack (String id_media);
	public UserPopularityMetrics getAuthorPopularity (String id_media);
}
```
* User Popularity SPI: 
> defines services to encapsulate user popularity metrics.
```java
public interface UserPopularity {
	
public UserProfileMetadata getMetadata(String names);
public UserActivitiesMetadata getActivities(String name);
public UserConnectivityMetadata getConnectivity(String name);
public UserPopularityMetrics getPopularity (String name);
	
}
```
###### 3. Providers : SPI impelementation

The application includes three service providers. These providers implement the two SPI (media and user popularity SPI).They encapsulate popularity metrics correspond to video entity by implementing MediaPopularity for the a YouTube Video, for the text entity we implemented MediaPopularity SPI for a tweet on Twitter and for the user we implemented UserPopularity SPI for a Facebook User and Twitter User. 

In each implementation, the social network API is used in order to extract the appropriate metrics from the social network that would encapsulated using the SPI.

So, the application contains Twitter search , Facebook search and YouTube search classes that extract data from social networks using respectivly the Twitter search API, Facebook Graph API and Youtube Search API, the data is provided to the correspond service provider in order to encapsulated it. 


### Client Demo:

 The Client Demo is the part of testing the implemented SPI. It includes two main classes 
 an  the client service and service loader [MediaPoularityService](https://github.com/hibaSbei/SocialEntityPopularitySPI/blob/master/Popularity/src/com/popularity/loader/MediaPopularityService.java).
 
 * The client service: correspond tho class of the main method, the client of the SPI invokes the appropriate method for executing the UserPopularity SPI or the MediaPopularity SPI.  UserPopularity SPI the client provides the name of the user and the social network desired. For the MediaPopularity SPI the client invokes the id of the target media, the type of the media and the desired social network.
 
 
 * The MediaPoularityService: follows the Singleton Design Pattern. It loads the appropriate provider according to the request of the user.

In the case of the absence of desired social network the client can extend the SPI by implementing a new service provider for the desired social network.  
 
 ### References:
 
 Introduction to the Service Provider Interfaces (The Java™ Tutorials > Sound) https://docs.oracle.com/javase/tutorial/sound/SPI-intro.html

Creating Extensible Applications (The Java™ Tutorials > The Extension Mechanism > Creating and Using Extensions) https://docs.oracle.com/javase/tutorial/ext/basics/spi.html

Singleton Design Pattern (https://docs.oracle.com/javase/tutorial/ext/basics/spi.html#singleton

