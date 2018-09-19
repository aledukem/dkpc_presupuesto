import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
 
import { UsersModel } from '../model/users.model';
import { UsersService } from '../service/users.service';
 
@Component({templateUrl: 'home.component.html'})
export class HomeComponent implements OnInit {
    currentUser: UsersModel;
    users: UsersModel[] = [];
 
    constructor(private userService: UsersService) {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }
 
    ngOnInit() {
        this.loadAllUsers();
    }
 
    private deleteUser(id: number) {
        this.userService.delete(id).pipe(first()).subscribe(() => { 
            this.loadAllUsers() 
        });
    }
 
    private loadAllUsers() {
        this.userService.getAll().pipe(first()).subscribe(users => { 
            this.users = users; 
        });
    }
}
