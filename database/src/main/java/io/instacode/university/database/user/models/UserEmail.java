package io.instacode.university.database.user.models;

import io.instacode.university.database.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "User_Email")
@Entity
public class UserEmail extends BaseEntity {

  @Column(name = "email_address", length = 50)
  private String emailAddress;

}