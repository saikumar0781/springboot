<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Book Search</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">BookWorm</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/admin">Home</a></li>
					<li style="margin-left: 140vh;" class="nav-item"><a
						class="nav-link active"></a></li>
						
				</ul>
			</div>
		</div>
	</nav>
	
	<h1 style="text-align:center; color:#704a77;">Search Books</h1>
	
						<form action="adminbooklook" method="POST">
				<section class="vh-100" style="background-color: #3c4963;">
			<div class="container py-5 h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card shadow-2-strong" style="border-radius: 1rem;">
  <fieldset>
    <legend>Enter Details here</legend>
    <div class="mb-3">
      <label for="input" class="form-label">  Input</label>
      <input type="text" id="input" name="input" class="form-control" placeholder="input">
    </div>
    
    <div class="mb-3">
      <label for="select" class="form-label">Select Menu</label>
      <select id="select" name="select" class="form-select">
        <option>BookId</option>
         <option>Author</option>
           
      </select>
     
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </fieldset>
</form>										  	
	

</body>
</html>