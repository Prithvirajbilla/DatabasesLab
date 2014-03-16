import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;

public class Login extends HttpServlet  
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Connection conn = null;
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

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
  	{
	  // If it is a get request forward to doPost()
  	   response.setContentType("text/html");
	}
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws IOException, ServletException
    {

    	String username = request.getParameter("user");
    	String password = request.getParameter("password");
    	String queryCheck = "SELECT * FROM users WHERE username=?  AND password=?";
        PreparedStatement ppt = null;
        try
        {
    	   ppt  = conn.prepareStatement(queryCheck);
    	   ppt.setString(1,username);
    	   ppt.setString(2,password);
        }
        catch(SQLException sqle)
        {

        }
    	try
    	{
    		ResultSet rs = ppt.executeQuery();
    		if(rs.next())
    		{
    			String t = rs.getString(3);
                HttpSession session = request.getSession(true);
                session.setAttribute( "type", t );
                if(t.equals("reader"))
                {
                    response.sendRedirect("/lab7/query.jsp");

                }
                else
                {
                    response.sendRedirect("/lab7/write.jsp");
                }
    		}
    		else
    		{
    			response.sendRedirect("/lab7/index.jsp?error=1");
    		}

    	}
    	catch(SQLException sqle)
    	{
    		response.sendRedirect("/lab7/index.jsp?error=1");
    	}

	}


}