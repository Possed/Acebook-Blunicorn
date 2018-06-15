package com.makersacademy.acebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseLoader implements CommandLineRunner {

  private final PostRepository postRepository;
  private final CommentRepository commentRepository;
  private final UserRepository userRepository;

  @Autowired
  public DatabaseLoader(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
  	this.postRepository = postRepository;
  	this.userRepository = userRepository;
  	this.commentRepository = commentRepository;
  }

  @Override
  public void run(String... strings) throws Exception {
      this.postRepository.deleteAll();
      this.userRepository.deleteAll();
      this.commentRepository.deleteAll();
      User newUser = new User("admin", "admin@acebook.com", "password");
      this.userRepository.save(newUser);
  }

}
