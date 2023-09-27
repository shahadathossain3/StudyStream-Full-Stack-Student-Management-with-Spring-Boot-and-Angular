import {Component, OnInit} from '@angular/core';
import {ClassroomService} from "../../services/classroom.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Students} from "../../models/students.model";
import {Subjects} from "../../models/subjects.model";
import {Examination} from "../../models/examination.model";
import {SubjectsService} from "../../services/subjects.service";
import {StudentsService} from "../../services/students.service";
import {ExaminationService} from "../../services/examination.service";
import {Result} from "../../models/result.model";
import {Teachers} from "../../models/teachers.model";
import {ResultService} from "../../services/result.service";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit{

  studentsList?:Students[];
  subjectsList?:Subjects[];
  examList?:Examination[];
  resultList?:Result[];
  result=new Result();
  student=new Students();
  examination=new Examination();
  subjects=new Subjects();
  teachers=new Teachers();


  constructor(private classroomService:ClassroomService,private router:Router, private resultService:ResultService,
              private activatedRoute:ActivatedRoute, private subjectsService:SubjectsService, private studentsService: StudentsService,
              private examinationService:ExaminationService, private alertService:AlertService) {
  }

  ngOnInit(): void {
    this.getAllExamList();
    this.getAllSubjectList();
    // this.getAllStudentsListWithSubjects();
  }


  getAllSubjectList()
  {
    this.subjectsService.getAllSubjects().subscribe(data=>{
      this.subjectsList=data;
    })
  }

  getAllStudentsListWithSubjects(id: any) {
    this.resultService.getAllSubjectWithList(id).subscribe((data: any) => {
      this.studentsList = data;
      this.resultList = [];

      if(this.studentsList) {
        for (const student of this.studentsList) {
          const result = {
            students: student,
            examination: this.examination,
            teachers: this.teachers,
            subjects: this.subjects
          };
          this.resultList.push(result);
        }
      }

      console.log(this.resultList);
    });
  }


  // getAllStudentsListWithSubjects(id:any)
  // {
  //   this.resultService.getAllSubjectWithList(id).subscribe(data=>{
  //     this.studentsList=data;
  //     for (this.student of this.studentsList) {
  //       this.result.students=this.student;
  //       this.result.examination=this.examination;
  //       this.result.teachers=this.teachers;
  //       this.result.subjects=this.subjects;
  //       this.resultList?.push(this.result);
  //     }
  //     console.log(this.resultList);
  //   })
  // }

  getAllExamList()
  {
    this.examinationService.getAllExam().subscribe(data=>{
      this.examList=data;
    })
  }

  selectedSubject()
  {
    if(this.subjects)
    {
      this.getAllStudentsListWithSubjects(this.subjects.id);
    }
  }

  addResult()
  {
    if(this.resultList) {
      this.resultService.saveResult(this.resultList).subscribe(data => {
        this.alertService.submitSuccessAlert();
        console.log(data);
      })
    }
  }



}
