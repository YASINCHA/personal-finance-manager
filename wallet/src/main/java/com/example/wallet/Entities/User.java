package com.example.wallet.Entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "USER_ID")
    private Long USER_ID;
    // @Column(unique = true)
    @Column(name = "username")

    private String username;
    @Column(name = "Password")

    private String Password;
   
   
    public User() {
   
    }
   
    public User(String username, String password) {
     super();
     this.username = username;
     this.Password = password;
     
    }
   
    public Long getId() {
     return USER_ID;
    }
   
    public void setId(Long id) {
     this.USER_ID = id;
    }
   
    public String getUsername() {
     return username;
    }
   
    public void setUsername(String username) {
     this.username = username;
    }
   
    public String getPassword() {
     return Password;
    }
   
    public void setPassword(String password) {
     this.Password = password;
    }
   
  
   
    @Override
    public String toString() {
     return "User [id=" + USER_ID + ", username=" + username + ", password=" + Password +  "]";
    }
}
