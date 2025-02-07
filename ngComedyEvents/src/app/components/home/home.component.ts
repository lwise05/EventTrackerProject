import { Component, OnInit } from '@angular/core';
import { ComedyEventService } from '../../services/comedy-event.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ComedyEvent } from '../../models/comedy-event';

@Component({
  selector: 'app-home',
    //Add any pipes in imports
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  comedyEvents: ComedyEvent [] = [];

  constructor(private comedyEventService :ComedyEventService) {

  }

  ngOnInit(): void {
    this.load();
   }

  load(): void {
    this.comedyEventService.index().subscribe({
      next: (eventList) => {
        this.comedyEvents = eventList;
      },
      error: (failure) => {
        console.error('HomeComponenet.load:fail to load comedyEvent list');
        console.error(failure);
      }
    });
    }


}
