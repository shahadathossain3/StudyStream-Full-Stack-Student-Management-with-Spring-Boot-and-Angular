import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Subjects} from "../models/subjects.model";
import {environment} from "../../environments/environment.development";
import {Sections} from "../models/sections.model";
import {WeekDay} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class SectionsService {

  constructor(private httpClient:HttpClient) { }

  getAllSections():Observable<Sections[]>
  {
    return this.httpClient.get<Sections[]>(environment.rootUrl+'sections/getAllSectionsList');
  }

  getAllDayOfWeek():Observable<String[]>
  {
    return this.httpClient.get<String[]>(environment.rootUrl+'sections/dayOfWeek');
  }

  saveSections(data:Sections):Observable<Sections>
  {
    // return environment.rootUrl
    return this.httpClient.post<Sections>(environment.rootUrl+'sections/addSection',data);
  }


}
