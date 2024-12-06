package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.BankAccount;
import tn.iteam.enums.AccountType;
import tn.iteam.repositories.AccountRepository;

import java.util.List;
import java.util.UUID;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class MsAccountServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(MsAccountServiceApplication.class, args);
        System.out.println("Account Service is running");
    }


    @Bean
    public CommandLineRunner init(AccountRepository accountRepository) {
        return args -> {
            List<BankAccount> bankAccounts = List.of(

                    BankAccount
                            .builder()
                            .accountId(UUID.randomUUID().toString())
                            .balance(Math.random()*9000)
                            .currency("DTN")
                            .createdAt(java.time.LocalDate.now())
                            .type(AccountType.CARD_ACCOUNT)
                            .customerId(1L)
                            .build(),

            BankAccount
                    .builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(Math.random()*4000)
                    .currency("USD")
                    .createdAt(java.time.LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(1L)
                    .build());

            accountRepository.saveAll(bankAccounts);

        };


    }
}
