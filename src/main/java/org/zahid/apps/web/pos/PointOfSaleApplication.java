package org.zahid.apps.web.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@SpringBootApplication
public class PointOfSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointOfSaleApplication.class, args);
    }

}
