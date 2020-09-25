package csku.bankaccount.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import csku.bankaccount.model.BankAccount;

import java.util.List;

@Repository
public interface BankAccountRepository extends
        JpaRepository<BankAccount,Integer> {

    List<BankAccount> findByCustomerId(int customerId);
}

