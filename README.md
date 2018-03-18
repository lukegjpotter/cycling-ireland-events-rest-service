# Cycling Ireland Events REST Service

A RESTful Service to deliver the Cycling Events from Cycling Ireland.

[![Build Status](https://travis-ci.org/lukegjpotter/cycling-ireland-events-rest-service.svg?branch=master)](https://travis-ci.org/lukegjpotter/cycling-ireland-events-rest-service)
[![Coverage Status](https://coveralls.io/repos/github/lukegjpotter/cycling-ireland-events-rest-service/badge.svg?branch=master)](https://coveralls.io/github/lukegjpotter/cycling-ireland-events-rest-service?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/59f44a6015f0d71f1ecba497/badge.svg)](https://www.versioneye.com/user/projects/59f44a6015f0d71f1ecba497)
[![Issue Count](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-rest-service/badges/issue_count.svg)](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-rest-service)
[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Initial Database Setup

Follow the "Initial Database Setup" and "Build, Run and Test" steps in the 
[CyclingIrelandEventsHTMLScraper project's ReadME file](https://github.com/lukegjpotter/cycling-ireland-events-html-scraper/blob/master/README.md).

**Important:** Before you build and run the CyclingIrelandEventsHTMLScraper, ensure that its `application.properties` file, in `src/main/resources`, has `spring.jpa.hibernate.ddl-auto=create`, at line 15, as to not drop the database after it has stopped running. This means that the datbase will be available for this Service to read from.

By the end of those steps, there should be data in the `cyclingirelandevents`
Postgres database.

## Build, Run and Test

1. To Build and Run the Application, open a Terminal and use:  
   `./gradlew build bootRun`
1. To Test that the running Application is functional, open a new Terminal tab
   and use:  
   `curl localhost:8080/roadraces/1` to read from the local database.
1. API documentation is available via Swagger UI go to:  
   http://localhost:8080/swagger-ui.html
1. To Stop the Application, in the first Terminal, use:  
   `ctrl+C`


## Current Status

Check the [Projects Tab](https://github.com/lukegjpotter/cycling-ireland-events-rest-service/projects) for the latest status of the project.
