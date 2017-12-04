package org.spring.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.EduExp;
import org.spring.springboot.domain.PageBounds;
import org.spring.springboot.domain.RecruitDto;
import org.spring.springboot.domain.Resume;
import org.spring.springboot.domain.ResumeDto;
import org.spring.springboot.domain.WorkExp;
import org.spring.springboot.service.ResumeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.Response;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 *
 * Created by bysocket on 07/02/2017.
 */
@RestController
@RequestMapping(value = "/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;
    @Autowired
    private IdGenerator idGenerator;
    
    @RequestMapping(value = "/findByOpenId", method = RequestMethod.POST)
    public ResumeDto findByOpenId(@RequestBody Resume resume) {
    	ResumeDto resumeDto = new ResumeDto();
    	Resume resumeTmp = new Resume();
    	resumeTmp = resumeService.findResumeByOpenId(resume.getOpenId());
    	if(null != resumeTmp){
    		BeanUtils.copyProperties(resumeTmp, resumeDto);
    	}
    	
    	
    	List<WorkExp> listWorkExp = new ArrayList<WorkExp>(); 
    	listWorkExp = resumeService.listWorkExpByOpenId(resume.getOpenId());
    	resumeDto.setWorkList(listWorkExp);
    	
    	List<EduExp> listEduExp = new ArrayList<EduExp>(); 
    	listEduExp = resumeService.listEduExpByOpenId(resume.getOpenId());
    	resumeDto.setEduList(listEduExp);
    	
    	return resumeDto;
    	
    }

    @RequestMapping(value = "/addResume", method = RequestMethod.POST)
    public void createRecruit(@RequestBody Resume resume) {
    	resume.setId(idGenerator.nextId());
    	resumeService.saveResume(resume);
    }
    @RequestMapping(value = "/addWorkExp", method = RequestMethod.POST)
    public WorkExp createWorkExp(@RequestBody WorkExp workExp) {
    	workExp.setId(idGenerator.nextId());
    	resumeService.saveWorkExp(workExp);
    	return workExp;
    }
    @RequestMapping(value = "/addEduExp", method = RequestMethod.POST)
    public EduExp createEduExp(@RequestBody EduExp eduExp) {
    	eduExp.setId(idGenerator.nextId());
    	resumeService.saveEduExp(eduExp);
    	return eduExp;
    }
    
    @RequestMapping(value = "/editResume", method = RequestMethod.POST)
    public void editResume(@RequestBody Resume resume) {
    	resumeService.editResume(resume);
    }
    @RequestMapping(value = "/editWorkExp", method = RequestMethod.POST)
    public void editWorkExp(@RequestBody WorkExp workExp) {
    	resumeService.editWorkExp(workExp);
    }
    @RequestMapping(value = "/editEduExp", method = RequestMethod.POST)
    public void editEduExp(@RequestBody EduExp eduExp) {
    	eduExp.setId(idGenerator.nextId());
    	resumeService.editEduExp(eduExp);
    }
    
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageInfo<Resume> listPage(@RequestBody PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPageNum(), pageBounds.getPageSize());
        List<Resume> list = resumeService.listResumePage();
        PageInfo<Resume> pageInfo = new PageInfo<Resume>(list);
        return  pageInfo;
    }
}
