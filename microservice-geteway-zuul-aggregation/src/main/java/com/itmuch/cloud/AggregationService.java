package com.itmuch.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;


@Service
public class AggregationService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Long id)
    {
        //创建一个被观察者
        return  Observable.create(observer->
        {
            //请求用户微服务的/{id}端点
            User user=restTemplate.getForObject("http://microservice-provider-user/{id}",User.class,id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }


     @HystrixCommand(fallbackMethod = "fallback")
    public  Observable<User> getMoveUserByUserId(Long id) {
         //创建一个被观察者
         return Observable.create(observer ->
         {
             User user=restTemplate.getForObject("http://microservice-consumer-movie/user/{id}",User.class,id);
             observer.onNext(user);
             observer.onCompleted();
         });

     }

     public  User fallback(Long id)
     {
         User user=new User();
         user.setId(id);
         return  user;
     }




}
