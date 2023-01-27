package pl.dstasiak.fs1.service;

import pl.dstasiak.fs1.entity.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
