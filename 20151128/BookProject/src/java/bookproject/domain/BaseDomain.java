/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author student
 */
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = 148781245787L;        
    
    protected BigDecimal id;
    protected char status;
    
    public BaseDomain() {
        this.id = new BigDecimal(BigInteger.ZERO);
        this.status = 'd';
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaseDomain{" + "id=" + id + ", status=" + status + '}';
    }        
}
