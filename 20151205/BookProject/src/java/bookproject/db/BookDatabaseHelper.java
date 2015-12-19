/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookproject.db;

import bookproject.domain.Author;
import bookproject.domain.Book;
import bookproject.domain.Publisher;
import bookproject.util.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class BookDatabaseHelper {

    private Database db;

    public BookDatabaseHelper(Database db) {
        this.db = db;
    }

    public List<Publisher> getPublisherList() {
        List<Publisher> publishers = new ArrayList<Publisher>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = db.connect();
            st = con.createStatement();
            rs = st.executeQuery("select id, name, address, email from publisher where status = 'a'");
            while (rs.next()) {
                Publisher p = new Publisher();
                p.setId(rs.getBigDecimal("id"));
                p.setName(rs.getString("name"));
                p.setAddress(rs.getString("address"));
                p.setEmail(rs.getString("email"));
                publishers.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error during getting publisher list " + e.getMessage());
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, st, con);
        }

        return publishers;
    }

    public Publisher getPublisher(int id) {
        Publisher publisher = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = db.connect();
            ps = con.prepareStatement("select id, name, address, email from publisher where status = 'a' and id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                publisher = new Publisher();
                publisher.setId(rs.getBigDecimal("id"));
                publisher.setName(rs.getString("name"));
                publisher.setAddress(rs.getString("address"));
                publisher.setEmail(rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("Error during getting publisher  " + e.getMessage());
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, con);
        }

        return publisher;
    }

    public List<Book> getBookListByPublisher(int publisherId) {
        List<Book> bookList = new ArrayList<Book>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = db.connect();
            ps = con.prepareStatement("select id, title, price, page_count from book where status = 'a' and publisher_id = ?");
            ps.setInt(1, publisherId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Book p = new Book();
                p.setId(rs.getBigDecimal("id"));
                p.setTitle(rs.getString("title"));
                p.setPrice(rs.getBigDecimal("price"));
                p.setPageCount(rs.getInt("page_count"));
                bookList.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error during getting book list by publisher " + e.getMessage());
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, con);
        }

        return bookList;
    }

    public Book getBook(int bookId) {
        Book book = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = db.connect();
            String sql = "select b.id book_id, "
                    + "  a.id author_id, "
                    + "  a.name author_name, "
                    + "  a.surname author_surname, "
                    + "  b.isbn, b.title, "
                    + "  b.rating, "
                    + "  b.genre genre_id, "
                    + "  g.name genre_name, "
                    + "  b.price, "
                    + "  b.cover, "
                    + "  b.page_count, "
                    + "  b.publish_date, "
                    + "  b.language language_id, "
                    + "  lg.name language_name, "
                    + "  b.description, "
                    + "  p.id publisher_id, p.name publisher_name "
                    + "from book b join publisher p on b.publisher_id = p.id "
                    + "  and b.status = 'a' and p.status = 'a' "
                    + "  join genre g on b.genre = g.id and g.status = 'a' "
                    + "  join language lg on b.language = lg.id and lg.status = 'a' "
                    + "  join book_author ba on b.id = ba.book_id and ba.status = 'a' "
                    + "  join author a on ba.author_id = a.id and a.status = 'a' "
                    + "where b.id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);
            rs = ps.executeQuery();
            if (rs.next()) {
                book = new Book();
                book.setId(rs.getBigDecimal("book_id"));
                book.setTitle(rs.getString("title"));
                book.setCover(rs.getString("cover"));
                book.setDescription(rs.getString("description"));
                book.getGenre().setId(rs.getBigDecimal("genre_id"));
                book.getGenre().setName(rs.getString("genre_name"));
                book.setIsbn(rs.getString("isbn"));
                book.getLanguage().setId(rs.getBigDecimal("language_id"));
                book.getLanguage().setName(rs.getString("language_name"));
                book.setPageCount(rs.getInt("page_count"));
                book.setPrice(rs.getBigDecimal("price"));
                book.setPublishDate(new java.util.Date(rs.getTimestamp("publish_date").getTime()));
                book.getPublisher().setId(rs.getBigDecimal("publisher_id"));
                book.getPublisher().setName(rs.getString("publisher_name"));
                book.getAuthorList().add(new Author(rs.getBigDecimal("author_id"), rs.getString("author_name"), rs.getString("author_surname")));
            }

        } catch (Exception e) {
            System.out.println("Error getting book id = " + bookId);
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, con);
        }

        return book;
    }

    public Author getAuthor(int authorId) {
        Author author = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {//BigDecimal id, String name, String surname
            con = db.connect();
            String sql = "select * from author where id=? and status='a'";
            ps = con.prepareStatement(sql);
            ps.setInt(1, authorId);
            rs = ps.executeQuery();
            if (rs.next()){
                author = new Author(rs.getBigDecimal("id"),rs.getString("name"),rs.getString("surname"));
                author.setEmail(rs.getString("email"));
                author.setAbout(rs.getString("about"));
            }
        } catch (Exception e) {
            System.out.println("Can't get an author. id = " + authorId);
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, con);
        }

        return author;
    }

}
