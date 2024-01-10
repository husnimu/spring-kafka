package id.co.jamkrindo.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import id.co.jamkrindo.backend.model.Post;
import id.co.jamkrindo.backend.model.dto.request.PostRequest;
import id.co.jamkrindo.backend.repository.PostRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
  private PostRepository postRepository;

  public List<Post> getAll() {
    return postRepository.getAll();
  }

  public Post getById(int id) {
    return postRepository.getById(id);
  }

  public Post insert(PostRequest postRequest) {
    return postRepository.insert(postRequest);
  }

  public Post update(int id, PostRequest postRequest) {
    return postRepository.update(id, postRequest);
  }

  public Post delete(int id) {
    Post post = getById(id);
    if (post == null) {
      postRepository.delete(id);
    }
    return post;
  }
}
