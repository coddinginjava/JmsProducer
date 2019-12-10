package sai.service.JmsProducer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmailChannel {

    @Output("email-output")
    MessageChannel publishMessage();
}
