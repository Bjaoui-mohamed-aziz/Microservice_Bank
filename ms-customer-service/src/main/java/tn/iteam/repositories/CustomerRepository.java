package tn.iteam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.iteam.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
