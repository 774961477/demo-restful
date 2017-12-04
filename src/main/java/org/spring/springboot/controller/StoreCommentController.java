package org.spring.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.CommentPage;
import org.spring.springboot.domain.Store;
import org.spring.springboot.domain.StoreComment;
import org.spring.springboot.domain.StoreCommentDto;
import org.spring.springboot.service.StoreCommentService;
import org.spring.springboot.service.StoreService;
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
@RequestMapping(value = "/storecomment")
public class StoreCommentController {

    @Autowired
    private StoreCommentService storeCommentService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveComment(@RequestBody StoreComment storeComment) {
    	if(StringUtils.isNotBlank(storeComment.getStoreId())){
    		storeComment.setId(idGenerator.nextId());
        	storeCommentService.saveStoreComment(storeComment);
        	
        	List<StoreCommentDto> list = new ArrayList<StoreCommentDto>();
        	list = storeCommentService.findCommentByStoreId(storeComment);
        	if(list.size()>0){
        		Store store = new Store();
        		float stars = 0;
        		float allStars = 0;
        		for(int i=0;i<list.size();i++){
        			allStars += list.get(i).getStars();
        		}
        		stars = allStars / list.size();
        		store.setId(storeComment.getStoreId());
        		store.setStoreStars(stars);
        		storeService.updateStoreStars(store);
        	}
        	
        	
    	}
    	
    }
    
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageInfo<StoreCommentDto> listPage(@RequestBody CommentPage commentPage) {
        PageHelper.startPage(commentPage.getPageNum(), commentPage.getPageSize());
        StoreComment storeComment = new StoreComment();
        storeComment.setStoreId(commentPage.getStoreId());
        List<StoreCommentDto> list = storeCommentService.findCommentByStoreId(storeComment);
        PageInfo<StoreCommentDto> pageInfo = new PageInfo<StoreCommentDto>(list);
        return  pageInfo;
    }
}
