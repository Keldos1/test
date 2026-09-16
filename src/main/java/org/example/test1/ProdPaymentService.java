package org.example.test1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdPaymentService implements PaymentService{
    @Override
    public void pay(){
        System.out.println("PROD PAYMENT");
    }
}
