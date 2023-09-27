import {Component, OnInit} from '@angular/core';
import {ClassroomService} from "../../services/classroom.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit{
  role?:string;
  isStudent=false;
  isAdmin=false;
  isTeacher=false;

  constructor(private classroomService:ClassroomService) {}

  ngOnInit(): void {
    const userdata=sessionStorage.getItem("userdetails")
    if(userdata) {
      const userdetails = JSON.parse(userdata)
        for (let usr of userdetails.roles) {
          this.role=usr.name;
        }
    }

    if(this.role==='ROLE_STUDENT')
    {
      this.isStudent=true;
      this.getStudentRoleAccessData();
    }
    if(this.role==='ROLE_TEACHER')
    {
      this.isTeacher=true;
      this.getTeacherRoleAccessData();
    }
    if(this.role==='ROLE_ADMIN')
    {
      this.isAdmin=true;
      this.getAdminRoleAccessData();
    }
  }

  getStudentRoleAccessData()
  {

  }

  getTeacherRoleAccessData()
  {

  }

  getAdminRoleAccessData()
  {

  }
}
