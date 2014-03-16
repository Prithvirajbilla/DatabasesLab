<%
try
{
	String t =  session.getAttribute("type").toString();
	if(t.equals("reader"))
	{
		response.sendRedirect("/lab7/query.jsp?error=2");
	}
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
	<link href="/lab7/bootstrap-editable/css/bootstrap-editable.css" rel="stylesheet">
  </head>
<body>
	<div class="navbar">
	  <div class="navbar-inner">
	    <a class="brand" href="#">DBMS</a>
	    <ul class="nav pull-right">
	      <li><a href="/lab7/query.jsp">query</a></li>
	      <li><a  href="/lab7/write.jsp">Movie Details</a></li>
	      <li class="active" ><a  href="/lab7/writeaward.jsp">Movie Award Details</a></li>
	      <li><a href="/lab7/logout.jsp">Logout</a></li>
	    </ul>
	  </div>
	</div>

	<div class="container">
		<div class="row9">
			<div class="page-header">
				<h1> Edit the Details </h1>
			</div>
			<%
			    String error = "";
			    if (request.getParameter("err") != null) {
			        error = "<div class=\"alert alert-info\"><button type=\"button\"" + 
			    "class=\"close\" data-dismiss=\"alert\">x</button><strong>Warning!</strong>"
			    +"Best check yo self, you\'re not looking too good.</div>";
			    } 
			%>
			<%= error %>

			<input class="btn btn-primary" type="submit" name="add" value="add New Movie" 
			onclick="showDiv()" >
			<table class="table table-striped" is="myTable">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Movie Name</th>
                  <th>Year of Award</th>
                  <th>Award Name</th>
                </tr>
              </thead>
              <tbody>
              <tr style="display:none" id="addNewMovie">
              	<td>0</td>
              	<form method="post" action="/lab7/WriteAward">
              	<td>
              		<input class="large" type="text" name="moviename" required/>
              	</td>
              	<td>
              		<input class="large" type="text" name="yoa" required/></td> 
              	<td>
              		<input class="large" type="text" name="awardname" required/>
              	</td> 
              	<td>
              		<button type="submit" value="add" name="button" class="btn btn-primary">Add</button>
              	</td>
              </form>
              	</tr>
              <%@ page import="package1.*" %>
				<%
					String message = "";
					String jsmessage = "";
					if ("GET".equalsIgnoreCase(request.getMethod())) 
					{
						getMovieAward n = new getMovieAward();
						message = n.getHtmlView();
						jsmessage = n.getJsView();
						if(message.equals(" "))
						{
							message="<span class=\"alert\"> Query resulted in empty results </span>";
						}
					} 
				%>
				<%= message %>

              </tbody>
            </table>

		</div>
	</div>

<script type="text/javascript" src="/lab7/bootstrap/jquery.js"></script>
<script type="text/javascript" src="/lab7/bootstrap/js/bootstrap.js"></script>
<script src="/lab7/bootstrap-editable/js/bootstrap-editable.js"></script>
<script type="text/javascript">
$.fn.editable.defaults.mode = 'inline';
$(document).ready(function() {
	$('#moviename').editable();
	$('#yoa').editable();
	$('#awardname').editable();
	<%= jsmessage %>
});
function displayResult()
{
document.getElementById("myTable").deleteRow(0);
}
function showDiv() {
	if(document.getElementById('addNewMovie').style.display == "table-row")
	{
		document.getElementById('addNewMovie').style.display = "none";
	}
	else
	{
		document.getElementById('addNewMovie').style.display = "table-row";
	}
}


</script>

</body>