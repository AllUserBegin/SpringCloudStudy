package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.user.entity.User;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger logger= LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        FeignClientFallbackFactory.logger.info("fallback;reason was:",throwable);
       return  new UserFeignClient() {
           @Override
           public User findById(Long id) {
               FeignClientFallbackFactory.logger.info("fallback;reason was:",throwable);

               User entity=new User();
               entity.setId(-1L);
               entity.setUsername("默认用户");
               return  entity;
           }
       };
    }
}
