import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private baseURL = "http://localhost:8080/api/front/students";

  constructor(private httpClient: HttpClient) { }

  getStudentsList(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.baseURL);
  }

  addStudent(student: Student): Observable<Object> {
    return this.httpClient.post(this.baseURL, student);
  }

  getStudentById(id: number): Observable<Student> {
    const url = `${this.baseURL}/${id}`;
    return this.httpClient.get<Student>(url);
  }
}
