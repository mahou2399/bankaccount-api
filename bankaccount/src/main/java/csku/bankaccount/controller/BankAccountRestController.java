package csku.bankaccount.controller;

import org.springframework.web.bind.annotation.*;
import csku.bankaccount.data.BankAccountRepository;
import csku.bankaccount.model.BankAccount;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountRestController {

    private BankAccountRepository repository;

    public BankAccountRestController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customer/{customerId}")
    public List<BankAccount> getAllCustomerId(@PathVariable int customerId) {
        return repository.findByCustomerId(customerId);
    }

    @GetMapping
    public List<BankAccount> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getOne(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount){
        repository.save(bankAccount);
        return bankAccount;
    }

//    @PutMapping("/{id}")
//    public BankAccount update(@PathVariable int id,
//                              @RequestBody BankAccount bankAccount) {
//        BankAccount record = repository.findById(id).get();
//        record.setBalance(bankAccount.getBalance());
//        repository.save(record);
//        return record;
//    }

    @DeleteMapping("/{id}")
    public BankAccount delete(@PathVariable int id) {
        BankAccount record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }

//    Deposit
    @PutMapping("/deposit-{id}")
    public BankAccount deposit(@PathVariable int id,
                              @RequestBody BankAccount bankAccount) {
        BankAccount record = repository.findById(id).get();
        record.setBalance(bankAccount.getBalance() + record.getBalance());
        repository.save(record);
        return record;
    }
//    Deposit

//    withdraw
    @PutMapping("/withdraw-{id}")
    public BankAccount withdraw(@PathVariable int id,
                               @RequestBody BankAccount bankAccount) {
        BankAccount record = repository.findById(id).get();
        record.setBalance(record.getBalance() - bankAccount.getBalance());
        repository.save(record);
        return record;
    }
//    withdraw
}
