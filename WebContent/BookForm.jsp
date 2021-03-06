<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store Application</title>
</head>
<body>
	<center>
		<h1>Books Management</h1>
		<br/>
		<img src="images/books.png" alt="Books" style="width:275px;height:200px;">
		<h2>
			<a href="/new">Add New Book</a> &nbsp;&nbsp;&nbsp; <a href="controller?choice=list">List
				All Books</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${book != null}">
			<form action="controller" method="post">
			<input type="hidden" name="choice" value="update" />
		</c:if>
		<c:if test="${book == null}">
			<form action="controller" method="post">
			<input type="hidden" name="choice" value="insert" />
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${book != null}">
                        Edit Book
                    </c:if>
					<c:if test="${book == null}">
                        Add New Book
                    </c:if>
				</h2>
			</caption>
			<c:if test="${book != null}">
				<input type="hidden" name="id" value="<c:out value='${book.id}' />" />
			</c:if>
			<tr>
				<th>Title:</th>
				<td><input type="text" name="title" size="45"
					value="<c:out value='${book.title}' />" />
				</td>
			</tr>
			<tr>
				<th>Author:</th>
				<td><input type="text" name="author" size="45"
					value="<c:out value='${book.author}' />" /></td>
			</tr>
			<tr>
				<th>Price:</th>
				<td><input type="text" name="price" size="5"
					value="<c:out value='${book.price}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>