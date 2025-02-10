import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Comedian } from '../models/comedian';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComedianService {

 private url = environment.baseUrl + 'api/comedians';

  constructor(private http: HttpClient,) { }

  index(): Observable<Comedian[]> {
      return this.http.get<Comedian[]>(this.url).pipe(
        catchError((error: any)=> {
          console.log(error);
          return throwError(
            () => new Error('ComedianService.index(): error loading comedianList: ' + error)
          );
        })
      );
    }


create (comedian : Comedian): Observable<Comedian> {
     return this.http.post<Comedian>(this.url, comedian).pipe(
       catchError((error:any) => {
         console.log(error);
         return throwError(
           () => new Error ('ComedianService.create(): error creating comedian' + error.message)
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


}
