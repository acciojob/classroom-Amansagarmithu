package com.driver;

import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class DataBase {
    public HashMap<String,Student> studentDB = new HashMap<>();
    public HashMap<String,Teacher> TeacherDB = new HashMap<>();
    public HashMap<String,List<String>> student_Teacher = new HashMap<>();
    public List<String> stu = new ArrayList<>();

    public void add_student(Student student){
        studentDB.put(student.getName(),student);
        stu.add(student.getName());
    }
    public void add_teacher(Teacher teacher){
        TeacherDB.put(teacher.getName(),teacher);
    }
    public void add_pair(String stuudent,String Teaccher){
        if(student_Teacher.containsKey(Teaccher)){
            student_Teacher.get(Teaccher).add(stuudent);
        }
        else{
            List<String> arr = new ArrayList<>();
            arr.add(stuudent);
            student_Teacher.put(Teaccher,arr);
        }
    }

    public HashMap<String, Student> getStudentDB() {
        return studentDB;
    }

    public HashMap<String, Teacher> getTeacherDB() {
        return TeacherDB;
    }

    public HashMap<String, List<String>> getStudent_Teacher() {
        return student_Teacher;
    }

    public List<String> getStu() {
        return stu;
    }
}
