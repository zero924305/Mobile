<?php
/*
  Discription: 1. Allow the client to login their account
               2. connet to the server
               3. check if the client account information exist
               4. display the client infomation login successful
               5. create a function to display any error message
*/
  $servername = "localhost";
  $username = "studentL641";
  $password = "Web9324!";
  $database = "studentl641";

  /**Database connection**/
  $con = mysqli_connect($servername,$username,$password,$database);

  // client account information
  $username = $_POST["username"]; //client input username
  $password = $_POST["password"]; //client input password

  // create a statement to connect the database
  $statement = mysqli_prepare($con, "SELECT * FROM client WHERE username = ? "); //fetch the client table in datbase
  mysqli_stmt_bind_param($statement, "ss", $username, $password); //compare the valuable and the client input
  mysqli_stmt_execute($statement); //execute the statement
  mysqli_stmt_store_result($statement); //
  mysqli_stmt_bind_result($statement, $userID, $clientname, $clientusername, $clientpassword,$coffeepoint,$totalCoffee,$joindate);

  $response = array();
  $response["success"] = false;

  while(mysqli_stmt_fetch($statement))
  {
    if(password_verify($password, $clientpassword))
    {
      $response["success"] = true;
      $response["name"] = $clientname;
      $response["username"] = $clientusername;
      $response["password"] = $clientpassword;
      $response["coffeepoint"] =$coffeepoint;
      $response["totalCoffee"] = $totalCoffee;
      $response["join_date"] = $joindate;
    }
  }
  echo json_encode($response);
?>
