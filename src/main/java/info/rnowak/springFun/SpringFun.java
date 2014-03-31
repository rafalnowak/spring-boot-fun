package info.rnowak.springFun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringFun {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringFun.class);
        app.setShowBanner(false);
        app.run(args);
    }
}
