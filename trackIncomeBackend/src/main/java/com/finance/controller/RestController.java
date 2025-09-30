package com.finance.controller;

import com.finance.config.CustomeUserDetails;
import com.finance.model.*;
import com.finance.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private BudgetsService budgetsService;

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private BillsService billsService;

    @Autowired
    private PotsService potsService;

    @Autowired
    private UserService userService;

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(){
        return transactionService.getall();
    }

    @PostMapping("/addTransaction")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return  transactionService.insert(transaction);
    }

    @GetMapping("/budgets")
    public List<Budget> getBudget(){
        return budgetsService.getall();
    }

    @PostMapping("/addBudget")
    public Budget insertBudget(@RequestBody Budget budget){
        return budgetsService.insert(budget); }

    @GetMapping("/income")
    public List<Income> getIncome(){
        return incomeService.getall();
    }

    @GetMapping("/bills")
    public List<Bills> getBills(){
        return billsService.getall();
    }

    @GetMapping("/pots")
    public List<Pots> getPots(){
        return potsService.getall();
    }

    @PostMapping("/addPot")
    public Pots insertPot(@RequestBody Pots pots){
        return potsService.insert(pots);
    }

    @PutMapping("/addMoney/{potaddmoney}/{id}")
    public Pots addmoney(@PathVariable int potaddmoney ,@PathVariable int id){
        return potsService.addmoney(potaddmoney,id);
    }

    @PutMapping("/withdraw/{potwithdrawmoney}/{id}")
    public Pots withdraw(@PathVariable int potwithdrawmoney ,@PathVariable int id){
        return potsService.withdraw(potwithdrawmoney,id);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/username")
    public String getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return null;
    }


    @GetMapping("/user/profile")
    public User getProfile() {
        CustomeUserDetails principal = (CustomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof CustomeUserDetails) {
            return principal.getUser();
        }
        return null;
    }



}
