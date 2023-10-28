import { Component } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router'; // Correct import

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent {

  students: Student[] = [];

  constructor(private studentService: StudentService, private router: Router) {} // Inject Router

  ngOnInit(): void {
    this.getStudents();
  }

  private getStudents() {
    this.studentService.getStudentsList().subscribe(data => {
      this.students = data;
    });
  }
  studentDetails(id: number) {
    this.router.navigate(['student-details', id]);
  }
}
