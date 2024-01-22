package id.co.jamkrindo.backend.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import id.co.jamkrindo.backend.model.dto.request.MessageRequest;

@Component
public class KafkaListeners {
  @KafkaListener(topics = "topic", groupId = "groupId")
  void generalListener(MessageRequest data) {
    System.out.println("listener :" + data.getTost());
  }
}