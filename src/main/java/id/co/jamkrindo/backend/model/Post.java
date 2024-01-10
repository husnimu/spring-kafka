package id.co.jamkrindo.backend.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
  private int id;
  private String title, description;
  private LocalDateTime createdAt;
}
