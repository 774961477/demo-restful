package org.spring.springboot.controller;

import java.util.Date;
import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.Teacher;
import org.spring.springboot.service.TeacherService;
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
public class TeacherController {
	@Autowired
    private IdGenerator idGenerator;
    @Autowired
    private TeacherService teacherService;

     

    @RequestMapping(value = "/api/teacher", method = RequestMethod.POST)
    public void createTeacher(@RequestBody Teacher teacher) {
    	teacher.setId(idGenerator.nextId());
    	teacher.setCreateTime(new Date());
    	teacherService.saveTeacher(teacher);
    }
    
    @RequestMapping(value = "/api/teacher", method = RequestMethod.GET)
    public List<Teacher> findAllTeacher() {
        return teacherService.findAllTeacher();
    }
 
}
