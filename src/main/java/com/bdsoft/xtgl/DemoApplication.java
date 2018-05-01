package com.bdsoft.xtgl;

import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.jms.Queue;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@MapperScan("com.bdsoft.xtgl.mapper")
/*开启JMS*/
@EnableJms
/*事务开启*/
@EnableTransactionManagement
public class DemoApplication {
	/*注入消息队列 默认名字为sample.queue*/
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
