package com.example.productservice.extractor;

import com.example.productservice.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@Service
@EnableBinding(value = Source.class)
@Slf4j
public class ProductExtractorService {

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "2"))
    public MessageSource<List<Product>> pullProducts() {
        List<Product> products = Stream.of(new Product(1, "Mobile", 10000), new Product(2, "Laptop", 120000), new Product(3, "Book", 4320)).collect(Collectors.toList());
        log.info("Products: {}", products);
        return () -> MessageBuilder.withPayload(products).build();
    }

}
