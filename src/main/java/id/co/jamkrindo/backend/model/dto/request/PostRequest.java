package id.co.jamkrindo.backend.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostRequest {
  private String title, description, createdAt;
}
