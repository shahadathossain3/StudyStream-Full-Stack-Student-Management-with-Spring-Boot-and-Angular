export class Classroom {
  id?:number;
  roomNumber?:string;


  constructor(id?: number, roomNumber?: string) {
    this.id = id;
    this.roomNumber = roomNumber;
  }
}
