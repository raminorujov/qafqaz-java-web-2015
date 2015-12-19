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
public class Language extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1378781495787L; 
    private String name;
    
    public Language(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public Language() {
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
        return "Language{id=" + id + ", name=" + name + '}';
    }    
    
}
