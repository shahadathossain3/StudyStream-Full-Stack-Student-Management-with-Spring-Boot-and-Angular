import {Component, OnInit} from '@angular/core';
import {ClassroomService} from "../../services/classroom.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Classroom} from "../../models/classroom.model";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-classroom',
  templateUrl: './classroom.component.html',
  styleUrls: ['./classroom.component.css']
})
export class ClassroomComponent implements OnInit{

  isClassroomAdd=false;
  isClassroomList=false;
  classroom=new Classroom();

  classroomList?:Classroom[];

  constructor(private classroomService:ClassroomService,
              private alertService:AlertService,private router:Router, private activatedRoute:ActivatedRoute) {
  }

  ngOnInit(): void {
        if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='classroom/add-classroom'))
        {
          this.isClassroomAdd=true;
        }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='classroom/classroom-list'))
    {
      this.isClassroomList=true;
      this.getAllClassroomList();
    }
    }

  addClassroom()
  {
    this.classroomService.saveClassroom(this.classroom).subscribe(data=>{
      this.alertService.submitSuccessAlert();
      this.router.navigate(['classroom/classroom-list']);

    })
  }

  getAllClassroomList()
  {
    this.classroomService.getAllClassroom().subscribe(data=>{
      this.classroomList=data;
    })
  }

}
