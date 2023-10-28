import { Component, OnInit } from '@angular/core';
import { Student } from '../student'; // Import the Student class
import { ActivatedRoute } from '@angular/router';
import { StudentService } from '../student.service'; // Import the StudentService

@Component({
  selector: 'app-student-details', // Change the selector to 'app-student-details'
  templateUrl: './student-details.component.html', // Update the template file path
  styleUrls: ['./student-details.component.css'] // Update the CSS file path
})
export class StudentDetailsComponent implements OnInit {

  id!: number; // Add the definite assignment assertion modifier '!'
  student!: Student; // Add the definite assignment assertion modifier '!'

  constructor(private route: ActivatedRoute, private studentService: StudentService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.student = new Student(); // Create a new Student object
    this.studentService.getStudentById(this.id).subscribe(data => {
      this.student = data; // Update the variable name to 'student'
    });
  }
}
