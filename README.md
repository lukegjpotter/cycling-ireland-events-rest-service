# Cycling Ireland Events REST Service

A RESTful Service to deliver the Cycling Events from Cycling Ireland.

Version 1 is currently in development.

## Build, Run and Test
To Build and Run the Application, open a Terminal and use: `/gradlew build && java -jar build/libs/cycling-ireland-events-rest-service-*.jar`

To Test that the running Application is functional, open a new Terminal tab and use: `curl localhost:8080/roadraces`

To Stop the Application, in the first Terminal, use `ctrl+C`

## Version 1 Planned Features
Returns the basic information about the Road Races.
This information will be just showing which race has which categories, e.g. Waller Cup has A+, A1, ..., Womens.

## Version 2 Planned Features
Return detailed information about the Road Races.
This information will be broken down by race category, e.g. Waller Cup; A1 race is 130km starts at 11:00, ... A4 race is 50km starts at 11:20.

## Version 3 Planned Features
Return very detailed information about the Road Races.
This information will include which races are part of the Men's Nation League and the Women's National League.