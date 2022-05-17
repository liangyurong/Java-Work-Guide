package com.demo.aop_log;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy                    // 开启自动生成代理 (如果有扫描到controller层会报代理出错)
public class AopConfig {
}
