package com.gmail.clarkin200.MutaphekApp.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gmail.clarkin200.MutaphekApp.entity.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @NotNull
    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "avatar")
    private byte [] avatar;

    @Column(name = "name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @Column(name = "active")
    private boolean active;

    @JsonIgnoreProperties
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id",
                    referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id",
                    referencedColumnName = "id")
            }
    )
    private List<Role> roles = new ArrayList<>();

    public User(Long id, String email, String password, byte[] avatar,
                String name, String bio, List<Role> roles,boolean active) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.name = name;
        this.bio = bio;
        this.roles = roles;
        this.active = active;
    }

    public User(){}

    @PrePersist
    private void activateUser(){
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.deepEquals(avatar, user.avatar) && Objects.equals(name, user.name) && Objects.equals(bio, user.bio) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, Arrays.hashCode(avatar), name, bio, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'';
    }
}
