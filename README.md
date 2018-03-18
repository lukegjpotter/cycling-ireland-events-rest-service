# Cycling Ireland Events REST Service

A RESTful Service to deliver the Cycling Events from Cycling Ireland.

[![Build Status](https://travis-ci.org/lukegjpotter/cycling-ireland-events-rest-service.svg?branch=master)](https://travis-ci.org/lukegjpotter/cycling-ireland-events-rest-service)
[![Coverage Status](https://coveralls.io/repos/github/lukegjpotter/cycling-ireland-events-rest-service/badge.svg?branch=master)](https://coveralls.io/github/lukegjpotter/cycling-ireland-events-rest-service?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/59f44a6015f0d71f1ecba497/badge.svg)](https://www.versioneye.com/user/projects/59f44a6015f0d71f1ecba497)
[![Issue Count](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-rest-service/badges/issue_count.svg)](https://codeclimate.com/github/lukegjpotter/cycling-ireland-events-rest-service)
[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Environment Setup

Follow the [Data Base](https://github.com/lukegjpotter/cycling-ireland-events-rest-service/wiki/Setup) steps on the wiki.

## Build, Run and Test

To Build and Run the Application:

1. Set the Database_URL in the IDE Run Configurations or local CLI Variable:  
   `./setEnvironmentVariables.sh`
1. To Build and Run, open a Terminal and use:  
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

## Live on Heroku

Swagger Documentation is available.  
For the [CyclingEventController](https://cyclingirelandevents.herokuapp.com/swagger-ui.html#/cycling-event-controller).