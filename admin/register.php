<?php
  $servername = "localhost";
  $username = "studentL641";
  $password = "Web9324!";
  $database = "studentl641";

  $conn = mysqli_connect($servername,$username,$password,$database);

    $name = $_POST["name"];
    $username = $_POST["username"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($conn, "INSERT INTO admin (name, username, password, join_date) VALUES (?, ?, ?,now())");
                 mysqli_stmt_bind_param($statement, "sss", $name, $username, $password);
                 mysqli_stmt_execute($statement);
                 mysqli_stmt_close($statement);

  $response = array();
  $response["success"] = true;

  echo json_encode($response);

?>
