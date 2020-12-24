package io.instacode.university.database.user.builder;

import io.instacode.university.database.user.models.Role;
import io.instacode.university.database.user.models.User;
import io.instacode.university.database.user.models.UserAddress;
import io.instacode.university.database.user.models.UserEmail;
import java.util.List;

public final class UserBuilder {
  private String firstName;
  private String lastName;
  private UserAddress address;
  private UserEmail userEmail;
  private String username;
  private String password;
  private List<Role> roles;

  private UserBuilder() {
  }

  public static UserBuilder anUser() {
    return new UserBuilder();
  }

  public UserBuilder withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public UserBuilder withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public UserBuilder withAddress(UserAddress address) {
    this.address = address;
    return this;
  }

  public UserBuilder withUserEmail(UserEmail userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  public UserBuilder withUsername(String username) {
    this.username = username;
    return this;
  }

  public UserBuilder withPassword(String password) {
    this.password = password;
    return this;
  }

  public UserBuilder withRoles(List<Role> roles) {
    this.roles = roles;
    return this;
  }

  public User build() {
    User user = new User();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setAddress(address);
    user.setUserEmail(userEmail);
    user.setUsername(username);
    user.setPassword(password);
    user.setRoles(roles);
    return user;
  }
}
