<?php
session_start();

// database connectionfile
$db_host = "localhost";
$db_name = "database";
$db_user = "root";

// initializing variables to be used inregistration
$username = "";
$email = "";
$errors = array();

// initialize connection to the database
$conn = mysqli_connect($db_host, $db_user, '', $db_name);


// registration functionality

if (isset($_POST['user_register'])) {
    
    $username = mysqli_real_escape_string($conn, $_POST['username']);
    $email = mysqli_real_escape_string($conn, $_POST['email']);
    $password_1 = mysqli_real_escape_string($conn, $_POST['password_1']);
    $password_2 = mysqli_real_escape_string($conn, $_POST['password_2']);


    // validating form for all fields and valid data

    if (empty($username)) { array_push($errors, "Fill in Username"); }
    if (empty($email)) { array_push($errors, "Fill in Email"); }
    if (empty($password_1)) { array_push($errors, "Fill in Password"); }
    if ($password_1 != $password_2) {
        array_push($errors, "Passwords don't match");
    }

    // checking the database to ensure the user doesnt exist already
    $user_exist_query = "SELECT * FROM users WHERE username='$username' OR email='$email' LIMIT 1";
    $result = mysqli_query($conn, $user_exist_query);
    $user = mysqli_fetch_assoc($result);

    if ($user) {
        if ($user['username'] === $username || $user['email'] === $email) {
          array_push($errors, "Username or Email already exists");
        }
      }
    
      if (count($errors) == 0) {
          $password = md5($password_1);//encrypt the password before saving in the database
    
          $query = "INSERT INTO users (username, email, password) 
                    VALUES('$username', '$email', '$password')";
          mysqli_query($conn, $query);
          $_SESSION['username'] = $username;
          $_SESSION['success'] = "You are now logged in";
          header('location: index.php');
      }
    }

// Logging in the user
if (isset($_POST['user_login'])) {
    $username = mysqli_real_escape_string($conn, $_POST['username']);
    $password = mysqli_real_escape_string($conn, $_POST['password']);
  
    if (empty($username)) {
        array_push($errors, "Fill in Username");
    }
    if (empty($password)) {
        array_push($errors, "Fill in Password");
    }
  
    if (count($errors) == 0) {
        $password = md5($password);
        $query = "SELECT * FROM users WHERE username='$username' AND password='$password'";
        $results = mysqli_query($conn, $query);
        if (mysqli_num_rows($results) == 1) {
          $_SESSION['username'] = $username;
          $_SESSION['success'] = "Login Successful";
          header('location: functionalRequirements.php');
        }else {
            array_push($errors, "Wrong Credentials");
            
        }
    }
    else {
        header('location: index.php');
    }
  }

  if(isset($_POST['submission']))
  {
     // $username = mysqli_real_escape_string($conn, $_POST['username']);
   // $fileCount = count($_FILES['files']['name'])
    $fileCount = 3;
   for($i=0;$i<$fileCount;$i++)
   {
     $fileName = $_FILES['files']['name'][$i];
     $sql = "INSERT INTO uploads (file ) VALUES ('$fileName')";
     if($conn->query($sql) == TRUE){
      echo "File successfully uploaded";
     }else{
      echo "Error";
     }

     $query = "SELECT file from uploads where id = '9'";
  $results = mysqli_query($conn, $query);
   if (mysqli_num_rows($results) > 0) {
            while($row = mysqli_fetch_assoc($results)) {
               echo $row["file"];
            }
         } else {
            echo "0 results";
         }
     
     // move_uploaded_file($_FILES['files']['tmp_name'][$i], 'upload/'.$fileName);
   }
  } 

  // $query = "SELECT file from uploads";
  // $results = mysqli_query($conn, $query);
  // echo $results;

?>