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
@Table(name = "User_Address")
@Entity
public class UserAddress extends BaseEntity {

  @Column(name = "ADDRESS_1")
  private String address1;

  @Column(name = "ADDRESS_2")
  private String address2;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STATE", length = 2)
  private String state;

  @Column(name = "ZIP", length = 5)
  private String zip;

  @Column(name = "DESCRIPTION")
  private String description;

}