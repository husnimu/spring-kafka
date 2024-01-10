package id.co.jamkrindo.backend.model.dto.request;

import lombok.Data;

@Data
public class PostRequest {
  private String title, description, createdAt;
}
