package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.dao.ResumeDao;
import org.spring.springboot.dao.StoreJoinDao;
import org.spring.springboot.dao.StoreSignUpDao;
import org.spring.springboot.domain.EduExp;
import org.spring.springboot.domain.Resume;
import org.spring.springboot.domain.StoreJoin;
import org.spring.springboot.domain.StoreSignUp;
import org.spring.springboot.domain.StoreSignUpDto;
import org.spring.springboot.domain.WorkExp;
import org.spring.springboot.service.ResumeService;
import org.spring.springboot.service.StoreJoinService;
import org.spring.springboot.service.StoreSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class ResumeServiceImpl implements ResumeService{

	@Autowired
    private ResumeDao resumeDao;

	@Override
	public Resume findResumeByOpenId(String openId) {
		// TODO Auto-generated method stub
		return resumeDao.findResumeByOpenId(openId);
	}

	@Override
	public List<Resume> listResumePage() {
		// TODO Auto-generated method stub
		return resumeDao.listResumePage();
	}

	@Override
	public List<WorkExp> listWorkExpByOpenId(String openId) {
		// TODO Auto-generated method stub
		return resumeDao.listWorkExpByOpenId(openId);
	}

	@Override
	public List<EduExp> listEduExpByOpenId(String openId) {
		// TODO Auto-generated method stub
		return resumeDao.listEduExpByOpenId(openId);
	}

	@Override
	public Long saveResume(Resume resume) {
		// TODO Auto-generated method stub
		return resumeDao.saveResume(resume);
	}

	@Override
	public Long saveWorkExp(WorkExp workExp) {
		// TODO Auto-generated method stub
		return resumeDao.saveWorkExp(workExp);
	}

	@Override
	public Long saveEduExp(EduExp eduExp) {
		// TODO Auto-generated method stub
		return resumeDao.saveEduExp(eduExp);
	}

	@Override
	public Long editResume(Resume resume) {
		// TODO Auto-generated method stub
		return resumeDao.editResume(resume);
	}

	@Override
	public Long editWorkExp(WorkExp workExp) {
		// TODO Auto-generated method stub
		return resumeDao.editWorkExp(workExp);
	}

	@Override
	public Long editEduExp(EduExp eduExp) {
		// TODO Auto-generated method stub
		return resumeDao.editEduExp(eduExp);
	}

    
    
}
