import {Sections} from "./sections.model";
import {Users} from "./users.model";

export class Students extends Users{
  override id?:number;
  firstName?:string;
  lastName?:string;
  fatherName?:string;
  motherName?:string;
  studentID?:string;
  // password?:string;
  dateOfBirth?:Date;
  gender?:string;
  address?:string;
  phone?:string;
  dateOfJoin?:Date;
  sections?:Sections[];


  constructor(id?: number, firstName?: string, lastName?: string, fatherName?: string, motherName?: string, studentID?: string, password?: string, dateOfBirth?: Date, gender?: string, address?: string, phone?: string, dateOfJoin?: Date) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.fatherName = fatherName;
    this.motherName = motherName;
    this.studentID = studentID;
    // this.password = password;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.address = address;
    this.phone = phone;
    this.dateOfJoin = dateOfJoin;
  }
}
