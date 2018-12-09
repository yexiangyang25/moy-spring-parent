package org.moy.spring.bus.amqp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AmqpApplicationTest {

    @Autowired
    Sender sender;

    @Test
    public void hello(){
        sender.send();
    }
}
