package com.powernode.consumerfeign.feign.impl;

import com.powernode.consumerfeign.feign.FeignProviderClientInterface;
import org.springframework.stereotype.Component;

@Component
public class FeignError implements FeignProviderClientInterface {
    @Override
    public String hello() {
        return "服务维护中....";
    }
}
