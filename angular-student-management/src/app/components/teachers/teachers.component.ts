import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Teachers} from "../../models/teachers.model";
import {TeachersService} from "../../services/teachers.service";
import {Sections} from "../../models/sections.model";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent {
  isTeachersAdd=false;
  isTeachersList=false;

  teachers=new Teachers();

  teachersList?:Teachers[];

  isSection=false;
  teachersId:any;
  sectionList?:Sections[];


  constructor(private teachersService:TeachersService,private router:Router,
              private activatedRoute:ActivatedRoute, private alertService:AlertService) {
  }

  ngOnInit(): void {
    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='teachers/add-teachers'))
    {
      this.isTeachersAdd=true;
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='teachers/teachers-list'))
    {
      this.isTeachersList=true;
      this.getAllTeachersList();
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='teachers/sections'))
    {
      this.isSection=true
    }
  }

  addTeachers()
  {
    this.teachersService.saveTeachers(this.teachers).subscribe(data=>{
      this.alertService.submitSuccessAlert();
      console.log(data)
      this.router.navigate(['teachers/teachers-list'])
    })
  }

  getAllTeachersList()
  {
    this.teachersService.getAllTeachers().subscribe(data=>{
      this.teachersList=data;
      console.log(this.teachersList)
    })
  }

  getTeacherWithSection()
  {
    this.teachersService.getTeachersWithSections(this.teachersId).subscribe(data=>{
      console.log(data)
      this.sectionList=data;
    })
  }
}
