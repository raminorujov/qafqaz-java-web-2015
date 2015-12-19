/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.db;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author student
 */
public class Database {
    
    public Connection connect() throws Exception {
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env/");
        DataSource ds = (DataSource)envContext.lookup("jdbc/book");
        Connection con = ds.getConnection();
        con.setAutoCommit(false);
        return con;
    }        
    
}
