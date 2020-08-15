<?php include "base.php"; ?>
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Strict//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd”>
<html xmlns=”http://www.w3.org/1999/xhtml”>
<head>
<meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″ />
<title>User Management System  </title>
<link rel=”stylesheet” href=”style.css” type=”text/css” />
</head>
<body>
<div id="main">

<h1>Member Login</h1>

<p>Thanks for visiting! Please either login below, or <a href="register.php">click here to register</a>.</p>

<form method="post" action="formcheck.php name="loginform" id="loginform">
<fieldset>
<label for="username">Username:</label><input type="text" name="username" id="username" /><br />
<label for="password">Password:</label><input type="password" name="password" id="password" /><br />
<input type="submit" name="login" id="login" value="Login" />
</fieldset>
</form>

</div>
</body>
</html>
