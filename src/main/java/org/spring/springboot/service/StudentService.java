package org.spring.springboot.service;

import java.util.List;

import org.spring.springboot.domain.City;
import org.spring.springboot.domain.Student;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface StudentService {

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveStudent(Student Student);
    
    List<Student> findAllStudent();
 
}
