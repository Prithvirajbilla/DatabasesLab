package package1;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;

public class GetDbInfo extends HttpServlet  
{
	private static final long serialVersionUID = 1L;
	public Connection conn = null;
	private	String query = null;
	private String type	 = null;


	public GetDbInfo(String a,String b)
	{
		query = a;
		type = b;

		//Enter the connection details
		String hostname = "10.105.1.51";	// If PostgreSQL is running on some other machine enter the IP address of the machine here
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

	}

	public String getHtmlView()
	{
		//search for movie details
	    String resultHtml = " ";
		if(type.equals("1"))
		{
			String query1 = "SELECT * FROM (movie NATURAL JOIN castings) as a WHERE moviename=?";
			PreparedStatement ppt = null;
			ResultSet rs  = null;
	        try
	        {
	    	   ppt  = conn.prepareStatement(query1);
	    	   ppt.setString(1,query);
	    	   rs =	 ppt.executeQuery();
	    	   	int c = 1;
		        while(rs.next())
	    		{
	    			if(c == 1)
	    			{
	        			resultHtml = resultHtml + "<span class=\"alert\"> <b>Moviename:</b> " + rs.getString(1) + ", <b>YearOfRelease:</b> "
	        						+rs.getString(2)+",<b>Producer:</b> " + rs.getString(3) +", <b>Director </b>:"+
	        						rs.getString(4)+ "<br/><br/>  <b> Actors </b> : ";
	    			}
	    			else
	    			{
	        			resultHtml = resultHtml + rs.getString(5) + ", ";
	        		}
	        		c =  c +1;
	    		}

	    		resultHtml = resultHtml + "</span>";

	        }
	        catch(SQLException sqle)
	        {
	        	resultHtml = resultHtml + "<span class=\"alert\"> Query resulted in empty results </span";
	        }
	        


		}
		else if(type.equals("2"))
		{
			String query1 = "SELECT * FROM castings WHERE actor=?";
			PreparedStatement ppt = null;
			ResultSet rs  = null;
	        try
	        {
	    	   ppt  = conn.prepareStatement(query1);
	    	   ppt.setString(1,query);
	    	   rs =	 ppt.executeQuery();
	    	   int c =1;
	    	   while(rs.next())
    			{
    				if( c == 1)
    				{
    					resultHtml = resultHtml + "<h4>Movies Acted : </h4> <br/>";
    				}
    				c = c+ 1;
    				resultHtml = resultHtml + "<span class=\"alert\" >" +  rs.getString(1) + "</span> ";
    			}


	        }
	        catch(SQLException sqle)
	        {
	        	resultHtml = resultHtml + "<span class=\"alert\"> Query resulted in empty results </span";
	        }

		}
		else if(type.equals("3"))
		{
			String query1 = "SELECT * FROM movieawards WHERE moviename=?";
			PreparedStatement ppt = null;
			ResultSet rs  = null;
	        try
	        {
	    	   ppt  = conn.prepareStatement(query1);
	    	   ppt.setString(1,query);
	    	   rs =	 ppt.executeQuery();
	    	   while(rs.next())
    			{
    				resultHtml = resultHtml +"<span class=\"info\"> year:</span> "+ rs.getString(2) + 
    											"<br/> <span class=\"info \"> AwardName : </span> " + rs.getString(3) + "<br/>";
    			}


	        }
	        catch(SQLException sqle)
	        {
	        	resultHtml = resultHtml + "<span class=\"alert\"> Query resulted in empty results </span";
	        }


		}
		else
		{
			resultHtml = "<span class=\"info\"> No queries Found <span>";
		}
		return resultHtml;

	}

}