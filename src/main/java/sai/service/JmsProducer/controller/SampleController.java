package sai.service.JmsProducer.controller;


import lombok.AllArgsConstructor;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sai.service.JmsProducer.EmailChannel;
import sai.service.JmsProducer.model.Employee;

@RestController
@RequestMapping("/emp")
@AllArgsConstructor
public class SampleController {


    private EmailChannel emailChannel;

    @PostMapping
    public String postItInRabbitMq(@RequestBody Employee employee) {
        System.out.println("employee from rest call = " + employee.toString());
        emailChannel.publishMessage().send(MessageBuilder.withPayload(employee).setHeader("type","email_sending").build());
        return "successfully published in topic";
    }
}
