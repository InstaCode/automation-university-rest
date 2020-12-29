package io.instacode.university.database.user.repositories;

import io.instacode.university.database.user.models.Email;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

@SpringBootTest
class EmailRepositoryTest {

  @Autowired
  private UserEmailRepository userEmailRepository;

  @Test
  void testSave() {
    Email userEmail = new Email();
    userEmail.setEmailAddress("testmail@gmail.com");
    //userEmailRepository.save(userEmail);



    }



}