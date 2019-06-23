package com.qst.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.info}"),
                exchange = @Exchange(value = "${mq.config.exchange}",type =ExchangeTypes.DIRECT),
                key = "${mq.config.queue.info.routing.key}"
        )
)
public class InfoReciver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Info=================reciver: "+msg);

    }
}
