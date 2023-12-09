package net.hosni.customerdataservice.web;


import lombok.AllArgsConstructor;
import net.hosni.customerdataservice.entities.Customer;
import net.hosni.customerdataservice.repository.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {

    private CustomerRepository customerRepository;

    @QueryMapping
    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id){
        Customer customer=customerRepository.findById(id).orElse(null);
        if(customer==null) throw new RuntimeException(String.format("Customer %d not found",id));
        return customer;

    }
}
