package com.example.streamconsumer.service;

import com.example.streamconsumer.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class NotificationService {

    @StreamListener(target = Sink.INPUT)
    public void notifyUsers(Book book) {
        log.info("New Book Published " + book);
    }
}
