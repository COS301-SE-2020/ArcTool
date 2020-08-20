<?php
include "base.php";
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content=text/html; charset=utf-8″ />
<title>User Management System </title>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
<div id="main">

<h1>Member Area</h1>
<?php
$Username = "";
$EmailAddress    = "";

if (isset($_POST['submit'])) {

	$Username = mysqli_real_escape_string($con, $_POST['Username']);
	$EmailAddress = mysqli_real_escape_string($con, $_POST['EmailAddress']);
	$Password = mysqli_real_escape_string($con, $_POST['Password']);

	$user_check_query = "SELECT * FROM users WHERE Username= '$Username' OR $EmailAddress='$EmailAddress' LIMIT 1";
	$result = mysqli_query($con, $user_check_query);
	$user = mysqli_fetch_assoc($result);

	if ($user) { 
		if($user['Username'] === $Username || $user['EmailAddress'] === $EmailAddress) {
			echo "User already exists";
			// login();
		}
	} 

	if(!$user) {
		$query  = "INSERT INTO users (Username, EmailAddress, Password) VALUES('$Username', '$EmailAddress', '$Password')";
	 	mysqli_query($con, $query);
	 	header('location: index.php');

	}
}
?>
<p>Thanks for Registering! You are <b> User <b> and your email address is <b> your email</b>.</p>

<ul>
<li><a href="logout.php">To Logout.</a></li>
</ul>

<ul>
<li><a href="index.php">To Login.</a></li>
</ul>

</div>
</body>
</html>

 