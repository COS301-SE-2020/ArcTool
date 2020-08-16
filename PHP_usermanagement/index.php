<?php include "base.php"; ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns=”http://www.w3.org/1999/xhtml”>
<head>
<meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″ />
<title>Login</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!-- <link rel=”stylesheet” href=”style.css” type=”text/css” /> -->
</head>
<body>
<div id="main">

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
              <a class="nav-link" th:href="register.php">Register</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" th:href="@{/login}">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" th:href="@{/index}">Logout</a>
            </li>    
          </ul>
        </div>  
      </nav>

<div class="container text-center pt-5 pb-5">
<h1>Member Login</h1>

<p>Thanks for visiting! Please either login below, or <a href="register.php">click here to register</a>.</p>

<form method="post" action="functionalRequirements.php" name="loginform" id="loginform">
<fieldset>
<!-- <label for="username">Username:</label><input type="text" name="username" id="username" /><br /> -->
<div class="row">
    <div class="col-md-3 field-label-responsive">
        <label for="username">Username:</label>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                    <input type="text" name="username" class="form-control" id="username"
                        placeholder="Username" required autofocus>
                </div>
            </div>
        </div>
    </div>
    
<!-- <label for="password">Password:</label><input type="password" name="password" id="password" /><br /> -->
<div class="row">
    <div class="col-md-3 field-label-responsive">
        <label for="password">Password:</label>
    </div>
    <div class="col-md-6">
        <div class="form-group has-danger">
            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                <input type="password" name="password" class="form-control" id="password"
                    placeholder="Password" required>
                </div>
            </div>
        </div>
</div>

<input type="submit" name="login" id="login" value="Login" />
</fieldset>
</form>

</div>
</body>
</html>
