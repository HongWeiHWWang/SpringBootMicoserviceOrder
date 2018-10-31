package com.nbs.service;

import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nbs.pojo.Item;
@Service
public class ItemService {

	@Value("${item.url}")
	private String itemUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Item queryById(Long id) {
		Item item = restTemplate.getForObject(itemUrl + id, Item.class);
		return item;
		
	}
	@Autowired
	private DiscoveryClient discoveryClient;

	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")   //进行容错以处理
	public Item queryItemById(Long id) {
		String serviceId = "SpringBootMicoserviceItem";
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);

		if(instances == null || instances.isEmpty()){
			return null;
		}
		ServiceInstance serviceInstance = instances.get(0);
		System.out.println(serviceInstance.getServiceId());
		serviceInstance.getHost();
		serviceInstance.getPort();
		//String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
		//Item item = restTemplate.getForObject(url + "/item/" + id, Item.class);
		Item item = restTemplate.getForObject( "http://" + serviceId + "/item/" + id, Item.class);

		//Item item = restTemplate.getForEntity("http://" + serviceId + "/item" + id, Item.class).getBody();
		return item;
	}

	public Item queryItemByIdFallbackMethod(Long id) { //请求失败执行的方法
		return new Item(null,"获得商品信息出错",null,null,null);
	}

}
