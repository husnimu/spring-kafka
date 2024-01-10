package id.co.jamkrindo.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.jamkrindo.backend.model.Post;
import id.co.jamkrindo.backend.model.dto.request.PostRequest;
import id.co.jamkrindo.backend.service.PostService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PostController {
  PostService postService;

  @GetMapping
  public List<Post> getAll() {
    return postService.getAll();
  }

  @GetMapping("/{id}")
  public Post getById(@PathVariable int id) {
    return postService.getById(id);
  }

  @PostMapping
  public Post insert(@RequestBody PostRequest postRequest) {
    return postService.insert(postRequest);
  }

  @PutMapping("/{id}")
  public Post update(@PathVariable int id, @RequestBody PostRequest postRequest) {
    return postService.update(id, postRequest);
  }

  @DeleteMapping("/{id}")
  public Post delete(@PathVariable int id) {
    return postService.delete(id);
  }

}
