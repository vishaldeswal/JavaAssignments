import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeacherComponent } from './teacher/teacher.component';
import { StudentComponent } from './student/student.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { ResultListComponent } from './result-list/result-list.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { AddResultComponent } from './add-result/add-result.component';
import { UpdateResultComponent } from './update-result/update-result.component';
import { ReactiveFormsModule } from '@angular/forms';
import { StudentResultComponent } from './student-result/student-result.component';

@NgModule({
  declarations: [
    AppComponent,
    TeacherComponent,
    StudentComponent,
    HeaderComponent,
    HomeComponent,
    ResultListComponent,
    AddResultComponent,
    UpdateResultComponent,
    StudentResultComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
