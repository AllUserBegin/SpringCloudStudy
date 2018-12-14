package com.itmuch.cloud.study.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.User;
/**
 * @author Administrator
 * @Title: lic
 * @ProjectName microservice-parent
 * @Description: TODO
 * @date 2018/12/1414:56
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/User/{id}")
    public  User findById(@PathVariable Long id)
    {
        return  this.restTemplate.getForObject("http://localhost:8000/"+id,User.class);
    }
}
