package sai.service.JmsProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(EmailChannel.class)
@SpringBootApplication
public class JmsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsProducerApplication.class, args);
	}

}
