<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store Application</title>
<style type="text/css">

	button {
    overflow: visible;
    width: auto;
}
button.link {
    font-family: "Verdana" sans-serif;
    font-size: 1em;
    text-align: left;
    color: blue;
    background: none;
    margin: 0;
    padding: 0;
    border: none;
    cursor: pointer;
   
    -moz-user-select: text;
 
    /* override all your button styles here if there are any others */
}
button.link span {
    text-decoration: underline;
}
button.link:hover span,
button.link:focus span {
    color: black;
}

</style>
</head>
<body>

	<center>
		<h1>Books Management</h1>
		<h2>
			<form method="get" action="controller">
			<input type="hidden" name="choice" value="new">
			<button type="submit" class="link"><span>Add New Book</span></button>
			&nbsp;&nbsp;&nbsp; </form>
			<form method="get" action="controller">
			<input type="hidden" name="choice" value="list">
			<button type="submit" class="link"><span>List Books</span></button>
			<!--  <a href="contoller/new">Add New Book</a> &nbsp;&nbsp;&nbsp; <a href="/list">List
				All Books</a> -->
			</form>
		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Books</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="book" items="${listBook}">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.price}" /></td>
					<td><a href="controller?choice=edit&id=<c:out value='${book.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="controller?choice=delete&id=<c:out value='${book.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>