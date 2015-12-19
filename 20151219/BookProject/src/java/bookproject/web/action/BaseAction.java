package bookproject.web.action;

import bookproject.db.BookDatabaseHelper;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public abstract class BaseAction {    
    protected String name;
    protected String page;
    protected boolean forward;
    protected boolean output;
    protected ArrayList<String> errorList;
    protected BookDatabaseHelper dbHelper;

    public BaseAction() {
        this.output = false;
        this.errorList = new ArrayList<>();
    }        
    
    public abstract void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public BookDatabaseHelper getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(BookDatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    } 
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean isForward() {
        return forward;
    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }

    public boolean isOutput() {
        return output;
    }

    public void setOutput(boolean output) {
        this.output = output;
    }

    public ArrayList<String> getErrorList() {
        return errorList;
    }   

    @Override
    public String toString() {
        return "BaseAction{" + "name=" + name + '}';
    }
        
}
