package net.hosni.customerdataservice.web;


import lombok.AllArgsConstructor;
import net.hosni.customerdataservice.entities.Customer;
import net.hosni.customerdataservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {

    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("customers")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer); 
    }


}
