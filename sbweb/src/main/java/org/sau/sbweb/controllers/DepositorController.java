package org.sau.sbweb.controllers;

import org.sau.sbweb.models.Account;
import org.sau.sbweb.models.Customer;
import org.sau.sbweb.models.Depositor;
import org.sau.sbweb.repositories.AccountRepository;
import org.sau.sbweb.repositories.CustomerRepository;
import org.sau.sbweb.repositories.DepositorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DepositorController {
    @Autowired
    private DepositorRepository depositorRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/depositors")
    public String getIndex(Model model) {
        List<Depositor> depositorList = depositorRepository.findAll();
        model.addAttribute("depositorList", depositorList);
        return "depositor/index";
    }

    @GetMapping("/depositor/add")
    public String addDepositor(Model model) {
        Depositor depositor = new Depositor();
        model.addAttribute("depositor", depositor);
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("accounts", accountRepository.findAll());
        return "depositor/add";
    }

    @PostMapping("/depositor/add")
    public String depositorAdd(@ModelAttribute("depositor") Depositor depositor) {
        depositorRepository.save(depositor);
        return "redirect:/depositors";
    }

    @GetMapping("/depositor/update/{id}")
    public String updateDepositor(@PathVariable Long id, Model model) { // Long id kullan
        Optional<Depositor> depositor = depositorRepository.findById(id);
        model.addAttribute("depositor", depositor.orElse(null));
        return "depositor/update";
    }

    @PostMapping("/depositor/update")
    public String depositorUpdate(@ModelAttribute("depositor") Depositor depositor) {
        depositorRepository.save(depositor);
        return "redirect:/depositors";
    }

    @PostMapping("/depositor/delete/{id}")
    public String depositorDelete(@PathVariable Long id) { // Long id kullan
        depositorRepository.deleteById(id);
        return "redirect:/depositors";
    }
}