package io.instacode.university.database;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;


@MappedSuperclass
public class BaseEntity {

  @Id
  @Getter
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;
}