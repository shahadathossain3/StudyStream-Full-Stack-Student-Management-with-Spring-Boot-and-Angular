import {Time, WeekDay} from "@angular/common";
import {Subjects} from "./subjects.model";
import {Classroom} from "./classroom.model";

export class Sections {
  id?:number;
  day?:WeekDay;
  time?:Time;
  name?:string;
  subjects?:Subjects;
  classroom?:Classroom;


  constructor(id?: number, day?: WeekDay, time?: Time, name?: string, subjects?: Subjects, classroom?: Classroom) {
    this.id = id;
    this.day = day;
    this.time = time;
    this.name = name;
    this.subjects = subjects;
    this.classroom = classroom;
  }
}
