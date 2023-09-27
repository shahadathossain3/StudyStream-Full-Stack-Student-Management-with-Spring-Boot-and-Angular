import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../../services/students.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TeachersService} from "../../services/teachers.service";
import {Students} from "../../models/students.model";
import {Teachers} from "../../models/teachers.model";
import {Sections} from "../../models/sections.model";
import {SectionsService} from "../../services/sections.service";
import {Enrollment} from "../../models/enrollment.model";
import {EnrollmentService} from "../../services/enrollment.service";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-enrollment',
  templateUrl: './enrollment.component.html',
  styleUrls: ['./enrollment.component.css']
})
export class EnrollmentComponent implements OnInit{

  isStudentsEnrollment=false;
  isTeachersEnrollment=false;
  studentsList?:Students[];
  teachersList?:Teachers[];
  sectionsList?:Sections[];
  students=new Students();
  teachers=new Teachers();
  sections=new Sections();
  enrollment=new Enrollment();


  constructor(private enrollmentService:EnrollmentService,private sectionsService:SectionsService,
              private studentsService:StudentsService,private teachersService:TeachersService,
              private router:Router, private alertService:AlertService, private activatedRoute:ActivatedRoute) {
  }


  ngOnInit(): void {
    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='enrollments/add-enrollments-students'))
    {
      this.isStudentsEnrollment=true;
      this.getAllStudentsList();
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='enrollments/add-enrollments-teachers'))
    {
      this.isTeachersEnrollment=true;
      this.getAllTeachersList();
    }
    this.getAllSectionsList();
  }



  getAllStudentsList()
  {
    this.studentsService.getAllStudents().subscribe(data=>{
      this.studentsList=data;
      console.log(this.studentsList)
    })
  }


  getAllTeachersList()
  {
    this.teachersService.getAllTeachers().subscribe(data=>{
      this.teachersList=data;
      console.log(this.teachersList)
    })
  }

  getAllSectionsList()
  {
    this.sectionsService.getAllSections().subscribe(data=>{
      this.sectionsList=data;
      console.log(this.sectionsList)
    })
  }

  addEnrollment()
  {
      this.enrollment.students = this.students;
    this.enrollment.teachers=this.teachers;
    this.enrollment.sections=this.sections;
    this.enrollmentService.saveEnrollment(this.enrollment).subscribe(data=>{
      this.alertService.submitSuccessAlert();
      console.log(data);
      this.router.navigate(['dashboard'])
    })
  }

}
