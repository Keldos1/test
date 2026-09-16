package org.example.test1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevPaymentService implements PaymentService {
    @Override
    public void pay(){
        System.out.println("DEV PAYMENT");
    }
}
