package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.Customer;
import tn.iteam.repositories.CustomerRepository;

import java.util.List;

@SpringBootApplication
public class MsCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCustomerServiceApplication.class, args);
        System.out.println("Customer Service is running...");
    }


    @Bean
    public CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers = List.of(

                    Customer.builder()
                            .firstname("Ahmed")
                            .lastname("Ben Ahmed")
                            .email("bouhmid@gmail.com")
                            .build(),

                    Customer.builder()
                            .firstname("aziz")
                            .lastname("bjaoui")
                            .email("zizou@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstname("ali")
                            .lastname("trabelsi")
                            .email("aloulou@gmail.com")
                            .build());
            customerRepository.saveAll(customers);
            customerRepository.findAll().forEach(
                    customer -> {
                        customer.getEmail();
                    }
            );
        };

    }



}
