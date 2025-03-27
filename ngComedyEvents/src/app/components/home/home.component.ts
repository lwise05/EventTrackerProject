import { NgbCarouselCtx, ngbCarouselTransitionIn, ngbCarouselTransitionOut } from './../../../../node_modules/@ng-bootstrap/ng-bootstrap/carousel/carousel-transition.d';
import { CategoryService } from './../../services/category.service';
import { Component, OnInit } from '@angular/core';
import { ComedyEventService } from '../../services/comedy-event.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ComedyEvent } from '../../models/comedy-event';
import { Comedian } from '../../models/comedian';
import { Venue } from '../../models/venue';
import { ComedianService } from '../../services/comedian.service';
import { VenueService } from '../../services/venue.service';
import { Category } from '../../models/category';

@Component({
  selector: 'app-home',
    //Add any pipes in imports
  imports: [CommonModule, FormsModule,],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',

})
export class HomeComponent implements OnInit{

  comedyEvents: ComedyEvent [] = [];
  selectedEvent: ComedyEvent | null = null;
  newEvent: ComedyEvent = new ComedyEvent();
  editEvent: ComedyEvent | null = null //To clear edit form
  showNewEventForm: any;

  comedians: Comedian [] = [];
  newComedian: Comedian = new Comedian();
  selectedComedian: Comedian | null = null;
  showNewComedianForm: any;

  venues: Venue [] = [];
  newVenue: Venue = new Venue();
  selectedVenue: Venue | null = null;
  showNewVenueForm: any;

  categories: Category [] = [];


  constructor(private comedyEventService :ComedyEventService,
    private comedianService :ComedianService,
    private venueService :VenueService,
    private categoryService :CategoryService,

  ) {

  }

  ngOnInit(): void {
    this.loadEvents();
    this.loadComedians();
    this.loadVenues();
    this.loadCategories()
   }


// EVENTS
  loadEvents(): void {
    this.comedyEventService.index().subscribe({
      next: (eventList) => {
        this.comedyEvents = eventList;
      },
      error: (failure) => {
        console.error('HomeComponenet.loadEvents:fail to load comedyEvent list');
        console.error(failure);
      }
    });
    }

  displayEvent(event: ComedyEvent) {
      this.selectedEvent = event;
    }

  displayTable() {
      this.selectedEvent = null;
      this.selectedComedian = null;
      this.selectedVenue = null;
    }

  createEvent(comedyEvent : ComedyEvent){
    this.comedyEventService.create(comedyEvent).subscribe({
      next: (newComedyEvent) => {
        this.loadEvents();
        this.newEvent = new ComedyEvent();
      },
      error: (failure) => {
        console.error('HomeComponenet.createEvent:fail to create new comedyEvent');
        console.error(failure);
      }
    });
  }

  toggleNewEvent(){
    this.showNewEventForm = true;
  }

  cancelNewEvent(){
    this.showNewEventForm = false;
  }

deleteEvent(id : number){
this.comedyEventService.destroy(id).subscribe({
  next:(eventToDelete) => {
    this.loadEvents();
  },
  error:(failure) => {
    console.error('HomeComponenet.deleteEvent:fail to delete comedyEvent');
    console.error(failure);
  }
});
}

updateEvent(comedyEvent : ComedyEvent): void {
  console.log(comedyEvent);
  this.comedyEventService.update(comedyEvent).subscribe({
    next: (eventToUpdate) => {
      console.log(eventToUpdate);
      this.loadEvents();
      this.selectedEvent = eventToUpdate;
      this.editEvent = null;
    },
    error: (failure) => {
      console.error('HomeComponenet.updateEvent:fail to update comedyEvent');
      console.error(failure);
    }
  });
  }

setEditEvent(editEvent : ComedyEvent){
  this.editEvent = Object.assign({}, this.selectedEvent);
}


//COMEDIANS
loadComedians(): void {
  this.comedianService.index().subscribe({
    next: (comedianList) => {
      this.comedians = comedianList;
    },
    error: (failure) => {
      console.error('HomeComponenet.loadComedians:fail to load comedian list');
      console.error(failure);
    }
  });
  }

  displayComedian(comedian: Comedian) {
    this.selectedComedian = comedian;
  }

  createComedian(comedian : Comedian){
    this.comedianService.create(comedian).subscribe({
      next: (newComedian) => {
        this.loadEvents();
        alert("Comedian added to list")
        this.loadComedians();
        this.newComedian = new Comedian();
      },
      error: (failure) => {
        console.error('HomeComponenet.createComedian:fail to create new comedian');
        console.error(failure);
      }
    });
  }

  toggleNewComedian(){
    this.showNewComedianForm = true;
  }

  cancelNewComeidan() {
    this.showNewComedianForm = false;
  }

  deleteComedian(id : number){
    this.comedianService.destroy(id).subscribe({
      next:(comedianToDelete) => {
        this.loadEvents();
        this.loadComedians();
      },
      error:(failure) => {
        console.error('HomeComponenet.deleteComedian:fail to delete comedian');
        console.error(failure);
      }
    });
    }


//VENUES
loadVenues(): void {
  this.venueService.index().subscribe({
    next: (venueList) => {
      this.venues = venueList;
    },
    error: (failure) => {
      console.error('HomeComponenet.loadVenues:fail to load venue list');
      console.error(failure);
    }
  });
  }

  displayVenue(venue: Venue) {
    this.selectedVenue = venue;
  }

  toggleNewVenue(){
    this.showNewVenueForm = true;
  }
  cancelNewVenue() {
    this.showNewVenueForm = false;
  }

  createVenue(venue : Venue){
    this.venueService.create(venue).subscribe({
      next: (newVenue) => {
        this.loadEvents();
        alert("Venue added to list")
        this.loadComedians();
        this.loadVenues();
        this.newVenue = new Venue();
      },
      error: (failure) => {
        console.error('HomeComponenet.createVenue:fail to create new venue');
        console.error(failure);
      }
    });
  }

//CATEGORIES
loadCategories(): void {
  this.categoryService.index().subscribe({
    next: (categoryList) => {
      this.categories = categoryList;
    },
    error: (failure) => {
      console.error('HomeComponenet.loadCategories:fail to load category list');
      console.error(failure);
    }
  });
  }





}
