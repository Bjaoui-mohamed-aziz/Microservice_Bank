package tn.iteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsDicoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDicoveryServiceApplication.class, args);
    }

}
