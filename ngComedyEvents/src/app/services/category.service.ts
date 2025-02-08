import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Category } from '../models/category';
import { Observable, catchError, throwError } from 'rxjs';
import { Comedian } from '../models/comedian';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

 private url = environment.baseUrl + 'api/categories';

   constructor(private http: HttpClient,) { }

index(): Observable<Category[]> {
      return this.http.get<Category[]>(this.url).pipe(
        catchError((error: any)=> {
          console.log(error);
          return throwError(
            () => new Error('CategortService.index(): error loading categoryList: ' + error)
          );
        })
      );
    }



}
