<%
try
{
	String t =  session.getAttribute("type").toString();
}
catch (Exception e)
{
	response.sendRedirect("/lab7/index.jsp?error=2");
}

%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Lab 7 </title>

    <!-- Le styles -->
    <link href="/lab7/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/lab7/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
  </head>
<body>
	<div class="navbar">
	  <div class="navbar-inner">
	    <a class="brand" href="#">DBMS</a>
	    <ul class="nav pull-right">
	      <li  class="active"><a href="/lab7/query.jsp">query</a></li>
	      <li><a  href="/lab7/write.jsp">Movie Details</a></li>
	      <li ><a  href="/lab7/writeaward.jsp">Movie Award Details</a></li>
	      <li><a href="/lab7/logout.jsp">Logout</a></li>
	    </ul>
	  </div>
	</div>

	<div class="page-header" style="text-align:center">
		<div class="container">
			<h3> Query the Detials of the Movie </h3>
			<form class="form-horizontal" method="post">
				<fieldset>

				<!-- Form Name -->
				<legend>Details</legend>

				<!-- Text input-->
				<div class="control-group">
				  <label class="control-label" for="Query">query</label>
				  <div class="controls">
				    <input id="Query" name="Query" type="text" placeholder="Query" class="input-xlarge" required="">
				    
				  </div>
				</div>

				<!-- Select Basic -->
				<div class="control-group">
				  <label class="control-label" for="select">Select Query Type</label>
				  <div class="controls">
				    <select id="select" name="select" class="input-xlarge">
				      <option value="1">Search for Movie Details</option>
				      <option Value="2">Get all the Movies Acted</option>
				      <option value="3">Search for the Movie Awards</option>
				    </select>
				  </div>
				</div>

				<!-- Button -->
				<div class="control-group">
				  <label class="control-label" for="submit">submit</label>
				  <div class="controls">
				    <button id="submit" name="submit" class="btn btn-success">submit</button>
				  </div>
				</div>

				</fieldset>
			</form>

		</div>
	</div>
	 <%@ page import="package1.*" %>
	<%
		String message = "";
		if ("POST".equalsIgnoreCase(request.getMethod())) 
		{
			String a = request.getParameter("Query");
			String b =request.getParameter("select");

			GetDbInfo n = new GetDbInfo(a,b);
			message = n.getHtmlView();
			if(message.equals(" "))
			{
				message="<span class=\"alert\"> Query resulted in empty results </span>";
			}
		} 
		else 
		{

		}
	%>

	<div class="page-header" style="text-align:center;margin-left:200px !important;margin-right:200px;">
<!-- 		<table class="table">
              <tbody>
              	<thead>Details of the Movie</thead>
                <tr>
                  <td>1</td>
                  <td>Mark</td>
                  <td>Otto</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Larry</td>
                  <td>the Bird</td>
                </tr>
              </tbody>
            </table>
 -->	
 	<%= message %>
</div>

<script type="text/javascript" src="/lab7/bootstrap/jquery.js"></script>
<script type="text/javascript" src="/lab7/bootstrap/js/bootstrap.js"></script>

</body>