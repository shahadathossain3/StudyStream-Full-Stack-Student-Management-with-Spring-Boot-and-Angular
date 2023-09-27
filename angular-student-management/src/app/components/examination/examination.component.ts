import {Component, OnInit} from '@angular/core';
import {ExaminationService} from "../../services/examination.service";
import {Examination} from "../../models/examination.model";
import {Subjects} from "../../models/subjects.model";
import {Classroom} from "../../models/classroom.model";
import {SubjectsService} from "../../services/subjects.service";
import {ClassroomService} from "../../services/classroom.service";
import {flip} from "@popperjs/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-examination',
  templateUrl: './examination.component.html',
  styleUrls: ['./examination.component.css']
})
export class ExaminationComponent implements OnInit{
  isAddexamination=false;
  isExam=false;

  subjectsList?:Subjects[];
  classroomList?:Classroom[];
  examination=new Examination();
  subjects=new Subjects();
  classroom=new Classroom();
  constructor(private classroomService:ClassroomService,private subjectsService:SubjectsService,
              private examinationService:ExaminationService,private router:Router,
              private activatedRoute:ActivatedRoute, private alertService:AlertService) {}
  ngOnInit(): void {


    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='examination/add-examination'))
    {
      this.isAddexamination=true;
      this.getAllClassroomList();
      this.getAllSubjectList();
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='examination/getExam'))
    {
      this.isExam=true;
    }
  }

  addExamination()
  {
    this.examination.subjects=this.subjects;
    this.examination.classroom=this.classroom;
    this.examinationService.saveExamination(this.examination).subscribe(data=>{
      this.alertService.submitSuccessAlert();
      console.log(data);
    })
  }

  getAllSubjectList()
  {
    this.subjectsService.getAllSubjects().subscribe(data=>{
      this.subjectsList=data;
    })
  }

  getAllClassroomList()
  {
    this.classroomService.getAllClassroom().subscribe(data=>{
      this.classroomList=data;
    })
  }
}
