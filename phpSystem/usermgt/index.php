<?php include "base.php"; ?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
 xmlns:th="http://www.thymeleaf.org">

<head>
 <title>Sign in</title>
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
          <a class="nav-link active" href="index.php">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="register.php">Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login.php">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="login.php">Logout</a>
        </li>    
      </ul>
    </div>  
  </nav>

  <div class="container pt-5 pb-5">
    <div class="jumbotron text-center">
      <h1>A tool built for efficiency and ease</h1>      
      <h3>ArcTool improves your architectural design time by:</h3>
          <p>- processing your current software portfolio</p>
          <p>- indentifying it's high-level requirements</p>
          <p>- building up a initial meta-model of the proposed design based on the current funtional requirements</p>
          <p>- re-using solutions that are already part of the portfolio</p>
          <p>

          </p>

        <a href="register.php" class="button">Get started</a>
    </div>
  </div>

</body>
</html>
