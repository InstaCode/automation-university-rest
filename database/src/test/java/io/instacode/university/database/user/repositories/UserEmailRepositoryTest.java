package io.instacode.university.database.user.repositories;

import io.instacode.university.database.user.models.UserEmail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserEmailRepositoryTest {

  @Autowired
  private UserEmailRepository userEmailRepository;

  @Test
  void testSave() {
    UserEmail userEmail = new UserEmail();
    userEmail.setEmailAddress("testmail@gmail.com");
    userEmailRepository.save(userEmail);
  }
}