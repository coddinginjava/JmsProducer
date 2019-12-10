package sai.service.JmsProducer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sai.service.JmsProducer.model.Employee;

@RestController
@RequestMapping("/emp")
public class SampleController {

    @Autowired
    private Source source;

    @PostMapping
    public String postItInRabbitMq(@RequestBody Employee employee) {
        System.out.println("employee from rest call = " + employee.toString());
        source.output().send(MessageBuilder.withPayload(employee).build());
        return "successfully published in topic";
    }
}
