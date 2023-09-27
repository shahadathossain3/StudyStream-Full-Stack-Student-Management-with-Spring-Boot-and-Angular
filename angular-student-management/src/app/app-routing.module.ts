import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClassroomComponent} from "./components/classroom/classroom.component";
import {SubjectsComponent} from "./components/subjects/subjects.component";
import {SectionsComponent} from "./components/sections/sections.component";
import {StudentsComponent} from "./components/students/students.component";
import {Teachers} from "./models/teachers.model";
import {TeachersComponent} from "./components/teachers/teachers.component";
import {EnrollmentComponent} from "./components/enrollment/enrollment.component";
import {ExaminationComponent} from "./components/examination/examination.component";
import {ResultComponent} from "./components/result/result.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {AuthRouteguardsGuard} from "./routeguards/auth-routeguards.guard";
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {LogoutComponent} from "./components/logout/logout.component";
import {AttendanceComponent} from "./components/attendance/attendance.component";

const routes: Routes = [
  {path:'', redirectTo:'/home', pathMatch: 'full'},
  {path:'home', component: HomeComponent},
  {path:'classroom/add-classroom', component:ClassroomComponent, canActivate:[AuthRouteguardsGuard]},
  {path:'classroom/classroom-list', component:ClassroomComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'subjects/add-subjects', component:SubjectsComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'subjects/subjects-list', component:SubjectsComponent},
  {path: 'sections/add-sections', component:SectionsComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'sections/sections-list', component:SectionsComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'students/add-students', component:StudentsComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'students/students-list', component:StudentsComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'students/sections', component:StudentsComponent},
  {path: 'students/examination-list', component:StudentsComponent},
  {path: 'students/result-list', component:StudentsComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'teachers/add-teachers', component:TeachersComponent},
  {path: 'teachers/teachers-list', component:TeachersComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'teachers/attendance', component:AttendanceComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'teachers/sections', component:TeachersComponent},
  {path: 'enrollments/add-enrollments-students', component:EnrollmentComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'enrollments/add-enrollments-teachers', component:EnrollmentComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'examination/add-examination', component:ExaminationComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'result/add-result', component:ResultComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'dashboard', component:DashboardComponent, canActivate:[AuthRouteguardsGuard]},
  {path: 'login', component:LoginComponent},
  {path: 'logout', component: LogoutComponent},

  // {path: 'examination/add-examination', component:ExaminationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
