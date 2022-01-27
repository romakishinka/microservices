package com.amigoscode.clients.fraud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FraudCheckResponse {
    private boolean isFraudulentCustomer;
}
