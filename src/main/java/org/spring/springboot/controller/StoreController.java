package org.spring.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.PageBounds;
import org.spring.springboot.domain.Store;
import org.spring.springboot.domain.StoreDto;
import org.spring.springboot.domain.StorePage;
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
@RequestMapping(value = "/store")
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void createStore(@RequestBody Store store) {
    	store.setId(idGenerator.nextId());
    	storeService.saveStore(store);
    }
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public List<StoreDto> list() {
       
    	StoreDto storeDto = new StoreDto();
        List<StoreDto> list = storeService.findAllStore(storeDto);
        return  list;
    }
     
    
    @RequestMapping(value = "/listPage", method = RequestMethod.POST)
    public PageInfo<StoreDto> listPage(@RequestBody StorePage storePage) {
        PageHelper.startPage(storePage.getPageNum(), storePage.getPageSize());
        StoreDto storeDto = new StoreDto();
        if(StringUtils.isNotBlank(storePage.getColumnId())){
        	storeDto.setStoreColumn(storePage.getColumnId());
        }
        if(StringUtils.isNotBlank(storePage.getStoreName())){
        	storeDto.setStoreName(storePage.getStoreName());
        }
        if(StringUtils.isNotBlank(storePage.getColumnParentId())){
        	storeDto.setColumnParentId(storePage.getColumnParentId());
        }
        if(StringUtils.isNotBlank(storePage.getTopFlag())){
        	storeDto.setTopFlag(storePage.getTopFlag());
        }
        if(StringUtils.isNotBlank(storePage.getCreateUserId())){
        	storeDto.setCreateUserId(storePage.getCreateUserId());
        }
        if(StringUtils.isNotBlank(storePage.getLatitude())){
        	storeDto.setLatitude(storePage.getLatitude());
        }
        if(StringUtils.isNotBlank(storePage.getLongitude())){
        	storeDto.setLongitude(storePage.getLongitude());
        }
        List<StoreDto> list = storeService.findAllStore(storeDto);
        PageInfo<StoreDto> pageInfo = new PageInfo<StoreDto>(list);
        return  pageInfo;
    }
    
    
    
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public StoreDto findById(@RequestBody Store store) {
    	
    	return storeService.findStoreById(store.getId());
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteStore(@RequestBody Store store) {
    	storeService.deleteStore(store.getId());
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void edit(@RequestBody Store store) {
    	storeService.editStore(store);
    }
    
    @RequestMapping(value = "/top", method = RequestMethod.POST)
    public void top(@RequestBody Store store) {
    	storeService.topStore(store);
    }
    
    @RequestMapping(value = "/addCount", method = RequestMethod.POST)
    public void addCount(@RequestBody Store store) {
    	storeService.addCount(store);
    }
    
    @RequestMapping(value = "/listPageByColumnId", method = RequestMethod.POST)
    public PageInfo<StoreDto> listPageByColumnId(@RequestBody StorePage storePage) {
        PageHelper.startPage(storePage.getPageNum(), storePage.getPageSize());
        
        StoreDto storeDto = new StoreDto();
        if(StringUtils.isNotBlank(storePage.getColumnId())){
        	storeDto.setStoreColumn(storePage.getColumnId());
        }
        if(StringUtils.isNotBlank(storePage.getColumnParentId())){
        	storeDto.setColumnParentId(storePage.getColumnParentId());
        }
        if(StringUtils.isNotBlank(storePage.getTopFlag())){
        	storeDto.setTopFlag(storePage.getTopFlag());
        }
        if(null != storePage.getSortBy()){
        	storeDto.setSortBy(storePage.getSortBy());
        }
        
        if(StringUtils.isNotBlank(storePage.getLatitude())){
        	storeDto.setLatitude(storePage.getLatitude());
        }
        if(StringUtils.isNotBlank(storePage.getLongitude())){
        	storeDto.setLongitude(storePage.getLongitude());
        }
        
        List<StoreDto> list = new ArrayList<StoreDto>();
        if(null != storePage.getSortBy() && storePage.getSortBy() == 4){
        	list = storeService.listByDistance(storeDto);
        }else{
        	list = storeService.listPageForMobile(storeDto);
        }
        
        PageInfo<StoreDto> pageInfo = new PageInfo<StoreDto>(list);
        return  pageInfo;
    }
    

    
}
