/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.domain;

import java.math.BigDecimal;

/**
 *
 * @author student
 */
public class Book extends BaseDomain {
    
    /*
     isbn, 
  title,
  description,
  rating,
  genre,
  price,
  cover,
  page_count,
  publisher_id,
  publish_date,
  language,
    */
    
   private String isbn;
   private String title;
   private BigDecimal price;
   private int pageCount;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
   
}
