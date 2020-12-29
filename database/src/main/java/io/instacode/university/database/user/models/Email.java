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
@Entity
public class Email extends BaseEntity {

  @Column(length = 50)
  private String emailAddress;

}