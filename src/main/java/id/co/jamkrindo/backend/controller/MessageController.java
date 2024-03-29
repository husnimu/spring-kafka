package id.co.jamkrindo.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.jamkrindo.backend.model.dto.request.MessageRequest;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {
  @Autowired
  private KafkaTemplate<String, Object> kafkaTemplate;

  @PostMapping
  public void publish(@RequestBody MessageRequest request) {
    kafkaTemplate.send("topic", request);
  }
}
