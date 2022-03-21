package com.br.youtubeOasys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableAutoConfiguration
@ComponentScan ({"com.br.youtubeOasys.api", "com.br.youtubeOasys.domain.repository", "com.br.youtubeOasys.domain.service"})
@EnableFeignClients
public class YoutubeOasysApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubeOasysApplication.class, args);
	}
}
