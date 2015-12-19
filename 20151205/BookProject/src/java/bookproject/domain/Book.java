/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookproject.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author student
 */
public class Book extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 8078787795780L;

    private String description;
    private int rating;
    private Genre genre;
    private String cover;
    private Publisher publisher;
    private Date publishDate;
    private Language language;
    private String isbn;
    private String title;
    private BigDecimal price;
    private int pageCount;
    private List<Author> authorList;

    public Book() {
        this.id = BigDecimal.ZERO;
        this.description = "";
        this.rating = 0;
        this.genre = new Genre();
        this.cover = "";
        this.publisher = new Publisher();
        this.publishDate = new Date();
        this.language = new Language();
        this.isbn = "";
        this.title = "";
        this.price = BigDecimal.ZERO;
        this.pageCount = 0;    
        this.authorList = new ArrayList<>();
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
        
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

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

    @Override
    public String toString() {
        return "Book{id=" + id + ", description=" + description + ", rating=" + rating + ", genre=" + genre + ", cover=" + cover + ", publisher=" + publisher + ", publishDate=" + publishDate + ", language=" + language + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", pageCount=" + pageCount + '}';
    }

}
