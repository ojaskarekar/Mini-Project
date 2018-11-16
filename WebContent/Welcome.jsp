<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="Welcome.jsp">Home</a></li>
      <li><a href="DisplayServlet">Display All</a></li>
	  <li><a href="Search.jsp">Search User</a></li>
	  <li><a href="Logout.jsp">LOGOUT</a></li>
    </ul>
  </div>
</nav>
</section>

 <section>
	 	 	<%
	        	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	        
	        	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	        	
	        	response.setHeader("Expires", "0"); //Proxies
	        
	        %>
	      <%
	      	if(session.getAttribute("name") == null){
	      		response.sendRedirect("Login.jsp");
	      	}
	      %>
	      <br><br>
	<%
	 		String name;
			name = (String)session.getAttribute("name");
	%>
	 </section>
</body>
</html>