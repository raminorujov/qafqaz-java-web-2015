/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.web;

import bookproject.db.BookDatabaseHelper;
import bookproject.db.Database;
import bookproject.web.action.BaseAction;
import bookproject.web.action.DefaultAction;
import bookproject.web.action.ShowPublisherList;
import bookproject.web.action.TestAction;
import bookproject.web.action.ViewAuthor;
import bookproject.web.action.ViewBook;
import bookproject.web.action.ViewPublisher;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author student
 */
@WebListener()
public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Web context is initialized");
        Database db = new Database();
        BookDatabaseHelper dbHelper = new BookDatabaseHelper(db);
        
        String configLocation = sce.getServletContext().getRealPath("/") + sce.getServletContext().getInitParameter("configLocation");
        System.out.println("configLocation = " + configLocation);

        ConfigurationReader reader = new ConfigurationReader(configLocation);
        ArrayList<ActionConfig> configList = reader.parse();
        ArrayList<BaseAction> actionList = new ArrayList();
        
         for(ActionConfig config : configList) {
            try {                
                BaseAction action = (BaseAction)(Class.forName(config.getClassName()).newInstance());
                action.setDbHelper(dbHelper);
                actionList.add(action);
            } catch (Exception ex) {
                new RuntimeException("Error creating action", ex);
            }
            
        }
        
        sce.getServletContext().setAttribute("actionList", actionList);
        
               
//        TestAction testAction = new TestAction();        
//        ShowPublisherList showPublisherList = new ShowPublisherList();
//        ViewPublisher viewPublisher = new ViewPublisher();
//        ViewBook viewBook = new ViewBook();
//        ViewAuthor viewAuthor = new ViewAuthor();
//        DefaultAction defaultAction = new DefaultAction();
//        
//        actionList.add(testAction);
//        actionList.add(showPublisherList);
//        actionList.add(viewPublisher);
//        actionList.add(viewBook);
//        actionList.add(viewAuthor);    
//        actionList.add(defaultAction);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Web context is destroyed");
    }
}
