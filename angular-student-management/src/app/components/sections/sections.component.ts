import { Component } from '@angular/core';
import {Subjects} from "../../models/subjects.model";
import {SubjectsService} from "../../services/subjects.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Sections} from "../../models/sections.model";
import {SectionsService} from "../../services/sections.service";
import {ClassroomService} from "../../services/classroom.service";
import {Classroom} from "../../models/classroom.model";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'app-sections',
  templateUrl: './sections.component.html',
  styleUrls: ['./sections.component.css']
})
export class SectionsComponent {
  isSectionsAdd=false;
  isSectionsList=false;

  sections=new Sections();
  subjects=new Subjects();
  classroom=new Classroom();

  sectionsList?:Sections[]
  dayOfWeekList?:String[];
  classroomList?:Classroom[];
  subjectsList?:Subjects[];

  constructor(private sectionsService:SectionsService,private router:Router, private activatedRoute:ActivatedRoute,
  private subjectsService:SubjectsService, private classroomService:ClassroomService, private alertService:AlertService) {
  }

  ngOnInit(): void {
    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='sections/add-sections'))
    {
      this.isSectionsAdd=true;
      this.getAllDayOfWeekList();
      this.getAllClassroomList();
      this.getAllSubjectList();
    }

    if(this.activatedRoute.pathFromRoot.some(router=>router.routeConfig?.path==='sections/sections-list'))
    {
      this.isSectionsList=true;
      this.getAllSectionsList()
    }
  }

  addSection()
  {
    this.sections.subjects=this.subjects;
    this.sections.classroom=this.classroom;
    this.sectionsService.saveSections(this.sections).subscribe(data=>{
      this.alertService.submitSuccessAlert();
      console.log(data)
      this.getAllSectionsList()
      this.router.navigate(['sections/sections-list'])
    })
  }

  getAllSectionsList()
  {
    this.sectionsService.getAllSections().subscribe(data=>{
      this.sectionsList=data;
      console.log(this.sectionsList)
    })
  }

  getAllSubjectList()
  {
    this.subjectsService.getAllSubjects().subscribe(data=>{
      this.subjectsList=data;
      console.log(this.subjectsList)
    })
  }

  getAllDayOfWeekList()
  {
    this.sectionsService.getAllDayOfWeek().subscribe(data=>{
      this.dayOfWeekList=data;
    })
  }


  getAllClassroomList()
  {
    this.classroomService.getAllClassroom().subscribe(data=>{
      this.classroomList=data;
    })
  }


}
