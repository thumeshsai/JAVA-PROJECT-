import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentListComponent }  from './student-list/student-list.component';
import { StudentAddComponent } from './student-add/student-add.component';
import {StudentDetailsComponent} from "./student-details/student-details.component";
const routes: Routes = [
  {path: 'student-list', component: StudentListComponent},
  {path: 'student-add', component: StudentAddComponent},
  {path: 'student-details/:id', component: StudentDetailsComponent},
  {path: '', redirectTo: 'students', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
