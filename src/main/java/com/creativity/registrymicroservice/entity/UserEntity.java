package com.creativity.registrymicroservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBL_USER")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -2785088955998032546L;

    @Id
    @Column(name = "UserName",unique = true, length = 45)
    @NotNull
    private String userName;

    @Column(name = "Password", length = 60)
    @NotNull
    private String password;

    @Column(name = "Enable")
    @NotNull
    private boolean enable;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserRoleEntity> userRole = new HashSet<UserRoleEntity>();

    public UserEntity(@NotNull String userName, @NotNull String password, @NotNull boolean enable) {
        this.userName = userName;
        this.password = password;
        this.enable = enable;
    }

    public UserEntity(@NotNull String userName, @NotNull String password, @NotNull boolean enable, Set<UserRoleEntity> userRole) {
        this.userName = userName;
        this.password = password;
        this.enable = enable;
        this.userRole = userRole;
    }

    public UserEntity(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<UserRoleEntity> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRoleEntity> userRole) {
        this.userRole = userRole;
    }
}
