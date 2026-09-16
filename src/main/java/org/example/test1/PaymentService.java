package org.example.test1;

import org.springframework.stereotype.Service;

public interface PaymentService {
    void pay();

    @Service
    class OrderService {

        private final PaymentService paymentService;

        public OrderService(PaymentService paymentService) {
            this.paymentService = paymentService;
        }

        public void createOrder() {
            paymentService.pay();
        }
    }
}
