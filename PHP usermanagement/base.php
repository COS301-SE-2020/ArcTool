<?php
session_start();

$dbhost = "localhost"; // this will ususally be ‘localhost’, but can sometimes differ
$dbname = "database"; // the name of the database that you are going to use for this project
$dbuser = "root"; // the username that you created, or were given, to access your database
$dbpass = ""; // the password that you created, or were given, to access your database

mysqli_connect($dbhost, $dbuser, $dbpass) or die("MySQL Error: " . mysql_error());
// mysqli_select_db($dbname) or die("MySQL Error: " . mysql_error());

// mysqli_select_db($con, 'phpcadet') or die(mysqli_error($con));

////////////////////////////////////upload to db stuff

if(isset($_POST['submit']))
{
	$fileCount = count($_FILES['file']['name'])
	for($i=0;$i<$fileCount;$i++)
	{
		$fileName = $_FILES['file']['name'][$i];
		$sql = "INSERT INTO fileup (title,img) VALUES ('$fileName','$fileName')";
		// if($con->query($sql) == TRUE){
		// 	echo "File successfully uploaded";
		// }else{
		// 	echo "Error";
		// }

		move_uploaded_file($_FILES['file']['tmp_name'][$i], 'upload/'.$fileName);
	}
}
?>