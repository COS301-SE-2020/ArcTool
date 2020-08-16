<?php include "base.php"; ?>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″ />
<title>Register</title>
<!-- <link rel="stylesheet" href="style.css" type="text/css" /> -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
<div id="main">
<?php
// if(!empty($_POST['username']) && !empty($_POST['password']))
if(isset($_POST['Register']))
{
$username = mysql_real_escape_string($_POST['username']);
$password = md5(mysql_real_escape_string($_POST['password']));
$email = mysql_real_escape_string($_POST['email']);

$checkusername = mysql_query("SELECT * FROM users WHERE Username = '".$username."'");

if(mysql_num_rows($checkusername) == 1)
{
echo "<h1>Error</h1>";
echo "<p>Sorry, that username is taken. Please go back and try again.</p>";
}
else
{
$registerquery = mysql_query("INSERT INTO users (Username, Password, EmailAddress) VALUES('".$username."', '".$password."', '".$email."')");
if($registerquery)
{
echo ("<h1>Success</h1>");
echo ("<p>Your account was successfully created. Please <a href=\”index.php\”>click here to login</a>.</p>");
}
else
{
echo ("<h1>Error</h1>");
echo ("<p>Sorry, your registration failed. Please go back and try again.</p>");
}
}
}
else
{
?>

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
              <a class="nav-link active" th:href="@{/signup}">Register</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" th:href="@{/login}">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" th:href="@{/index}">Logout</a>
            </li>    
          </ul>
        </div>  
      </nav>

<div class="container text-center pt-5 pb-5">
<h1>Register</h1>

<p>Please enter your details below to register.</p>

<form class="form-horizontal" method="post" action="formcheck.php" name="registerform" id="registerform">
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
        <label for="email">Email address:</label>
    </div>
    <div class="col-md-6">
        <div class="form-group">
            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-at"></i></div>
                    <input type="text" name="email" class="form-control" id="email"
                        placeholder="username@something.com" required autofocus>
                </div>
            </div>
        </div>
             <!-- <div class="col-md-3">
                 <div class="form-control-feedback">
                         <span class="text-danger align-middle" th:if="${#fields.hasErrors('email')}" th:errors="*{email}">
                         </span>
                 </div>
             </div> -->
</div>

<!-- <label for="email">Email Address:</label><input type="text" name="email" id="email" /><br /> -->

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
             <!-- <div class="col-md-3">
                 <div class="form-control-feedback">
                         <span class="text-danger align-middle" th:if="${#fields.hasErrors('password')}" th:errors="*{password}">
                         </span>
                 </div>
             </div> -->
</div>
<input type="submit" color="gray" name="register" id="register" value="Register" />
</fieldset>
</form>

<?php
}
?>
</div>
</body>
</html>