import {Component, OnInit} from '@angular/core';
import {LoginService} from "../../services/login.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Users} from "../../models/users.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  isLoading=false;
  authStatus:string="";
  message?:string;
  cartPara?:string;
  userData:any
  unauthorized?:string;

  users=new Users();

  constructor(private loginService:LoginService, private router:Router, private activatedRoute:ActivatedRoute) {
  }

  ngOnInit(): void {
  }

  loginUser()
  {
    this.isLoading=true;
    this.loginService.loginDetails(this.users).subscribe((data:any)=>{
        console.log(data)
        if(data.status===200) {
          this.isLoading=false;
          window.sessionStorage.setItem("Authorization", data.headers.get('Authorization')!);
          this.users = <any>data.body;
          this.users.authStatus = 'AUTH';
          window.sessionStorage.setItem("userdetails", JSON.stringify(this.users));
          this.router.navigate(['dashboard']);
          // let xsrf = getCookie('XSRF-TOKEN')!;
          // window.sessionStorage.setItem("XSRF-TOKEN", xsrf);

          // this.userData = sessionStorage.getItem("userdetails")?JSON.parse(sessionStorage.getItem("userdetails")!):'';
          //
          //
          // const role = this.userData?.roles?.find((rl: { name: string; }) => rl.name === "ROLE_ADMIN")
          // if (role && role.name === "ROLE_ADMIN") {
          //   this.router.navigate((['admin-template']))
          // } else {
          //   if (this.cartPara === "cart") {
          //     this.router.navigate(['add-order-products'])
          //   } else {
          //     this.router.navigate(['list-products']);
          //   }
          // }
        }

        if(data.status===401)
        {
          this.unauthorized="email or password did not match";
        }

      },
      error => {
        this.message=error.error.message;
        console.log(this.message)
        this.isLoading=false;
      })
  }
}
