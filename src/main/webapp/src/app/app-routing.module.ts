import { AppComponent } from './app.component';
import { RouterModule, Routes} from '@angular/router'
import { NgModule, Component } from '@angular/core';
import { LoginComponent } from '../app/login/login.component';
import {AddUserComponent} from "./add-user/add-user.component";
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './guards/auth.guard';

const appRoutes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);