package io.instacode.university.database.user.models;

import io.instacode.university.database.BaseEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "User")
@Entity
public class User extends BaseEntity {

  @Column(name = "first_name", length = 50)
  private String firstName;

  @Column(name = "last_name", length = 50)
  private String lastName;

  @OneToOne
  @JoinColumn(name = "address_id")
  private UserAddress address;

  @OneToOne
  @JoinColumn(name = "user_email_id")
  private UserEmail userEmail;

  @Column(name = "username", length = 16)
  private String username;

  @Column(name = "password", length = 25)
  private String password;

  @JoinTable(name = "USER_ROLE_LINK", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
  @ManyToMany
  private List<Role> roles;

}
