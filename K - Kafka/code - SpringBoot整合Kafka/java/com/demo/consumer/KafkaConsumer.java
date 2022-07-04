package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "springboot_kafka")
    public void consumer(String msg){
        System.out.println("消费者收到消息：" + msg);
    }

}
