package com.javaproject.emsbackend.model; // Adjust the package path as needed

import jakarta.persistence.*;

@Entity
@Table(name = "students") // Change the table name to "students"
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Change the data type to int

    private String name; // Add the name variable

    private String department; // Add the department variable

    @Column(name = "phonenumber")
    private String phoneNumber; // Add the phoneNumber variable

    public Student() {

    }

    public Student(String name, String department, String phoneNumber) {
        super();
        this.name = name;
        this.department = department;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
