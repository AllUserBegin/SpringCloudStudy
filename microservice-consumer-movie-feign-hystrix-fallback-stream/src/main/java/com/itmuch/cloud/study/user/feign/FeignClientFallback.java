package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.user.entity.User;
import org.springframework.stereotype.Component;

@Component
class FeignClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User entity=new User();
        entity.setId(-1L);
        entity.setUsername("默认用户");
        return  entity;
    }
}
