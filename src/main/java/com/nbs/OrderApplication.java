package com.nbs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//@EnableEurekaClient  //声明这个是Eureka的客户端
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
	}
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
