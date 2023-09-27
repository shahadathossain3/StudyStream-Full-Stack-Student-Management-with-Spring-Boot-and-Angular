import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient:HttpClient) { }

  loginDetails(user:any):Observable<any>
  {
    window.sessionStorage.setItem("userdetails",JSON.stringify(user))

    return this.httpClient.get<any>(environment.rootUrl+'user/login', {observe: 'response', withCredentials:true});
  }
}
