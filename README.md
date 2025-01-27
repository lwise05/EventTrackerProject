# EventTrackerProject

## Overview
This is a JPA project that will develop to be a site to track comedy shows with full CRUD funcationality, where a user will be able to read/search, add, update and delete comedians, venues, categories and comedy shows. At this current point, the backend has been flushed out and the next step is to complete the frontend. The following show the REST API routs and their functions.

## API Routes

### Comedy Event
| HTTP Method |               Endpoint             		 | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  api/comedyEvents                        | find all comedy events                |
|    Get      |  api/comedyEvents/{comedyEventId}        | find comedy event by Id               |    
|    Post     |  api/comedyEvents                        | create comedy event                   |   
|    Put      |  api/comedyEvents/{comedyEventId}        | update a comedy event                 | 
|   Delete    |  api/comedyEvents/{comedyEventId}        | delete a comedy event                 | 
|    Get      |  api/comedyEvents/search/comedian/{name} | find comedy events by comedian name   | 
|    Get      |  api/comedyEvents/search/rating/{rating} | find comedy events by rating          | 
|    Get      |  api/comedyEvents/search/venue/{venue}   | find comedy events by venue           | 

### Venue
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  api/venues                              | find all venues                       |
|    Get      |  api/venues/{venueId}                    | find veneus by Id                     |    
|    Post     |  api/venues                              | create venue                          |   
|    Put      |  api/venues/{venueId}                  	 | update a venue                        | 
|   Delete    |  api/venues/{venueId}                    | delete a venue                        | 
|    Get      |  api/venues/search/name/{name}           | find venue by name                    | 
|    Get      |  api/venues/search/city/{city}           | find venue by city                    | 
|    Get      |  api/venues/search/state/{state}         | find venue by state                   | 

### Comedian
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  api/comedians                           | find all comedians                    |
|    Get      |  api/comedians/{comedianId}              | find comedian by Id                   |    
|    Post     |  api/comedians                           | create comedian                       |   
|    Put      |  api/comedians/{comedianId}         	 | update a comedian                     | 
|   Delete    |  api/comedians/{comedianId}              | delete a comedian                     | 
|    Get      |  api/comedians/search/name/{name}        | find comedian by name                 | 
|    Get      |  api/comedians/search/category/{category}| find comedian by category             | 

### Category
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  api/categories                          | find all categories                   |
|    Get      |  api/categories/{categoryId}             | find category by Id                   |    
|    Post     |  api/categories                          | create category                       |   
|    Put      |  api/categories/{categoryId}         	 | update a category                     | 
|   Delete    |  api/categories/{categoryId}             | delete a category                     | 


