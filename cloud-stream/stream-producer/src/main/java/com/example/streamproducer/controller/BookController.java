package com.example.streamproducer.controller;

import com.example.streamproducer.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    @Qualifier(value = "output")
    MessageChannel messageChannel;

    @PostMapping(value = "/publish")
    public Book publishEvent(@RequestBody Book book) {
        messageChannel.send(MessageBuilder.withPayload(book).build());
        return book;
    }

    @PostMapping(value = "/books")
    @SendTo(Source.OUTPUT)
    public Book books(@RequestBody Book book) {
        return book;
    }
}
