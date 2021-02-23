package com.example.streamconsumer.service;

import com.example.streamconsumer.entity.Book;
import com.example.streamconsumer.messaging.PublicationProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
@Slf4j
public class NotificationService {

    @StreamListener(target = Sink.INPUT)
    @SendTo(PublicationProcessor.OUTPUT)
    public Book notifyUsers(Book book) {
        log.info("New Book Published " + book);
        book.setName(book.getName().toUpperCase(Locale.ROOT));
        return book;
    }
}
