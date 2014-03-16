<%

try
{
  String t =  session.getAttribute("type").toString();
  if(t.equals("reader"))
  {
    response.sendRedirect("/lab7/query.jsp");
  }
  else if(t.equals("writer"))
  {
    response.sendRedirect("/lab7/query.jsp");
  }
}
catch(Exception e)
{

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
<div class="container" >

<div class="row2 " style="margin-top:100px !important;">
<form class="form-horizontal" action="Login" method="POST">
<fieldset>

<!-- Form Name -->
<div class="row2 offset3">
<h3>Login</h3>
</div>
<!-- Text input-->
<div class="control-group row2 offset2">
<%
    String error = "";
    if (request.getParameter("error") != null) {
        error = "<div class=\"alert alert-info\"><button type=\"button\"" + 
    "class=\"close\" data-dismiss=\"alert\">x</button><strong>Warning!</strong>"
    +"Best check yo self, you\'re not looking too good.</div>";
    } 
%>
<%= error %>

  <label class="control-label" for="user">user name</label>
  <div class="controls">
    <input id="user" name="user" placeholder="user name" class="input-xlarge" required="" type="text">
    <p class="help-block">please get permissions</p>
  </div>
</div>

<!-- Password input-->
<div class="control-group row2 offset2">
  <label class="control-label" for="password">Password</label>
  <div class="controls">
    <input id="password" name="password" placeholder="********************" class="input-xlarge" required="" type="password">
    <p class="help-block">password required</p>
  </div>
</div>

<!-- Button -->
<div class="control-group row2 offset2">
  <label class="control-label" for="login"></label>
  <div class="controls">
    <button id="login" name="login" class="btn btn-primary">Login</button>
  </div>
</div>

</fieldset>
</form>
</div>
</div>
<script type="text/javascript" src="/lab7/bootstrap/jquery.js"></script>
<script type="text/javascript" src="/lab7/bootstrap/js/bootstrap.js"></script>
</body>