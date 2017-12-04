package org.spring.springboot.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.utils.IdGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@Configuration
@EnableScheduling
public class ApplicationConfiguration {

	private static final Logger log = LoggerFactory.getLogger(ApplicationConfiguration.class);
	
	@Bean
	public IdGenerator idGenerator() {
		return new IdGenerator(0, 1);
	}

}
