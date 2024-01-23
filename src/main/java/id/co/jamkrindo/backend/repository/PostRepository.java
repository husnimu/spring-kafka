package id.co.jamkrindo.backend.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.server.ResponseStatusException;

import id.co.jamkrindo.backend.model.Post;
import id.co.jamkrindo.backend.model.dto.request.PostRequest;
import id.co.jamkrindo.backend.util.DateTimeUtil;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PostRepository {
  private JdbcTemplate jdbcTemplate;
  private TransactionTemplate transactionTemplate;

  public List<Post> getAll() {
    String sql = "SELECT * FROM post";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
  }

  public Post getById(int id) {
    String sql = "SELECT * FROM post WHERE id = ?";
    return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<>(Post.class));
  }

  public Post insert(PostRequest postRequest) {
    return transactionTemplate.execute(status -> {
      try {
        String sql = "INSERT INTO post(title, description, created_at) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator psc = connection -> {
          var ps = connection.prepareStatement(sql, new String[] { "id" });
          ps.setString(1, postRequest.getTitle());
          ps.setString(2, postRequest.getDescription());
          ps.setString(3, postRequest.getCreatedAt());
          return ps;
        };
        jdbcTemplate.update(psc, keyHolder);
        Post post = new Post();
        post.setId(keyHolder.getKey().intValue());
        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        post.setCreatedAt(DateTimeUtil.stringToLocalDateTime(postRequest.getCreatedAt()));
        return post;
      } catch (DataAccessException e) {
        status.setRollbackOnly();
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to insert post", e);
      }
    });
  }

  public Post update(int id, PostRequest postRequest) {
    String sql = "UPDATE post SET title = ?, description = ?, created_at = ? WHERE id = ?";

    int rowsAffected = jdbcTemplate.update(sql, postRequest.getTitle(),
        postRequest.getDescription(),
        postRequest.getCreatedAt(),
        id);

    if (rowsAffected > 0) {
      Post post = new Post();
      post.setId(id);
      post.setTitle(postRequest.getTitle());
      post.setDescription(postRequest.getDescription());
      post.setCreatedAt(DateTimeUtil.stringToLocalDateTime(postRequest.getCreatedAt()));
      return post;
    } else {
      return null;
    }
  }

  public void delete(int id) {
    String deleteSql = "DELETE FROM post WHERE id = ?";
    jdbcTemplate.update(deleteSql, id);
  }
}
