# SocialEntityPopularitySPI
Sample Java SPI (Service Provider Interfacce) Demo provides unified services for defining social entities (i.e. text, video, photo and user) popularities indepedantlay on social networks they belong to.

Introduction

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
