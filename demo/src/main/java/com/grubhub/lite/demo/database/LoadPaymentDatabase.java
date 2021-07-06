package com.grubhub.lite.demo.database;

import com.grubhub.lite.demo.models.Enums;
import com.grubhub.lite.demo.models.Payment;
import com.grubhub.lite.demo.repositories.DriverRepository;
import com.grubhub.lite.demo.repositories.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadPaymentDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadPaymentDatabase.class);

    @Bean
    CommandLineRunner initPaymentDB(PaymentRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Payment(Enums.PaymentType.CreditCard, Enums.PaymentStatus.Completed)) );
            log.info("Preloading " + repository.save(new Payment(Enums.PaymentType.ApplePay, Enums.PaymentStatus.Completed)) );
            log.info("Preloading " + repository.save(new Payment(Enums.PaymentType.GooglePay, Enums.PaymentStatus.Completed)) );
            log.info("Preloading " + repository.save(new Payment(Enums.PaymentType.CreditCard, Enums.PaymentStatus.Declined)) );
            log.info("Preloading " + repository.save(new Payment(Enums.PaymentType.CreditCard, Enums.PaymentStatus.InProgress)) );
            log.info("Preloading " + repository.save(new Payment(Enums.PaymentType.ApplePay, Enums.PaymentStatus.Error)) );
            log.info("Preloading " + repository.save(new Payment(Enums.PaymentType.GooglePay, Enums.PaymentStatus.Declined)) );
            log.info("Preloading " + repository.save(new Payment(Enums.PaymentType.CreditCard, Enums.PaymentStatus.Completed)) );

        };
    }
}
