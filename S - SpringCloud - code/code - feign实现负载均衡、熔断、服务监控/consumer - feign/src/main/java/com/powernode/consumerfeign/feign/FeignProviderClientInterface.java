package com.powernode.consumerfeign.feign;


import com.powernode.consumerfeign.feign.impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// 访问下面的接口，如果成功则直接访问，如果出现问题则跳转到FeignError.class
@FeignClient(value = "provider",fallback = FeignError.class) // value写的是服务名，fallback写的是降级处理的类名
@Primary // 解决controlle自动注入这个bean有多个bean
public interface FeignProviderClientInterface {

    @GetMapping("/hello")
    String hello();
}
