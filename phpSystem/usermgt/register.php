<?php include "base.php"; ?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<body>
    <div class="header">
        <h2>Register</h2>
    </div>

    <form method="post" action="register.php">
        <?php include('errors.php'); ?>

        <div class="input-group">
            <label for="">Username</label>
            <input type="text" name="username" value="<?php echo $username; ?>">
        </div>

        <div class="input-group">
            <label>Email</label>
            <input type="email" name="email" value="<?php echo $email; ?>">
        </div>

        <div class="input-group">
            <label>Password</label>
            <input type="password" name="password_1">
        </div>

        <div class="input-group">
            <label>Confirm password</label>
            <input type="password" name="password_2">
        </div>

        <div class="input-group">
            <button type="submit" class="btn" name="user_register">Register</button>
        </div>

        <p>
            Already a member? <a href="index.php">Sign in</a>
        </p>
    
    </form>


    
</body>
</html>