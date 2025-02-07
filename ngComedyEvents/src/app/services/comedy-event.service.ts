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

  constructor(
    private http: HttpClient,
  ) { }

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



}
