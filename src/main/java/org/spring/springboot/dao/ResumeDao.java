package org.spring.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.EduExp;
import org.spring.springboot.domain.Resume;
import org.spring.springboot.domain.StoreSignUp;
import org.spring.springboot.domain.WorkExp;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface ResumeDao {

	/**
	 * 获取
	 *
	 * @return
	 */
	public Resume findResumeByOpenId(@Param("openId") String openId);

	List<Resume> listResumePage();

	List<WorkExp> listWorkExpByOpenId(@Param("openId") String openId);

	List<EduExp> listEduExpByOpenId(@Param("openId") String openId);

	Long saveResume(Resume resume);

	Long saveWorkExp(WorkExp workExp);

	Long saveEduExp(EduExp eduExp);

	Long editResume(Resume resume);

	Long editWorkExp(WorkExp workExp);

	Long editEduExp(EduExp eduExp);

}
