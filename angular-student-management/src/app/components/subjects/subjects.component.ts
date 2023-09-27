import {Component, OnInit} from '@angular/core';
import {Classroom} from "../../models/classroom.model";
import {ClassroomService} from "../../services/classroom.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subjects} from "../../models/subjects.model";
import {SubjectsService} from "../../services/subjects.service";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: ['./subjects.component.css']
})
export class SubjectsComponent implements OnInit{
  isSubjectsAdd=false;
  isSubjectsList=false;

  subjects=new Subjects();

  subjectsList?:Subjects[];

  constructor(private subjectsService:SubjectsService,private router:Router,
              private activatedRoute:ActivatedRoute, private alertService:AlertService) {
  }

  ngOnInit(): void {
    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='subjects/add-subjects'))
    {
      this.isSubjectsAdd=true;
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='subjects/subjects-list'))
    {
      this.isSubjectsList=true;
      this.getAllSubjectList();
    }
  }

  addSubjects()
  {
    this.subjectsService.saveClassroom(this.subjects).subscribe(data=>{
      console.log(data)
      this.alertService.submitSuccessAlert();
      this.router.navigate(['subjects/subjects-list'])
    })
  }

  getAllSubjectList()
  {
    this.subjectsService.getAllSubjects().subscribe(data=>{
      this.subjectsList=data;
    })
  }
}
