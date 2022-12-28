import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddResultComponent } from './add-result/add-result.component';
import { HomeComponent } from './home/home.component';
import { ResultListComponent } from './result-list/result-list.component';
import { StudentResultComponent } from './student-result/student-result.component';
import { StudentComponent } from './student/student.component';
import { TeacherComponent } from './teacher/teacher.component';
import { UserGuard } from './teacher/user.guard';
import { UpdateResultComponent } from './update-result/update-result.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'Student',component:StudentComponent},
  {path:'Teacher',component:TeacherComponent},
  {path:'Result',component:ResultListComponent,canActivate:[UserGuard]},
  {path:'AddResult',component:AddResultComponent,canActivate:[UserGuard]},
  {path:'UpdateResult/:id',component:UpdateResultComponent,canActivate:[UserGuard]},
  {path:'StudentResult/:id/:dob',component:StudentResultComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
