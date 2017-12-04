package org.spring.springboot.controller;

import java.util.Date;
import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.Student;
import org.spring.springboot.domain.Teacher;
import org.spring.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
public class StudentController {
	@Autowired
    private IdGenerator idGenerator;
    @Autowired
    private StudentService studentService;

     

    @RequestMapping(value = "/api/student", method = RequestMethod.POST)
    public void createStudent(@RequestBody Student student) {
    	student.setId(idGenerator.nextId());
    	student.setCreateTime(new Date());
    	studentService.saveStudent(student);
    }
    
    @RequestMapping(value = "/api/student", method = RequestMethod.GET)
    public List<Student> findAllStudent() {
        return studentService.findAllStudent();
    }
 
}
