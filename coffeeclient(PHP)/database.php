<?php
    /*
      Discription: 1. create database and server connection valuable
                   2. buile a connection
                   3. set an error function if connection failed
                   4. set an message if connection successful
                   5. echo the PHP version details
    */

    $servername = "localhost"; //server address
    $username = "studentL641"; //server username
    $password = "Web9324!"; //server password
    $database = "studentL641"; //Database name

    // set connection using Mysqli connect function
    $conn = mysqli_connect($servername,$username,$password,$database);

    if (!$conn)//when connection is failed, the website won't display anything except the error message
    {
      die ("Connection failed :" . mysqli_connect_error());
    }

    //else display the connection successful message
    echo "connected successfully";

    // display the PHP version for developer
    echo 'PHP version: '.phpversion();

    // display the full details of the server
    phpinfo();
?>
