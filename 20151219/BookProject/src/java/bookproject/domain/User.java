/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author student
 */
public class User extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 14878129436787L;
    
    private String username;
    private String name;
    private String surname;
    private String password;
    private String email;
    private ArrayList<Role> userRoles;

    public User() {
        this.username = "";
        this.name = "";
        this.surname = "";
        this.password = "";
        this.email = "";
        this.userRoles = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", name=" + name + ", surname=" + surname + ", password=" + password + ", userRoles=" + userRoles + '}';
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(ArrayList<Role> userRoles) {
        this.userRoles = userRoles;
    }
    
    
    
}
