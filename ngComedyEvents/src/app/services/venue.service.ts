import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';
import { Comedian } from '../models/comedian';
import { Venue } from '../models/venue';

@Injectable({
  providedIn: 'root'
})
export class VenueService {

 private url = environment.baseUrl + 'api/venues';

 constructor(private http: HttpClient,) { }

  index(): Observable<Venue[]> {
      return this.http.get<Venue[]>(this.url).pipe(
        catchError((error: any)=> {
          console.log(error);
          return throwError(
            () => new Error('VenueService.index(): error loading venueList: ' + error)
          );
        })
      );
    }


     create (venue : Venue): Observable<Venue> {
    
         return this.http.post<Venue>(this.url, venue).pipe(
           catchError((error:any) => {
             console.log(error);
             return throwError(
               () => new Error ('VenueService.create(): error creating venue' + error.message)
             );
           })
         );
       }

}
