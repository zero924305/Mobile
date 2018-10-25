<?php
    $servername = "localhost";
    $username = "studentL641";
    $password = "Web9324!";
    $database = "studentL641";

    $conn = mysqli_connect($servername,$username,$password,$database);

    if (!$conn)
    {
      die ("Connection failed :" . mysqli_connect_error());
    }
    echo "connected successfully";

    echo 'PHP version: '.phpversion();

    phpinfo();
?>
