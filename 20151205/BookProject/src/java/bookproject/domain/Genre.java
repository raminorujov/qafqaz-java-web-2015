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
public class Genre extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 2178784565783L; 
    private String name;

    public Genre(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {
        this.id = BigDecimal.ZERO;
        this.name = "";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{id=" + id + ", name=" + name + '}';
    }
    
}
