import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { UsersModel } from '../model/users.model';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  
  private serverString:String;

  constructor(private http: HttpClient) { 
    this.serverString = "http://localhost:8080";
  }

  public getAll() {
    return this.http.get<UsersModel[]>(this.serverString + "/getUsers");
  }

  public getById() {
    return this.http.get<UsersModel>(this.serverString + "/getUser");
  }

  public update(user: UsersModel) {
    //return this.http.put(this.serverString + user.id, user);
  }

  public delete(id: number) {
    return this.http.delete(this.serverString + "/users" + id);
  }

  public createUser(id: number) {
    return this.http.delete(this.serverString + "/users" + id);
  }
}
