//Write.java

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Write extends HttpServlet  
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
    		String q2 = "UPDATE movie SET moviename=? WHERE moviename=?";
    		try
        	{
    		   ppt = conn.prepareStatement(q2);
	    	   ppt.setString(1,value);
	    	   ppt.setString(2,pk);
	    	   ppt.executeUpdate();
		       response.sendRedirect("/lab7/write.jsp");
        	}
	        catch(SQLException sqle)
	        {
	        	sqle.printStackTrace();
	        }

    	}
    	else if(name.contains("yor"))
    	{
    		String q2 = "UPDATE movie SET yearofrelease=? WHERE moviename=?";
    		try
        	{
    			ppt = conn.prepareStatement(q2);
	    	   ppt.setLong(1,Integer.parseInt(value));
	    	   ppt.setString(2,pk);
	    	   ppt.executeUpdate();
	    	   response.sendRedirect("/lab7/write.jsp");

        	}
	        catch(SQLException sqle)
	        {
	        	sqle.printStackTrace();
	        }

    	}
    	else if(name.contains("Producer"))
    	{
    		String q2 = "UPDATE movie SET producer=? WHERE moviename=?";
    		try
        	{
    			ppt = conn.prepareStatement(q2);
	    	   ppt.setString(1,value);
	    	   ppt.setString(2,pk);
	    	   ppt.executeUpdate();
	    	   response.sendRedirect("/lab7/write.jsp");
        	}
	        catch(SQLException sqle)
	        {
	        	sqle.printStackTrace();
	        }

    	}
    	else if(name.contains("Director"))
    	{

    		String q2 = "UPDATE movie SET director=? WHERE moviename=?";
    		try
        	{
    			ppt = conn.prepareStatement(q2);
	    	   ppt.setString(1,value);
	    	   ppt.setString(2,pk);
	    	   ppt.executeUpdate();
	    	   response.sendRedirect("/lab7/write.jsp");
        	}
	        catch(SQLException sqle)
	        {
	        	sqle.printStackTrace();
	        }

    	}
        else if(button.equals("add"))
        {
            String moviename = request.getParameter("moviename");
            String yor      =request.getParameter("yor");
            String director = request.getParameter("Director");
            String producer = request.getParameter("Producer");
            String actor = request.getParameter("Actor");
            String[] actors = actor.split(",");
            String q2 = "INSERT INTO CASTINGS VALUES(?,?)";
            String q1 = "INSERT INTO MOVIE VALUES(?,?,?,?)";
            String q3 = "INSERT INTO MOVIEPERSON (NAME) VALUES(?)";
            try
            {
                ppt = conn.prepareStatement(q1);
                ppt.setString(1,moviename);
                ppt.setLong(2,Integer.parseInt(yor));
                ppt.setString(4,director);
                ppt.setString(3,producer);
                ppt.executeUpdate();
                for(int i = 0; i < actors.length; i++)
                {
                    ppt = conn.prepareStatement(q3);
                    ppt.setString(1,actors[i]);
                    ppt.executeUpdate();

                    
                    ppt = conn.prepareStatement(q2);
                    ppt.setString(1,moviename);
                    ppt.setString(2,actors[i]);
                    ppt.executeUpdate();
                }
                response.sendRedirect("/lab7/write.jsp");
            }
            catch(SQLException sqle)
            {
                sqle.printStackTrace();
                response.sendRedirect("/lab7/write.jsp?error=1");
            }
            

        }
    	else if(!button.equals(""))
    	{
    		String q1 = "DELETE FROM castings WHERE moviename=?";
    		String q3 = "DELETE FROM movieawards WHERE moviename=?";
    		String q2 = "DELETE FROM movie WHERE moviename=?";
    		try
    		{
    			ppt = conn.prepareStatement(q1);
    			ppt.setString(1,button);
    			ppt.executeUpdate();
    			ppt = conn.prepareStatement(q3);
    			ppt.setString(1,button);
    			ppt.executeUpdate();
    			ppt = conn.prepareStatement(q2);
    			ppt.setString(1,button);
    			ppt.executeUpdate();
    		}
    		catch(SQLException sqle)
    		{
    			sqle.printStackTrace();
    		}
/*    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<html><meta http-equiv=\"refresh\" content=\"0; url=/lab7/write.jsp\"></html>")
*/    		
    		response.sendRedirect("/lab7/write.jsp");
    	}

    }


}
