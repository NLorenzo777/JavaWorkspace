package org.example.transactionaldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalDemoApplication.class, args);
    }

}
