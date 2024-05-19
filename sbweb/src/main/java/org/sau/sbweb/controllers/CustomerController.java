package org.sau.sbweb.controllers;

import org.sau.sbweb.models.Customer;
import org.sau.sbweb.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customer")
    public String getIndex(Model model){
        Iterable<Customer> customerList = customerRepository.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/index";
    }

    @GetMapping("/customer/add")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/addCustomer";
    }
    @PostMapping("/customer/add")
    public String customerAdd(@ModelAttribute("customer") Customer customer){
        customerRepository.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/customer/update/{id}")
    public String updateCustomer(@PathVariable int id, Model model){
        Optional<Customer> customer = customerRepository.findById(id);
        model.addAttribute("customer", customer);
        return "customer/updateCustomer";
    }

    @PostMapping("/customer/update")
    public String customerUpdate(@ModelAttribute("customer") Customer customer){
        customerRepository.save(customer);
        return "redirect:/customer";
    }



    @PostMapping("/customer/delete/{id}")
    public String showDeleteCustomerForm(@PathVariable int id) {
        customerRepository.deleteById(id);
        return "redirect:/customer";
        }





}
