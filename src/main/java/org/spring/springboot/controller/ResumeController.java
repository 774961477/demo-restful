package org.spring.springboot.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.EduExp;
import org.spring.springboot.domain.Resume;
import org.spring.springboot.domain.ResumeDto;
import org.spring.springboot.domain.ResumePage;
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
		if (null != resumeTmp) {
			BeanUtils.copyProperties(resumeTmp, resumeDto);
		}
/*
		List<WorkExp> listWorkExp = new ArrayList<WorkExp>();
		listWorkExp = resumeService.listWorkExpByOpenId(resume.getOpenId());
		resumeDto.setWorkList(listWorkExp);

		List<EduExp> listEduExp = new ArrayList<EduExp>();
		listEduExp = resumeService.listEduExpByOpenId(resume.getOpenId());
		resumeDto.setEduList(listEduExp);
*/
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
	public PageInfo<Resume> listPage(@RequestBody ResumePage resumePage) {
		PageHelper.startPage(resumePage.getPageNum(), resumePage.getPageSize());
		Resume resume = new Resume();
		resume.setIndustry(resumePage.getIndustry());
		resume.setStartDate(resumePage.getStartDate());
		resume.setEndDate(resumePage.getEndDate());
		List<Resume> list = resumeService.listResumePage(resume);
		PageInfo<Resume> pageInfo = new PageInfo<Resume>(list);
		return pageInfo;
	}

	@RequestMapping("/download")
	public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 告诉浏览器用什么软件可以打开此文件
		response.setHeader("content-Type", "application/vnd.ms-excel");
		// 下载文件的默认名称

		response.setHeader("Content-Disposition",
				"attachment;filename=" + URLEncoder.encode("简历数据表", "UTF-8") + ".xls");
		// 编码
		response.setCharacterEncoding("UTF-8");
		Resume resume = new Resume();
		if (StringUtils.isNotBlank(request.getParameter("startDate"))) {
			resume.setStartDate(DateUtils.parseDate(request.getParameter("startDate"), "yyyy-MM-dd"));
		}
		if (StringUtils.isNotBlank(request.getParameter("endDate"))) {
			resume.setEndDate(DateUtils.parseDate(request.getParameter("endDate"), "yyyy-MM-dd"));
		}
		if (StringUtils.isNotBlank(request.getParameter("industry"))) {
			resume.setIndustry(request.getParameter("industry"));
		}
		List<Resume> list = resumeService.listResumePage(resume);
		/*
		for (int i = 0; i < list.size(); i++) {
			List<WorkExp> listWorkExp = new ArrayList<WorkExp>();
			listWorkExp = resumeService.listWorkExpByOpenId(list.get(i).getOpenId());
			list.get(i).setWorkList(listWorkExp);
			List<EduExp> listEduExp = new ArrayList<EduExp>();
			listEduExp = resumeService.listEduExpByOpenId(list.get(i).getOpenId());
			list.get(i).setEduList(listEduExp);
			
		}
		*/
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), Resume.class, list);
		workbook.write(response.getOutputStream());
	}
}
