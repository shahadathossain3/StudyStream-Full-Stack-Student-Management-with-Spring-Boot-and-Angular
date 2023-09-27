import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {Users} from "../../models/users.model";

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {

  users=new Users();

  constructor(private router:Router) {
  }

  ngOnInit(): void {
    window.sessionStorage.removeItem("userdetails");
    window.sessionStorage.removeItem("XSRF-TOKEN");
    window.sessionStorage.removeItem("Authorization");
    this.router.navigate(['home'])
  }

}
