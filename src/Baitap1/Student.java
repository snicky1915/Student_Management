package Baitap1;

import java.util.Scanner;

public class Student implements Comparable<Student>{
    private  String id;
    private String studentName;
    private int semester;
    private String courseName;

    public Student(String id, String studentName, String courseName, int semester) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.semester = semester;
    }//Contructor
    @Override
    public int compareTo(Student other) {// sap xep theo ten
        return this.studentName.compareToIgnoreCase(other.getStudentName());
    }
//override toString
    @Override
    public String toString() {
        return String.format("Student{id='%s', studentName='%-20s', semester=%d, courseName='%-20s'}\n",
                id, studentName, semester, courseName);
    }
//in ra tên và khoa khoá học
    public String toNameAndCourseString() {
        return String.format("%-20s %-20s", studentName, courseName);
    }
    public void findByName(){

    }
//getter and setter
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
