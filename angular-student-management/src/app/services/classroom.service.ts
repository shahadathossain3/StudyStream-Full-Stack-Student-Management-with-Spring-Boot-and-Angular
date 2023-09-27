import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Classroom} from "../models/classroom.model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class ClassroomService {

  constructor(private httpClient:HttpClient) { }

  getAllClassroom():Observable<Classroom[]>
  {
    return this.httpClient.get<Classroom[]>(environment.rootUrl+'classroom/getClassroomList');
  }

  saveClassroom(data:Classroom):Observable<Classroom>
  {
    // return environment.rootUrl
    return this.httpClient.post<Classroom>(environment.rootUrl+'classroom/addClassroom',data);
  }
}
