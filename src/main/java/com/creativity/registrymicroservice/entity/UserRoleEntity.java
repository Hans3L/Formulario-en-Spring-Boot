package com.creativity.registrymicroservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "TBL_USER_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = {"Role", "UserName"}))
public class UserRoleEntity implements Serializable {

    private static final long serialVersionUID = 3635327124585144991L;

    @Id
    @Column(name = "UserRoleId", unique = true, nullable = false)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserName", nullable = false)
    private UserEntity user;

    @Column(name = "Role", length = 45)
    @NotNull
    private String role;

    public UserRoleEntity(){}

    public UserRoleEntity(UserEntity user, String role) {
        this.user = user;
        this.role = role;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
