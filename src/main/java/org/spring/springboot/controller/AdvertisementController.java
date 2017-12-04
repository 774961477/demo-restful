package org.spring.springboot.controller;

import java.util.List;

import org.spring.springboot.common.utils.IdGenerator;
import org.spring.springboot.domain.Advertisement;
import org.spring.springboot.domain.AdvertisementDto;
import org.spring.springboot.service.AdvertisementService;
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
@RequestMapping(value = "/advertisement")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private IdGenerator idGenerator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void createAdvertisement(@RequestBody Advertisement advertisement) {
    	advertisement.setId(idGenerator.nextId());
    	advertisementService.saveAdvertisement(advertisement);
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<AdvertisementDto> Advertisement() {
    	
    	return advertisementService.findAllAdvertisement();
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void deleteAdvertisement(@RequestBody Advertisement advertisement) {
    	 advertisementService.deleteAdvertisement(advertisement.getId());
    }
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public AdvertisementDto findById(@RequestBody Advertisement advertisement) {
    	
    	return advertisementService.findAdvertisementById(advertisement.getId());
    }
    
    @RequestMapping(value = "/findByColumnId", method = RequestMethod.POST)
    public AdvertisementDto findByColumnId(@RequestBody Advertisement advertisement) {
    	
    	return advertisementService.findByColumnId(advertisement.getColumnId());
    }

    
}
