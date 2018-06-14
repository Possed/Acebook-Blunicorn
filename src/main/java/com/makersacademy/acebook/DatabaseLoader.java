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
      Post post = new Post("Hey, folks! Welcome to Acebook!");
  	  Comment com1 = new Comment("This is our first comment!");
      Comment com2 = new Comment("This is our second comment!");
      post.setUser(newUser);
      com1.setPost(post);
      com2.setPost(post);
      com1.setUser(newUser);
      com2.setUser(newUser);
      this.userRepository.save(newUser);
      this.postRepository.save(post);
      this.commentRepository.save(com1);
      this.commentRepository.save(com2);
  }

}
