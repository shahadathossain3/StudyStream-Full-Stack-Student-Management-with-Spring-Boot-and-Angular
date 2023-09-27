import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentsComponent } from './components/students/students.component';
import { TeachersComponent } from './components/teachers/teachers.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { ClassroomComponent } from './components/classroom/classroom.component';
import { SubjectsComponent } from './components/subjects/subjects.component';
import { SectionsComponent } from './components/sections/sections.component';
import { EnrollmentComponent } from './components/enrollment/enrollment.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { ResultComponent } from './components/result/result.component';
import { ExaminationComponent } from './components/examination/examination.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/header/header.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {AppInterceptorInterceptor} from "./interceptors/app-interceptor.interceptor";
import {AuthRouteguardsGuard} from "./routeguards/auth-routeguards.guard";
import { HomeComponent } from './components/home/home.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AttendanceComponent } from './components/attendance/attendance.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    TeachersComponent,
    SidebarComponent,
    ClassroomComponent,
    SubjectsComponent,
    SectionsComponent,
    EnrollmentComponent,
    ResultComponent,
    ExaminationComponent,
    LoginComponent,
    HeaderComponent,
    DashboardComponent,
    HomeComponent,
    LogoutComponent,
    AttendanceComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [
    {
      provide : HTTP_INTERCEPTORS,
      useClass : AppInterceptorInterceptor,
      multi : true
    },AuthRouteguardsGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
