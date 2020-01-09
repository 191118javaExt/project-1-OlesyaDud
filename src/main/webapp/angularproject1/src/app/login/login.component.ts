import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';
  constructor(private us: UserService, private router: Router) { }

  ngOnInit() {
  }
  sendLogin() {
    this.us.login(this.username, this.password).subscribe(
      (response: User) => {
        sessionStorage.setItem('currentUser', JSON.stringify(response));
        console.log(response);
        this.router.navigate(['/ers']);
      }
    )
  }
}
