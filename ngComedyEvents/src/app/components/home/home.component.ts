import { Component, OnInit } from '@angular/core';
import { ComedyEventService } from '../../services/comedy-event.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ComedyEvent } from '../../models/comedy-event';
import { Comedian } from '../../models/comedian';
import { Venue } from '../../models/venue';
import { ComedianService } from '../../services/comedian.service';
import { VenueService } from '../../services/venue.service';

@Component({
  selector: 'app-home',
    //Add any pipes in imports
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  comedyEvents: ComedyEvent [] = [];
  selectedEvent: ComedyEvent | null = null;
  newEvent: ComedyEvent = new ComedyEvent();

  comedians: Comedian [] = [];
  newComedian: Comedian = new Comedian();

  venues: Venue [] = [];
  newVenue: Venue = new Venue();

  constructor(private comedyEventService :ComedyEventService,
    private comedianService :ComedianService,
    private venueService :VenueService,
  ) {

  }

  ngOnInit(): void {
    this.loadEvents();
    this.loadComedians();
    this.loadVenues();
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


}
