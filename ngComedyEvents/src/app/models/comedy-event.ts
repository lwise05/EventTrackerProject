import { Comedian } from "./comedian";

export class ComedyEvent {
id: number;
performanceDate: string;
rating: number;
ticketPrice: number;
notes: string;
comedian: Comedian;

constructor(
  id: number = 0,
performanceDate: string = '',
rating: number = 0,
ticketPrice: number = 0,
notes: string = '',
comedian: Comedian =  new Comedian()

){
  this.id = id;
  this.performanceDate = performanceDate;
  this.rating = rating;
  this.ticketPrice = ticketPrice;
  this.notes = notes;
  this.comedian = comedian;
}

}
