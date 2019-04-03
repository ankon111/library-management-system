package com.vivacom.library.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Ankon on 10/17/2017.
 */
@Entity
@Table(name = "user")
public class ApplicationUser implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "{applicationuser.username.empty}")
    @NotNull(message = "{applicationuser.username.empty}")
    @Size(max = 45,message = "{applicationuser.username.maximum}")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "{applicationuser.password.empty}")
    @NotNull(message = "{a.pplicationuser.password.empty}")
    @Column(name = "password")
    @Size(max = 200,message = "{applicationuser.password.maximum}")
    private String password;


    @Column(name = "fullname")
    @NotNull(message = "{applicationuser.fullname.empty}")
    @NotEmpty(message = "{applicationuser.fullname.empty}")
    private String fullname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
