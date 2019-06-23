package com.qst.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.error}"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.error.routing.key}"
        )
)
public class ErrorReciver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("error=================reciver: "+msg);

    }
}
