package info.rnowak.springFun.web;

import info.rnowak.springFun.SpringFun;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringFun.class)
public class MessageControllerIntegrationsTest {
    @Autowired
    private MessageController controller;
}
