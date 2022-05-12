package net.idrok.talababackend.service;

import net.idrok.talababackend.entity.Student;
import net.idrok.talababackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Page<Student> getAll(String key, Long id, Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student create(Student student) {
        if (student.getId() == null) {
            return studentRepository.save(student);
        }
        throw new RuntimeException("Id Null bo'lishi shart");
    }

    public Student update(Student student) {
        if (student.getId() != null) {
            return studentRepository.save(student);
        }
        throw new RuntimeException("Id  bo'lishi shart");
    }

    public void delete(Student student) {
        studentRepository.delete(student);

    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


}
