import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Examination} from "../models/examination.model";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private httpClient:HttpClient) { }

  saveExamination(data:Examination):Observable<Examination>
  {
    return this.httpClient.post<Examination>(environment.rootUrl+'examination/addExamination',data);
  }

  getExam(id:any):Observable<Examination[]>
  {
    return this.httpClient.get<Examination[]>(environment.rootUrl+'students/getExamination/'+`${id}`);
  }

  getAllExam():Observable<Examination[]>
  {
    return this.httpClient.get<Examination[]>(environment.rootUrl+'examination/examList');
  }
}
