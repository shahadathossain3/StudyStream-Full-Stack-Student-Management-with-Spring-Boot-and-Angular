import {Time} from "@angular/common";
import {Subjects} from "./subjects.model";
import {Classroom} from "./classroom.model";

export class Examination {
  id?: number;
  name?: string;
  type?: string;
  date?: Date;
  time?: Time;
  subjects?: Subjects;
  classroom?:Classroom;


  constructor(id?: number, name?: string, type?: string, date?: Date, time?: Time, subjects?: Subjects, classroom?: Classroom) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.date = date;
    this.time = time;
    this.subjects = subjects;
    this.classroom = classroom;
  }
}
