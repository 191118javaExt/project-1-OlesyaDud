import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ErsComponent } from './ers/ers.component';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'ers', component: ErsComponent },
  { path: '', component: LoginComponent },
  { path: '**', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
