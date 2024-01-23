package id.co.jamkrindo.backend.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import id.co.jamkrindo.backend.model.dto.request.MessageRequest;
import id.co.jamkrindo.backend.model.dto.request.PostRequest;
import id.co.jamkrindo.backend.service.PostService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class KafkaListeners {
  PostService postService;

  @KafkaListener(topics = "topic", groupId = "groupId")
  void generalListener(MessageRequest data) {
    System.out.println("listener : " + data.getTost());
    postService.insert(new PostRequest("title", "deskripsi", null));
  }
}