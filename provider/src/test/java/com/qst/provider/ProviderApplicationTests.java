package com.qst.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProviderApplication.class)
public class ProviderApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() throws InterruptedException {
        while(true){
            Thread.sleep(5000);
            this.sender.send("HELLO-RabbitMQ");
        }
    }

}
