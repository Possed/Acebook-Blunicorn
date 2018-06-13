package com.makersacademy.acebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

  private final PostRepository postRepository;
  private final CommentRepository commentRepository;

  @Autowired
  public DatabaseLoader(PostRepository postRepository, CommentRepository commentRepository) {
  	this.postRepository = postRepository;
  	this.commentRepository = commentRepository;
  }

  @Override
  public void run(String... strings) throws Exception {
      Post post = new Post("Hey, folks! Welcome to Acebook!");
      this.postRepository.deleteAll();
  	  this.postRepository.save(post);
  	  this.commentRepository.deleteAll();
  	  this.commentRepository.save(new Comment("This is our first comment!", post));
  }
}
