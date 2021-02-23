package com.example.discountservice.service;

import com.example.discountservice.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@Slf4j
public class DiscountService {

    @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
    public List<Product> addDiscount(List<Product> products) {
        for (Product product : products) {
            if (product.getPrice() > 50000) {
                calculatePrice(product, 15);
            } else if (product.getPrice() > 8000) {
                calculatePrice(product, 10);
            } else if (product.getPrice() > 5000) {
                calculatePrice(product, 5);
            }
        }
        return products;
    }

    private Product calculatePrice(Product product, float percentage) {
        double actualPrice = product.getPrice();
        double discount = actualPrice * percentage / 100;
        product.setPrice(actualPrice - discount);
        log.info("Product Actual Price is {}, After Discount Total Price is {}", actualPrice, product.getPrice());
        return product;
    }
}
