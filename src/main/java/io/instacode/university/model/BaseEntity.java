package io.instacode.university.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@MappedSuperclass
public class BaseEntity implements AbstractEntity<Long>, Serializable {

  @Id
  @Getter
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;
}