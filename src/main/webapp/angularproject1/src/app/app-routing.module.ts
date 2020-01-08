import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ErsComponent } from './ers/ers.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'ers', component: ErsComponent },
  { path: 'login', component: LoginComponent },
  {path: '', component: AppComponent},
  {path: '**', redirectTo: 'home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
