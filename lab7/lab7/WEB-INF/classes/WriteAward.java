//Write.java

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WriteAward extends HttpServlet  
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Connection conn = null;
	// init function of the servlet
	public void init(ServletConfig config) throws ServletException
	{
		//Enter the connection details
        String hostname = "10.105.1.51";    // If PostgreSQL is running on some other machine enter the IP address of the machine here
        String username = "cs110050065"; // Enter your PostgreSQL username
        String password = "560050011"; // Enter your PostgreSQL password
        String dbName = "cs110050065"; // Enter the name of the database that has the university tables.
		String connectionUrl = "jdbc:postgresql://" + hostname +  "/" + dbName;
		try
		{
			conn = DriverManager.getConnection(connectionUrl,username, password);
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}

		super.init(config);
 	}

 	// POST REQUEST

 	public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws IOException, ServletException
    {

    	PreparedStatement ppt = null;
    	String pk = request.getParameter("pk");
    	String value = request.getParameter("value");
    	String name = request.getParameter("name");
    	if(name == null)
    	{	
    		name = " ";
    	}
    	if(pk == null)
    	{	
    		pk = " ";
    	}
    	if(value == null)
    	{	
    		value = " ";
    	}

    	String button = "";
    	button = request.getParameter("button");

    	if(name.contains("moviename"))
    	{
    		String q2 = "UPDATE movieawards SET moviename=? WHERE moviename=?";
    		try
        	{
    		   ppt = conn.prepareStatement(q2);
	    	   ppt.setString(1,value);
	    	   ppt.setString(2,pk);
	    	   ppt.executeUpdate();
		       response.sendRedirect("/lab7/writeaward.jsp");
        	}
	        catch(SQLException sqle)
	        {
	        	sqle.printStackTrace();
	        }

    	}
    	else if(name.contains("yoa"))
    	{
    		String q2 = "UPDATE movieawards SET yearofaward=? WHERE moviename=?";
    		try
        	{
    			ppt = conn.prepareStatement(q2);
	    	   ppt.setLong(1,Integer.parseInt(value));
	    	   ppt.setString(2,pk);
	    	   ppt.executeUpdate();
	    	   response.sendRedirect("/lab7/writeaward.jsp");

        	}
	        catch(SQLException sqle)
	        {
	        	sqle.printStackTrace();
	        }

    	}
    	else if(name.contains("awrdname"))
    	{
    		String q2 = "UPDATE movie SET awardname=? WHERE moviename=?";
    		try
        	{
    			ppt = conn.prepareStatement(q2);
	    	   ppt.setString(1,value);
	    	   ppt.setString(2,pk);
	    	   ppt.executeUpdate();
	    	   response.sendRedirect("/lab7/writeaward.jsp");
        	}
	        catch(SQLException sqle)
	        {
	        	sqle.printStackTrace();
	        }

    	}
        else if(button.equals("add"))
        {
            String moviename = request.getParameter("moviename");
            String yoa      =request.getParameter("yoa");
            String awardname = request.getParameter("awardname");

            String q1 = "INSERT INTO MOVIEAWARDS VALUES(?,?,?)";
            try
            {
                ppt = conn.prepareStatement(q1);
                ppt.setString(1,moviename);
                ppt.setLong(2,Integer.parseInt(yoa));
                ppt.setString(3,awardname);
                ppt.executeUpdate();
                response.sendRedirect("/lab7/writeaward.jsp");

            }
            catch(SQLException sqle)
            {
                sqle.printStackTrace();
                response.sendRedirect("/lab7/writeaward.jsp?err=1");

            }

        }
    	else if(!button.equals(""))
    	{
    		String q3 = "DELETE FROM movieawards WHERE moviename=?";
    		try
    		{
    			ppt = conn.prepareStatement(q3);
    			ppt.setString(1,button);
    			ppt.executeUpdate();
    		}
    		catch(SQLException sqle)
    		{
    			sqle.printStackTrace();

    		}
            response.sendRedirect("/lab7/writeaward.jsp");

/*    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<html><meta http-equiv=\"refresh\" content=\"0; url=/lab7/write.jsp\"></html>")
*/    		
    	}

    }


}
