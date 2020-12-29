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
public class Address extends BaseEntity {


  private String address1;


  private String address2;


  private String city;

  @Column(length = 2)
  private String state;

  @Column(length = 5)
  private String zip;

  private String description;

}