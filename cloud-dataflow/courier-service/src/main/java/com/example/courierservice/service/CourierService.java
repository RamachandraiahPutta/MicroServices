package com.example.courierservice.service;

import com.example.courierservice.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableBinding(value = Sink.class)
@Slf4j
public class CourierService {

    @StreamListener(value = Sink.INPUT)
    public void dispatchOrder(List<Product> products) {
        products.forEach(product -> {
            log.info("Product Dispatched to Your Mailing Address: {}", product);
        });
    }
}
