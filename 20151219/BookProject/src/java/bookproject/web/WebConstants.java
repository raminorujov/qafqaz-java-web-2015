/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.web;

/**
 *
 * @author student
 */
public class WebConstants {
    public static final String PAGE_TEST="/WEB-INF/view/test.jsp"; 
    public static final String PAGE_ERROR = "/WEB-INF/view/common/error.jsp";
    
    public static final String PAGE_PUBLISHER_LIST="/WEB-INF/view/publisher/list.jsp"; 
    public static final String PAGE_PUBLISHER="/WEB-INF/view/publisher/view.jsp"; 
    public static final String PAGE_ADD_PUBLISHER="/WEB-INF/view/publisher/add.jsp"; 

//    public static final String PAGE_BOOK="/WEB-INF/view/book/view.jsp"; 
    public static final String PAGE_BOOK="/WEB-INF/view/book/view_jstl.jsp";
    public static final String PAGE_AUTHOR="/WEB-INF/view/author/view.jsp"; 
    public static final String PAGE_ADMIN_DASHBOARD="/WEB-INF/view/admin/dashboard.jsp"; 
    public static final String PAGE_USER_DASHBOARD="/WEB-INF/view/user/dashboard.jsp"; 
    public static final String PAGE_LOGIN="login.jsp"; 
    
    
    
   
    public static final String ATTR_ERROR_LIST="errorList"; 
    public static final String ATTR_PUBLISHER_LIST="publisherList"; 
    public static final String ATTR_PUBLISHER="publisher"; 
    public static final String ATTR_PUBLISHER_BOOKS="publisherBooks"; 
    public static final String ATTR_BOOK="book";
    public static final String ATTR_AUTHOR="author"; 
    public static final String ATTR_USER="user"; 
    public static final String ATTR_LOGIN_TIME="loginTime"; 
    
    public static final String ACTION_TEST="test"; 
    public static final String ACTION_SHOW_PUBLISHER_LIST="showPublisherList"; 
    public static final String ACTION_VIEW_PUBLISHER="viewPublisher"; 
    public static final String ACTION_VIEW_BOOK="viewBook"; 
    public static final String ACTION_VIEW_AUTHOR="viewAuthor"; 
    
   
   
}
