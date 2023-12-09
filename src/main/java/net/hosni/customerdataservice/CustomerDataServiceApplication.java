package net.hosni.customerdataservice;

import net.hosni.customerdataservice.entities.Customer;
import net.hosni.customerdataservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerDataServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("Amine").email("amine@gmail.com").build());
            customerRepository.save(Customer.builder().name("Omar").email("omar@gmail.com").build());
            customerRepository.save(Customer.builder().name("imane").email("imane@gmail.com").build());
        };
    }

}
