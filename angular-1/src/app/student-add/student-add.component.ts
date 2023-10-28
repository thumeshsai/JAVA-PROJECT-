import { Component } from '@angular/core';
import { Student } from '../student';
import { Router } from '@angular/router';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student-add',
  templateUrl: './student-add.component.html',
  styleUrls: ['./student-add.component.css']
})
export class StudentAddComponent {

  student: Student = new Student();
  constructor(private studentService: StudentService, private router: Router) { }

  saveStudent() {
    this.studentService.addStudent(this.student).subscribe(data => {
      console.log(data);
      this.goToStudentList();
    }, error => console.log(error));
  }

  goToStudentList() {
    this.router.navigate(['/student-list']);
  }

  onSubmit() {
    console.log(this.student);
    this.saveStudent(); // Call saveStudent when the form is submitted.
  }
}
