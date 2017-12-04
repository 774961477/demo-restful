package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.StudentDao;
import org.spring.springboot.domain.Student;
import org.spring.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao StudentDao;

    
    @Override
    public Long saveStudent(Student student) {
        return StudentDao.saveStudent(student);
    }
    public List<Student> findAllStudent(){
        return StudentDao.findAllStudent();
    }
    
 

}
