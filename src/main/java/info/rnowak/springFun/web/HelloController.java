package info.rnowak.springFun.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "Hello world from Spring Boot!";
    }
}
