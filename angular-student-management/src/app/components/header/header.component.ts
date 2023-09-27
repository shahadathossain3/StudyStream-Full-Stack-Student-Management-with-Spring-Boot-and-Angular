import { Component } from '@angular/core';
import {Users} from "../../models/users.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  users=new Users();
  keyword:any;
  cartQuantity:any

  constructor(private router:Router) {
  }

  ngOnInit(): void {

    this.cartItemsList()
  }

  cartItemsList()
  {
    if(sessionStorage.getItem('userdetails'))
    {
      this.users=JSON.parse(sessionStorage.getItem('userdetails')!);
    }
  }

}
