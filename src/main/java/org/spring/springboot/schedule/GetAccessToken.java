package org.spring.springboot.schedule;

import org.spring.springboot.common.utils.AccessTokenUtil;
import org.spring.springboot.constants.AccessToken;
import org.spring.springboot.constants.WechatApiUrlConstants;
import org.spring.springboot.constants.WechatContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class GetAccessToken {

	@Autowired
	private WechatContants wechatContants;

	// @Scheduled(fixedRate=20000) ////测试每20秒执行一次
	//@Scheduled(cron = "0/5 * *  * * ? ") // 测试每5秒执行一次
	//@Scheduled(cron="0/10000 * * * * ? ") //每7000秒执行一次
	@Scheduled(cron = "0 0/30 * * * ?") //俩小时执行一次
	public void getAccessToken() {
		System.out.println("进来咯。。。。");
		RestTemplate restTemplate = new RestTemplate();
		String tokenUrl = WechatApiUrlConstants.token.replace("APPID", wechatContants.getAppid()).replace("APPSECRET",
				wechatContants.getSecret());
		AccessTokenUtil.accessToken = restTemplate.getForObject(tokenUrl, AccessToken.class);

	}
}
