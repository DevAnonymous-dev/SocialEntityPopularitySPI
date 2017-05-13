# SocialEntityPopularitySPI
Sample Java SPI (Service Provider Interfacce) Demo provides unified services for defining social entities (i.e. text, video, photo and user) popularities indepedantlay on social networks they belong to.

A. Introduction

The demo app include 2 SPI (jar files)

1. MediaPoularityService

Defines popularity.spi.MediaPopularity interface for service provider.
Provides popularity.service.loader.PopularityService utility class to wrap java.util.ServiceLoader<MediaPopularirty> operations.

2. UserPoularityService

Defines popularity.spi.UserPopularity interface for service provider.
Provides popularity.service.loader.PopularityService utility class to wrap java.util.ServiceLoader<UserPopularirty> operations.

3. VideoPopularityProvider, TextPopularityProvider and PhotoPopularityProvider

Implementations for MediaPopularity

 4. UserPopularityProvider

Implementations for UserPopularity 

5. MediaPopularityMetrics and UserPopularityMetrics
Classes for reading entity popularity metrics.

6. DemoApp
client app for PopularityService
Implementations self providers for PopularityService 

B. Requirements
 JDK 1.6 or over
 
C. References

 Introduction to the Service Provider Interfaces (The Java™ Tutorials > Sound)
https://docs.oracle.com/javase/tutorial/sound/SPI-intro.html

Creating Extensible Applications (The Java™ Tutorials > The Extension Mechanism > Creating and Using Extensions)
https://docs.oracle.com/javase/tutorial/ext/basics/spi.html
