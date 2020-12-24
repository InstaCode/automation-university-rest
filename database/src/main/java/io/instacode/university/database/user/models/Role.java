package io.instacode.university.database.user.models;

import io.instacode.university.database.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Role")
@Entity
public class Role extends BaseEntity {

  @Column(name = "role_name", length = 5)
  private String roleName;

  @Column(name = "role_full_name", length = 15)
  private String roleFullName;

}