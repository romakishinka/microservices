package com.microserbices.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping()
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        customerService.registerCustomer(customerRequest);
        log.info("new customer registration {}", customerRequest);
    }
}