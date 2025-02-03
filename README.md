# EventTrackerProject

## Overview
This is a JPA project that will develop to be a site to track comedy shows with full CRUD funcationality, where a user will be able to read/search, add, update and delete comedians, venues, categories and comedy shows. At this current point, the backend has been flushed out and the next step is to complete the frontend. The followings show the REST API routs and their functions.

## API Routes

### Comedy Event
| HTTP Method |               Endpoint             		 | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  `/api/comedyEvents`                       | Find all comedy events                |
|    Get      |  `/api/comedyEvents/{comedyEventId}`        | Find comedy event by Id               |    
|    Post     |  `/api/comedyEvents`                       | Create comedy event                   |   
|    Put      |  `/api/comedyEvents/{comedyEventId}`       | Update a comedy event                 | 
|   Delete    |  `/api/comedyEvents/{comedyEventId}`      | Delete a comedy event                 | 
|    Get      |  `/api/comedyEvents/search/comedian/{name}` | Find comedy events by comedian name   | 
|    Get      |  `/api/comedyEvents/search/rating/{rating}` | Find comedy events by rating          | 
|    Get      |  `/api/comedyEvents/search/venue/{venue}`  | Find comedy events by venue           | 

### Venue
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  `/api/venues`                             | Find all venues                       |
|    Get      |  `/api/venues/{venueId}`                    | Find veneus by Id                     |    
|    Post     |  `/api/venues`                           | Create venue                          |   
|    Put      |  `/api/venues/{venueId}`                  	 | Update a venue                        | 
|   Delete    |  `/api/venues/{venueId}`                    | Delete a venue                        | 
|    Get      |  `/api/venues/search/name/{name}`           | Find venue by name                    | 
|    Get      |  `/api/venues/search/city/{city}`          | Find venue by city                    | 
|    Get      |  `/api/venues/search/state/{state}`         | Find venue by state                   | 

### Comedian
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  `/api/comedians`                           | Find all comedians                    |
|    Get      |  `/api/comedians/{comedianId}`              | Find comedian by Id                   |    
|    Post     |  `/api/comedians`                          | Create comedian                       |   
|    Put      |  `/api/comedians/{comedianId}`        	 | Update a comedian                     | 
|   Delete    |  `/api/comedians/{comedianId}`              | Delete a comedian                     | 
|    Get      |  `/api/comedians/search/name/{name}`        | Find comedian by name                 | 
|    Get      |  `/api/comedians/search/category/{category}`| Find comedian by category             | 

### Category
| HTTP Method |               Endpoint                   | Description                           |
|-------------|------------------------------------------|---------------------------------------|
|    Get      |  `/api/categories`                          | Find all categories                   |
|    Get      |  `/api/categories/{categoryId}`             | Find category by Id                   |    
|    Post     |  `/api/categories`                          | Create category                       |   
|    Put      |  `/api/categories/{categoryId}`         	 | Update a category                     | 
|   Delete    |  `/api/categories/{categoryId}`             | Delete a category                     | 


## Technologies Used for REST API

* Spring Tool Suite
* Spring Boot
* Spring Data JPA
* REST Controller
* MySQL Workbench
* Java
* Postman


## Lessons Learned
This was my first opportuntity to build out a schema in MySQL workbench with multiple tables and I felt like I learned from last week's project of thinking out the relationships prior to creating the diagram. I felt pretty comfortable with the relationship mapping and running the JUnit tests for them. I found the JPA repository CRUD methods to be super helpful and easy to implement. I enjoyed learning about the HTTP response codes in my controllers when mapping the REST routes and found some small hurdles to overcome with ambigous mapping when using Postman and noticing I had the same URLs for a couple methods. My favorite part was creating different queries and testing them in Postman, as well as JUnit testing. Although there were multiple opportunities to copy and paste logic in methods, I really tried to type everything out to get more reps and practice vs replying on previous examples. I still need to review and fully understand the concepts and terms in this chapter, as I am not very comfortable attempting to explain it. I also wasn't able to deploy to AWS which is another portion of the project that I don't feel confident in and need more practice/understanding of the commands in the terminal.


## Technologies Used for JavaScript/HTML/AJAX

* JavaScript
* HTML
* CSS
* XMLHttpRequests
* DOM Manipulation

## Lessons Learned
Empty Cache and Hard Reload...I was spinning my wheels for a while before realizing that this was the solution to a simple problem, so I definitely learned that lesson! I had to do some research to figure out how to kill the application that was running on my 8083 port since my computer crashed and I was no longer able to open my application. I'm pretty frustrated that I wasn't able to do more for this project. I really struggled attempting to iterating through my comedians, category and venue objects to include them as options in a dropdown lists and ended up having to hard code the data in which isn't what I wanted. I was able to generated the dropdowns pretty easily but I wasn't able to figure out how to attached the ids(foreign keys in the comedyEvent table). I felt like I was pretty familiar with the relationship and I felt so close to figuring it out but ultimately ended up spending way too much time attempting to do that. I originally wanted the option to add a new comedian and venue (which would later populate in the dropdown list) when creading a new comedy event. I also started to get lost and overwhelmed with using one javascript file for all my operations and having to hide certain portions of the html file, which I believe comes with more practice and moving away from using JSPs. 
