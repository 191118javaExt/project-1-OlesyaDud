import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ers',
  templateUrl: './ers.component.html',
  styleUrls: ['./ers.component.scss']
})
export class ErsComponent implements OnInit {


  currentUser: User;
  constructor(private us: UserService, private router: Router) { }

  ngOnInit() {
    let userString: string = sessionStorage.getItem('currentUser');
    if(userString === null) {
      this.router.navigate(['/login']);
    } else {
      this.currentUser = JSON.parse(userString);
    }
  }

  logout() {
    this.us.logout();
    sessionStorage.removeItem('currentUser');
    this.router.navigate(['/login']);
  }

}
