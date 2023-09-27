import {Students} from "./students.model";
import {Teachers} from "./teachers.model";
import {Sections} from "./sections.model";

export class Enrollment {
  id?: number;
  students?: Students;
  teachers?: Teachers;
  sections?: Sections;
}
