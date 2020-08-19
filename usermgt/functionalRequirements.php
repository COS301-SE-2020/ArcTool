<?php include "base.php"; ?>


<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Input</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.min.css">
</head>
<body>
<div class="container-fluid bg-light text-center pt-3 pb-3"  style="margin-bottom:0">
    <h1>ArcTool</h1>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" th:href="@{/index}">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" th:href="@{/signup}">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" th:href="@{/login}">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" th:href="@{/index}">Logout</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" th:href="@{/history}">history</a>
            </li>
        </ul>
    </div>
</nav>
<br>  <br>  <br>

<div class="container border border-light rounded shadow">
    <div class="form-group">
        <form action ="processing.php" class="mainDiv" role="form"  method="POST" enctype="multipart/form-data">
            <label for="comment">Enter functional requirements:</label>
            <textarea class="form-control" rows="5" id="comment" name="comment"></textarea>
            <br>

            <!-- <form action="" enctype="multipart/form-data" method="post"> -->
                <input type="file" name="file[]" multiple/>
                <input type="submit" name="submission" value="Upload"/>
            <!-- </form> -->
            
            <!-- <br> -->
        </form>
    </div>
</div>

</body>
</html>