package org.sau.sbweb.controllers;

import org.sau.sbweb.models.Account;
import org.sau.sbweb.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AccountController {
    @Autowired
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @GetMapping("/account")
    public String getIndex(Model model){
        Iterable<Account> accountList = accountRepository.findAll();
        model.addAttribute("accountList", accountList);
        return "account/index";
    }

    @GetMapping("/account/add")
    public String addAccount(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        return "account/addAccount";
    }
    @PostMapping("/account/add")
    public String accountAdd(@ModelAttribute("account") Account account){
        accountRepository.save(account);
        return "redirect:/account";
    }

    @GetMapping("/account/update/{aid}")
    public String updateAccount(@PathVariable int aid, Model model){
        Optional<Account> account = accountRepository.findById(aid);
        model.addAttribute("account", account);
        return "account/updateAccount";
    }

    @PostMapping("/account/update")
    public String accountUpdate(@ModelAttribute("account") Account account){
        accountRepository.save(account);
        return "redirect:/account";
    }




    @PostMapping("/account/delete/{id}") // POST isteği için eşleme
    public String deleteAccount(@PathVariable int id) {
        accountRepository.deleteById(id);
        return "redirect:/account";
    }

}
