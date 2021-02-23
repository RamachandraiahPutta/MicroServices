package com.example.streamconsumer.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PublicationProcessor {

    /**
     * OUTPUT channel name.
     */
    String OUTPUT = "publicationProcessor";

    /**
     * @return output channel.
     */
    @Input(PublicationProcessor.OUTPUT)
    MessageChannel output();
}
