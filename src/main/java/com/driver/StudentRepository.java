package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();
    HashMap<String,List<String>> studentTeacherDb = new HashMap<>();
    public void addStudentInDb(Student student) {
        studentDb.put(student.getName(),student);
    }

    public void addTeacherInDb(Teacher teacher) {
        teacherDb.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPairInDb(String student, String teacher) {
        List<String> studentList = studentTeacherDb.getOrDefault(teacher,new ArrayList<>());
        studentList.add(student);
        studentTeacherDb.put(teacher,studentList);
    }

    public Student getStudentByNameFromDb(String name) {
        if(studentDb.containsKey(name)){
            return studentDb.get(name);
        }
        return null;
    }

    public Teacher getTeacherByNameFromDb(String name) {
        if(teacherDb.containsKey(name)){
            return teacherDb.get(name);
        }
        return null;
    }

    public List<String> getStudentsByTeacherNameFromDb(String teacher) {
        List<String> studentList =studentTeacherDb.get(teacher);
        return studentList;
    }

    public List<String> getAllStudentsFromDb() {
        List<String> studentList=null;
        for(String stud : studentDb.keySet()){
            studentList.add(stud);
        }
        return studentList;
    }

    public void deleteTeacherByNameFromDb(String teacher) {
        List<String> studentList = studentTeacherDb.get(teacher);
        for(String student : studentList){
            if(studentDb.containsKey(student)){
                studentDb.remove(student);
            }
        }
        studentTeacherDb.remove(teacher);
    }

    public void deleteAllTeachersFromDb() {
        for(String teacher : studentTeacherDb.keySet()){
            List<String> studentList = studentTeacherDb.get(teacher);
            for(String student : studentList){
                if(studentDb.containsKey(student)){
                    studentDb.remove(student);
                }
            }
        }
        studentTeacherDb.clear();
    }
}