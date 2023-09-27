import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Examination} from "../models/examination.model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.development";
import {Result} from "../models/result.model";
import {Students} from "../models/students.model";

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  constructor(private httpClient:HttpClient) { }

  getAllSubjectWithList(id:any):Observable<Students[]>
  {
    return this.httpClient.get<Students[]>(environment.rootUrl+'result/studentListWithSubject/'+`${id}`);
  }

  saveResult(data:Result[]):Observable<Result[]>
  {
    return this.httpClient.post<Result[]>(environment.rootUrl+'result/addResult',data);
  }

  getStudentResultWithSubjects(id:any):Observable<Result[]>
  {
    return this.httpClient.get<Result[]>(environment.rootUrl+'students/resultwithSubjects/'+`${id}`);
  }


}
