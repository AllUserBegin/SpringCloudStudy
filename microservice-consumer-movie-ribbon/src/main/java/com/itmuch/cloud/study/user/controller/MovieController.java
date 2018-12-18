package com.itmuch.cloud.study.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.User;

@RestController
public class MovieController {

  private  static  final Logger logger= LoggerFactory.getLogger(MovieController.class);
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    User entity=  this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    return  entity;
  }

  @GetMapping("/log-user-intance")
  public  void  logUserIntance()
  {
    ServiceInstance  serviceInstance=this.loadBalancerClient.choose("microservice-provider-user");
    MovieController.logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
  }
}
