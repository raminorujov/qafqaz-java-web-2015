/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author student
 */
public class Author extends BaseDomain implements Serializable{
    private static final long serialVersionUID = 6548921245642012L;
    
    private String name;
    private String surname;
    private String email;
    private String about;

    public Author() {
       this.name = "";
       this.surname = "";
       this.email = "";
       this.about = "";
    }

    public Author(BigDecimal id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Author{" + "name=" + name + ", surname=" + surname + ", email=" + email + ", about=" + about + '}';
    }   
    
}
