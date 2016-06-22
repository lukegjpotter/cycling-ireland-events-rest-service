# Cycling Ireland Events REST Service

A RESTful Service to deliver the Cycling Events from Cycling Ireland.

[![Build Status](https://travis-ci.org/lukegjpotter/cycling-ireland-events-rest-service.svg?branch=master)](https://travis-ci.org/lukegjpotter/cycling-ireland-events-rest-service)
[![Coverage Status](https://coveralls.io/repos/github/lukegjpotter/cycling-ireland-events-rest-service/badge.svg?branch=master)](https://coveralls.io/github/lukegjpotter/cycling-ireland-events-rest-service?branch=master)
[![Issue Count](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-rest-service/badges/issue_count.svg)](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-rest-service)

## Initial Database Setup

Follow the "Initial Database Setup" and "Build, Run and Test" steps in the 
[CyclingIrelandEventsHTMLScraper project's ReadME file](https://github.com/lukegjpotter/cycling-ireland-events-html-scraper/blob/master/README.md).

**Important:** Before you build and run the CyclingIrelandEventsHTMLScraper, ensure that its `application.properties` file, in `src/main/resources`, has `spring.jpa.hibernate.ddl-auto=create`, at line 15, as to not drop the database after it has stopped running. This means that the datbase will be available for this Service to read from.

By the end of those steps, there should be data in the `cyclingirelandevents`
Postgres database.

## Build, Run and Test

1. To Build and Run the Application, open a Terminal and use:  
   `./gradlew build && java -jar build/libs/cycling-ireland-events-rest-service-*.jar`
1. To Test that the running Application is functional, open a new Terminal tab
   and use:  
   `curl localhost:8080/roadraces`
1. To Stop the Application, in the first Terminal, use:  
   `ctrl+C`


## Version 1.0 Features - Released

* [x] Returns the basic information about the Road Races from the CSV file.  
      This information will be just showing which race has which categories,
      e.g. Waller Cup has A+, A1, ..., Womens.

## Version 2.0 Features - In Development

* [ ] Return detailed information about the Road Races from a local database.  
      This information will be broken down by race category, e.g. Waller Cup;
      A1 race is 130km starts at 11:00, ... A4 race is 50km starts at 11:20.
* [ ] Provide a REST Resource to GET Road Races happening between two dates.

## Version 3.0 Features

* [ ] Return Road Races from a Heroku Postgres database.

## Version 4.0 Features

* [ ] Return very detailed information about the Road Races.  
      This information will include which races are part of the Men's Nation
      League and the Women's National League.

## Version 5.0 Features

* [ ] A way to check if Events have been cancelled, postponed and/or rescheduled.
