import {Component, OnInit} from '@angular/core';
import {StudentsService} from "../../services/students.service";
import {SubjectsService} from "../../services/subjects.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subjects} from "../../models/subjects.model";
import {Students} from "../../models/students.model";
import {EnrollmentService} from "../../services/enrollment.service";
import {Sections} from "../../models/sections.model";
import {ExaminationService} from "../../services/examination.service";
import {Examination} from "../../models/examination.model";
import {Result} from "../../models/result.model";
import {ResultService} from "../../services/result.service";
import {Users} from "../../models/users.model";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit{

  isStudentsAdd=false;
  isStudentsList=false;
  isExamList=false;
  isResultList=false;


  students=new Students();

  studentsList?:Students[];

  sectionList?:Sections[];
  examinationsList?:Examination[];
  resultList?:Result[];

  isSection=false;
  studentId:any;

  users=new Users();


  constructor(private enrollmentService:EnrollmentService,private studentsService:StudentsService,private router:Router,
              private activatedRoute:ActivatedRoute, private examinationService:ExaminationService,
              private resultService:ResultService, private alertService:AlertService) {
  }

  ngOnInit(): void {
    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='students/add-students'))
    {
      this.isStudentsAdd=true;
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='students/students-list'))
    {
      this.isStudentsList=true;
      this.getAllStudentsList();
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='students/sections'))
    {
      this.isSection=true
      // this.getStudentWithSection()
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='students/examination-list'))
    {
      this.isExamList=true
      // this.getStudentWithSection()
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='students/result-list'))
    {
      this.isResultList=true
      this.getResultWithSubjectList();
    }
  }

  addStudents()
  {
    this.studentsService.saveStudents(this.students).subscribe(data=>{
      console.log(data)
      this.alertService.submitSuccessAlert();
      this.router.navigate(['students/students-list'])
    })
  }

  getAllStudentsList()
  {
    this.studentsService.getAllStudents().subscribe(data=>{
      this.studentsList=data;
      console.log(this.studentsList)
    })
  }

  getStudentWithSection()
  {
    this.studentsService.getStudentsWithSections(this.studentId).subscribe(data=>{
      console.log(data)
      this.sectionList=data;
    })
  }

  getExamList()
  {
    this.examinationService.getExam(this.studentId).subscribe(data=>{
      this.examinationsList=data;
    })
  }

  getResultWithSubjectList()
  {
    const userData=sessionStorage.getItem("userdetails")
    if(userData)
    {
      this.users=JSON.parse(userData)
    }
    this.resultService.getStudentResultWithSubjects(this.users.id).subscribe(data=>{
      this.resultList=data;
      console.log(this.resultList)
    })
  }



}
