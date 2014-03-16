import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class First extends HttpServlet  
  {

  	public static movieQuery queryWork;
  	public static String bufferedFile = "C:/dbms/tomcat/webapps/lab32/WEB-INF/classes/buffer.txt";
  	//init method
  	public void init()
  	{
  		try{
				queryWork = new movieQuery();
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		//Timer functions
		//created a timer.
		Timer timer = new Timer();
		//schedule a task at fixed time
		timer.scheduleAtFixedRate(new TimerTask() {
 		 @Override
  		public void run(){
  			try{
					queryWork.readFile(bufferedFile);
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}

  		}
		}, 10*1000,10*1000);

  	}
  	//writing to buffered file method :P
  	static void writeContent(String content,String filename) throws IOException
	 {
		File yourFile = new File(filename);
		if(!yourFile.exists()) {
		    yourFile.createNewFile();
		} 
		 FileWriter fw = new FileWriter(filename,true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 content = content + "\n";
		 bw.append(content);
		 bw.close();
	 }

    		
    public void doGet(HttpServletRequest request,HttpServletResponse response)
					        throws IOException, ServletException 
	// This method is called whenver we invoke this servlet. 
	// Use "request" to read incoming HTTP headers
	// Use "response" to specify the HTTP response line and headers
  	{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); // Use "out" to send content to browser
        out.println("<html>");
        out.println("<body bgcolor=\"white\">");
        out.println("<head>");
        out.println("<title>  Movie DBMS  </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3 align=\"center\"> Movie Query </h3><hr>");
	if(request.getParameter("SUBMIT")==null){     // value of SUBMIT parameter determines which link or url is used invoking servlet 
			form1(request, response, out);
	} 

	else if(request.getParameter("SUBMIT").toString().equals("BACK")){
				form1(request,response,out);    // Input Form
	}
	else {
                form2(request, response, out);  // Result form
        }
	out.println("</body>");
        out.println("</html>");
        
    }
    	


    public void doPost(HttpServletRequest request,HttpServletResponse response)
        	throws IOException, ServletException
    {
        doGet(request, response);
    }

	public void form1(HttpServletRequest request,HttpServletResponse response,PrintWriter out) 
	// This method gets invoked at start of servlet or whenever BACK is clicked from form2. This just shows the input form 
	{
		out.println("<P>");
        out.print("<form action=\"");
        out.print(response.encodeURL("First"));  // Here name of servlet to be invoked needs to be given
        out.print("\" ");
        out.println("method=GET>");
		out.println("<label> Enter movie to find Director : </label>");    
		out.println("<input type=\"text\" name=\"movie\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"getDirec\" ></br>");
		out.println("<label> Enter actor to find movies : </label>");    
		out.println("<input type=\"text\" name=\"actor\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"getActor\" ></br>");
		out.println("<label> Enter year to find best movie of year : </label>");  
		out.println("<input type=\"text\" name=\"rating\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"getMovie\" ></br>"); 
		out.println("</form>");
		out.print("<form action=\"");
        out.print(response.encodeURL("First"));  // Here name of servlet to be invoked needs to be given
        out.print("\" ");
        out.println("method=POST>");
		out.println("<label> add new movie info : </label>");  
		out.println("<input type=\"text\" name=\"anmi\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"anmi\" ><br/>");
		out.println("<label> add new movie rating : </label>");  
		out.println("<input type=\"text\" name=\"anmr\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"anmr\" ><br/>"); 
		out.println("<label> change new movie info : </label>");  
		out.println("<input type=\"text\" name=\"cnmi\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"cnmi\" ><br/>"); 
		out.println("<label> change new movie rating : </label>");  
		out.println("<input type=\"text\" name=\"cnmr\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"cnmr\" ><br/>"); 
		out.println("<label> delete new movie info : </label>");  
		out.println("<input type=\"text\" name=\"dnmi\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"dnmi\" ><br/>"); 
		out.println("<label> delete new movie rating : </label>");  
		out.println("<input type=\"text\" name=\"dnmr\" />"); 
		out.println("<input type=submit name=\"SUBMIT\" value=\"dnmr\" ><br/>"); 
		// All the buttons have same name "SUBMIT" but different value
       	out.println("</form>");
	}


	public void form2(HttpServletRequest request,HttpServletResponse response,PrintWriter out) throws IOException
		// This page displays result in new page 
        // It contain link back to input form
	{
		String val;
		String movie;
		String Ope;
		Ope = request.getParameter("SUBMIT");
		if(Ope.equals("getDirec"))
		{
			movie = request.getParameter("movie");
			val = queryWork.getDirector(movie);
			out.println("<p>"+ val+"</p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}
		else if(Ope.equals("getActor"))
		{
			movie = request.getParameter("actor");
			val = queryWork.getActors(movie);
			out.println("<p>"+val+"</p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}
		else if (Ope.equals("getMovie"))
		{
			movie = request.getParameter("rating");
			val = queryWork.getBestMovie(movie);
			out.println("<p> "+ val+"</p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}
		else if (Ope.equals("anmi"))
		{
			movie = request.getParameter("anmi");
			String data = "addNewMovieInfo "+movie;
			writeContent(data,bufferedFile);
			out.println("<p>Added to the Buffer File</p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}
		else if (Ope.equals("anmr"))
		{
			movie = request.getParameter("anmr");
			String data = "addNewMovieRating "+movie;
			writeContent(data,bufferedFile);
			out.println("<p>Added to the Buffer File</p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}
		else if (Ope.equals("cnmi"))
		{
			movie = request.getParameter("cnmi");
			String data = "ChangeInfo "+ movie;
			writeContent(data,bufferedFile);
			out.println("<p>Added to the buffer file.Takes 30 seconds.</p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}
		else if (Ope.equals("cnmr"))
		{
			movie = request.getParameter("cnmr");
			String data = "changeRating "+ movie;
			writeContent(data,bufferedFile);
			out.println("<p>added to the Buffer file.Takes 30 secs to mirror the changes</p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}
		else if (Ope.equals("dnmi"))
		{
			movie = request.getParameter("dnmi");
			String data = "removeMovieInfo "+ movie;
			writeContent(data,bufferedFile);		
			out.println("<p> added to the buffer file.Takes 30 secs</p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}
		else if (Ope.equals("dnmr"))
		{
			movie = request.getParameter("dnmr");
			String data = "removeMovieRating "+ movie;
			writeContent(data,bufferedFile);
			out.println("<p> added to the movie buffer </p>");
			out.println("<p><p align=center > <a href=First?SUBMIT=BACK>BACK </a>"); // This is way of passing parameters to the servlet. SUMBMIT is name of parameter and its value is "BACK"  

		}



	}
}
