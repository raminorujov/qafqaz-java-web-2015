package bookproject.domain;

import java.math.BigDecimal;

/**
 *
 * @author student
 */
public class Publisher extends BaseDomain {    
    private static final long serialVersionUID = 157489712456741L;
    private String name;
    private String address;
    private String email;

    public Publisher() {
        name = "";
        address = "";
        email = "";
    }

    public Publisher(BigDecimal id, String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }                
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Publisher{" + "id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + '}';
    }
    
}
