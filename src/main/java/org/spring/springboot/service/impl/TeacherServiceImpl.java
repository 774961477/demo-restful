package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.TeacherDao;
import org.spring.springboot.domain.City;
import org.spring.springboot.domain.Teacher;
import org.spring.springboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    
    @Override
    public Long saveTeacher(Teacher teacher) {
        return teacherDao.saveTeacher(teacher);
    }
    public List<Teacher> findAllTeacher(){
        return teacherDao.findAllTeacher();
    }
    
 

}
