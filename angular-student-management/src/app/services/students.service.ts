import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Subjects} from "../models/subjects.model";
import {environment} from "../../environments/environment.development";
import {Students} from "../models/students.model";
import {Sections} from "../models/sections.model";

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private httpClient:HttpClient) { }

  getAllStudents():Observable<Students[]>
  {
    return this.httpClient.get<Students[]>(environment.rootUrl+'students/getAllStudentsList');
  }

  saveStudents(data:Students):Observable<Students>
  {
    return this.httpClient.post<Students>(environment.rootUrl+'students/addStudents',data);
  }

  getStudentsWithSections(id:any):Observable<Sections[]>
  {
    return this.httpClient.get<Sections[]>(environment.rootUrl+'students/getSectionWithClassroomSubject/'+`${id}`);
  }
}
