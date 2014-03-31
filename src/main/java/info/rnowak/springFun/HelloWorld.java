package info.rnowak.springFun;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
@EnableAutoConfiguration
public class HelloWorld {
    public String home() {
        return "Hello world from Spring Boot";
    }
}
