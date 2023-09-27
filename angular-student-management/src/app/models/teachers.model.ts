export class Teachers {
  id?:number;
  firstName?:string;
  lastName?:string;
  fatherName?:string;
  motherName?:string;
  teacherID?:string;
  password?:string;
  dateOfBirth?:Date;
  gender?:string;
  address?:string;
  phone?:string;
  dateOfJoin?:Date;


  constructor(id?: number, firstName?: string, lastName?: string, fatherName?: string, motherName?: string, teacherID?: string, password?: string, dateOfBirth?: Date, gender?: string, address?: string, phone?: string, dateOfJoin?: Date) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.fatherName = fatherName;
    this.motherName = motherName;
    this.teacherID = teacherID;
    this.password = password;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.address = address;
    this.phone = phone;
    this.dateOfJoin = dateOfJoin;
  }
}
