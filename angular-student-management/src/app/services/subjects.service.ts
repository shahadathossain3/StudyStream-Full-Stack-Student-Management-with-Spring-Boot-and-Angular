import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Classroom} from "../models/classroom.model";
import {environment} from "../../environments/environment.development";
import {Subjects} from "../models/subjects.model";

@Injectable({
  providedIn: 'root'
})
export class SubjectsService {

  constructor(private httpClient:HttpClient) { }

  getAllSubjects():Observable<Subjects[]>
  {
    return this.httpClient.get<Subjects[]>(environment.rootUrl+'subjects/getAllSubjectList');
  }

  saveClassroom(data:Subjects):Observable<Subjects>
  {
    // return environment.rootUrl
    return this.httpClient.post<Subjects>(environment.rootUrl+'subjects/addSubjects',data);
  }
}
