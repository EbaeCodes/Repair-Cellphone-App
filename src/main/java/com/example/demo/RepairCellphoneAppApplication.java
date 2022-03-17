package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RepairCellphoneAppApplication {

    public static void main(String[] args) {
	SpringApplication.run(RepairCellphoneAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandlineRunner(CustomerRespository customerRepository) {
	return args -> {

	    customerRepository.findById(5L).ifPresentOrElse(System.out::println,
		    () -> System.out.println("Customer with ID 5 not found"));

	    customerRepository.findById(6L).ifPresentOrElse(System.out::println,
		    () -> System.out.println("Customer with ID 6 not found"));
	    List<Customer> cus = customerRepository.findAll();
	    cus.forEach(System.out::println);
	    // customerRepository.deleteById(5L);
	    // System.out.println(customerRepository.count());
	    customerRepository.findCustomerByEmail("marc@yahoo.com").ifPresentOrElse(System.out::println,
		    () -> System.out.println("Customer with email_address = 'marc@yahoo.com' not found"));

	    System.out.println("Printing customer by first name and sex");
	    customerRepository.findCustomerByFnameEqualsAndSexEquals("Ebere", "M").forEach(System.out::println);

	    System.out.println("Native sql");
	    customerRepository.SelectCustomerByFnameEqualsAndEmailEqualsNative("Ebere", "ebere@yahoo.com")
		    .forEach(System.out::println);
	    System.out.println("Deleting from the database");
	    customerRepository.deleteCustomerById(1L);

	};

    }
}
