package customer;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudulentCustomer()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
