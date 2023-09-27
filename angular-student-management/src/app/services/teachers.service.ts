import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Students} from "../models/students.model";
import {environment} from "../../environments/environment.development";
import {Teachers} from "../models/teachers.model";
import {Sections} from "../models/sections.model";

@Injectable({
  providedIn: 'root'
})
export class TeachersService {

  constructor(private httpClient:HttpClient) { }

  getAllTeachers():Observable<Teachers[]>
  {
    return this.httpClient.get<Teachers[]>(environment.rootUrl+'teachers/getTeachersList');
  }

  saveTeachers(data:Teachers):Observable<Teachers>
  {
    return this.httpClient.post<Teachers>(environment.rootUrl+'teachers/addTeachers',data);
  }

  getTeachersWithSections(id:any):Observable<Sections[]>
  {
    return this.httpClient.get<Sections[]>(environment.rootUrl+'teachers/getSectionWithClassroomSubject/'+`${id}`);
  }
}
