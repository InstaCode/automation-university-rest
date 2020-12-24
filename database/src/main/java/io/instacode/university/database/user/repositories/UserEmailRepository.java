package io.instacode.university.database.user.repositories;

import io.instacode.university.database.user.models.UserEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEmailRepository extends JpaRepository<UserEmail, Long> {
}