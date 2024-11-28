package tn.iteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.iteam.entities.BankAccount;

@Repository
public interface AccountRepository extends JpaRepository<BankAccount, String> {
}
