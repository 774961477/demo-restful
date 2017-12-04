package org.spring.springboot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.EduExp;
import org.spring.springboot.domain.Resume;
import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.domain.StoreSignUp;
import org.spring.springboot.domain.StoreSignUpDto;
import org.spring.springboot.domain.WorkExp;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface ResumeService {

	public Resume findResumeByOpenId(String openId);

	List<Resume> listResumePage();

	List<WorkExp> listWorkExpByOpenId(String openId);

	List<EduExp> listEduExpByOpenId(String openId);

	Long saveResume(Resume resume);

	Long saveWorkExp(WorkExp workExp);

	Long saveEduExp(EduExp eduExp);

	Long editResume(Resume resume);

	Long editWorkExp(WorkExp workExp);

	Long editEduExp(EduExp eduExp);
    
}
