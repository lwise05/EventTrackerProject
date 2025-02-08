import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { ComedyEvent } from '../models/comedy-event';

@Injectable({
  providedIn: 'root'
})
export class ComedyEventService {

  private url = environment.baseUrl + 'api/comedyEvents';

  constructor(private http: HttpClient,) { }

  index(): Observable<ComedyEvent[]> {
    return this.http.get<ComedyEvent[]>(this.url).pipe(
      catchError((error: any)=> {
        console.log(error);
        return throwError(
          () => new Error('ComedyEventService.index(): error loading comedyEventList: ' + error)
        );
      })
    );
  }

  create (comedyEvent : ComedyEvent): Observable<ComedyEvent> {

     return this.http.post<ComedyEvent>(this.url, comedyEvent).pipe(
       catchError((error:any) => {
         console.log(error);
         return throwError(
           () => new Error ('ComedyEventService.create(): error creating comedyEvent' + error.message)
         );
       })
     );
   }

   destroy(id : number): Observable<void>{
    return this.http.delete<void>(this.url +'/' + id).pipe(
      catchError((error:any) => {
        console.log(error);
        return throwError(
          () => new Error ('ComedyEventService.destroy(): error deleting comedyEvent' + error.message)
        );
      })
    );
  }

  update(comedyEvent: ComedyEvent): Observable<ComedyEvent> {
      return this.http.put<ComedyEvent>(this.url +'/' + comedyEvent.id, comedyEvent).pipe(
        catchError((error:any) => {
          console.log(error);
          return throwError(
            () => new Error ('ComedyEventService.update(): error updating comedyEvent' + error.message)
          );
        })
      );
    }


}
