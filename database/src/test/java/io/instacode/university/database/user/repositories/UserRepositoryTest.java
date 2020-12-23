package io.instacode.university.database.user.repositories;

import com.github.javafaker.Faker;
import io.instacode.university.database.user.builder.UserBuilder;
import io.instacode.university.database.user.models.User;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  void testFindById() {
  }

  @Test
  void testCount() {
  }

  @Test
  void testDeleteById() {
  }

  @Test
  void testDelete() {
  }

  @Test
  void testSave() {

    Faker faker = new Faker(Locale.ENGLISH);
    UserBuilder userBuilder = UserBuilder.anUser().withFirstName(faker.name().firstName()).withLastName(faker.name().lastName());
    userBuilder.withUsername(faker.name().username()).withPassword(faker.internet().password());
    User user = userBuilder.build();

    userRepository.save(user);
  }
}