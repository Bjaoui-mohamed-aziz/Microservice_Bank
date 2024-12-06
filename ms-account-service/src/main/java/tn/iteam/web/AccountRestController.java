package tn.iteam.web;


import org.hibernate.cache.spi.support.CacheUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.iteam.entities.BankAccount;
import tn.iteam.exception.AccountNotFoundException;
import tn.iteam.models.Customer;
import tn.iteam.proxies.CustomerRestClient;
import tn.iteam.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountRestController {

    private final AccountRepository accountRepository;

    private final CustomerRestClient customerRestClient;


    public AccountRestController(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    // API GET /accounts


    @GetMapping("/accounts")
    public List<BankAccount> retrieveAllAccounts() {
        List<BankAccount> accounts = accountRepository.findAll();

        if (accounts.isEmpty()) {

            throw new AccountNotFoundException("No accounts found");
        }
        return accounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount retrieveOneAccount(@PathVariable(name = "id") String accountId ) {
        Optional<BankAccount> account = accountRepository.findById(accountId);
        Customer customer = customerRestClient.RetrieveOneCustomer(account.get().getCustomerId());
        if (!account.isPresent()) {
            throw new AccountNotFoundException("This account with accountId " + accountId + " not found");
        }
        account.get().setCustomer(customer);
        return account.get();
    }
}