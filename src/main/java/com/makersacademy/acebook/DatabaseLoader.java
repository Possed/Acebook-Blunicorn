package com.makersacademy.acebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

  private final PostRepository postRepository;
  private final UserRepository userRepository;

  @Autowired
  public DatabaseLoader(PostRepository postRepository, UserRepository userRepository) {
  	this.postRepository = postRepository;
  	this.userRepository = userRepository;
  }


  @Override
  public void run(String... strings) throws Exception {
      this.postRepository.deleteAll();
  	  this.postRepository.save(new Post("Hey, folks! Welcome to Acebook!"));
      this.userRepository.deleteAll();
  	  this.userRepository.save(new User("user1", "hell@he.com", "passywordy"));
  }

}
