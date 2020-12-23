package io.instacode.university.database.user.repositories;

import io.instacode.university.database.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}