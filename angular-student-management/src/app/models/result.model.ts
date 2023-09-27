import {Students} from "./students.model";
import {Teachers} from "./teachers.model";
import {Subjects} from "./subjects.model";
import {Examination} from "./examination.model";

export class Result {
  id?: number;
  marks?: number;
  comment?: string;
  examination?: Examination;
  subjects?: Subjects;
  students?: Students;
  teachers?: Teachers;


  constructor(id?: number, marks?: number, comment?: string, examination?: Examination, subjects?: Subjects, students?: Students, teachers?: Teachers) {
    this.id = id;
    this.marks = marks;
    this.comment = comment;
    this.examination = examination;
    this.subjects = subjects;
    this.students = students;
    this.teachers = teachers;
  }
}
