import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.development";
import {Enrollment} from "../models/enrollment.model";

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  constructor(private httpClient:HttpClient) { }

  saveEnrollment(data:Enrollment):Observable<Enrollment>
  {
    return this.httpClient.post<Enrollment>(environment.rootUrl+'enrollment/addEnrollment',data);
  }
}
