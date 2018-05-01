package com.bdsoft.xtgl;

import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.bdsoft.xtgl.mapper")
@EnableJms
public class DemoApplication {
	/*注入消息队列 名字为sample.queue*/
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
