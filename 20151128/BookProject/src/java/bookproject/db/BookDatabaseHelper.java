/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookproject.db;

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

}
