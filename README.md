# EventTrackerProject

## Overview
This is a JPA project that will develop to be a site to track comedy shows with full CRUD funcationality, where a user will be able to read/search, add, update and delete comedians, venues, categories and comedy shows. At this current point, the backend has been flushed out and the next step is to complete the frontend. The followings show the REST API routs and their functions.

## API Routes

### Comedy Event
| HTTP Method |               Endpoint             		 | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  'api/comedyEvents'                      | Find all comedy events                |
|    Get      |  api/comedyEvents/{comedyEventId}        | Find comedy event by Id               |    
|    Post     |  api/comedyEvents                        | Create comedy event                   |   
|    Put      |  api/comedyEvents/{comedyEventId}        | Update a comedy event                 | 
|   Delete    |  api/comedyEvents/{comedyEventId}        | Delete a comedy event                 | 
|    Get      |  api/comedyEvents/search/comedian/{name} | Find comedy events by comedian name   | 
|    Get      |  api/comedyEvents/search/rating/{rating} | Find comedy events by rating          | 
|    Get      |  api/comedyEvents/search/venue/{venue}   | Find comedy events by venue           | 

### Venue
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  api/venues                              | Find all venues                       |
|    Get      |  api/venues/{venueId}                    | Find veneus by Id                     |    
|    Post     |  api/venues                              | Create venue                          |   
|    Put      |  api/venues/{venueId}                  	 | Update a venue                        | 
|   Delete    |  api/venues/{venueId}                    | Delete a venue                        | 
|    Get      |  api/venues/search/name/{name}           | Find venue by name                    | 
|    Get      |  api/venues/search/city/{city}           | Find venue by city                    | 
|    Get      |  api/venues/search/state/{state}         | Find venue by state                   | 

### Comedian
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  api/comedians                           | Find all comedians                    |
|    Get      |  api/comedians/{comedianId}              | Find comedian by Id                   |    
|    Post     |  api/comedians                           | Create comedian                       |   
|    Put      |  api/comedians/{comedianId}         	 | Update a comedian                     | 
|   Delete    |  api/comedians/{comedianId}              | Delete a comedian                     | 
|    Get      |  api/comedians/search/name/{name}        | Find comedian by name                 | 
|    Get      |  api/comedians/search/category/{category}| Find comedian by category             | 

### Category
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  api/categories                          | Find all categories                   |
|    Get      |  api/categories/{categoryId}             | Find category by Id                   |    
|    Post     |  api/categories                          | Create category                       |   
|    Put      |  api/categories/{categoryId}         	 | Update a category                     | 
|   Delete    |  api/categories/{categoryId}             | Delete a category                     | 


