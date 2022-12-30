package com.driver;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Process {

    @Autowired
    DataBase db;
    public void add_student(Student student){
        db.add_student(student);
    }
    public void add_teacher(Teacher teacher){
        db.add_teacher(teacher);
    }
    public void pair(String student,String teacher){
        db.add_pair(student,teacher);
    }
    public Student get_student_by_name(String name){
        Student st = db.getStudentDB().get(name);
        return st;
    }
    public Teacher get_teacher_by_name(String name){
        Teacher t = db.getTeacherDB().get(name);
        return t;
    }
    public List<String> get_students_by_teacher(String name){
        List<String> lt = db.getStudent_Teacher().get(name);
        return lt;
    }

}
