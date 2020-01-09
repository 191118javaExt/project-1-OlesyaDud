import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<User> {
    let body: any =
    {
      username: username,
      password: password
    };

    return this.http.post<User>("http://localhost:8080/project-1/main?type=login",body);
  }

  logout() {
    return this.http.post<void>("http://localhost:8080/project-1/main?type=logout", {});
  }

  getReimb(id:number): Observable<any> {
    return this.http.get<any>("http://localhost:8080/project-1/main?type=getreimb&id=" + id, {});
  }

}
