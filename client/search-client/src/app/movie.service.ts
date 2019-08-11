import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

const endpoint = 'http://localhost:7111/ws-search/v1/movies';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) {
  }

  getMovies(): Observable<any> {
    return this.http.get(endpoint).pipe(
      map(this.extractData)
    );
  }

  private extractData(res: Response) {
    return res || {};
  }
}
