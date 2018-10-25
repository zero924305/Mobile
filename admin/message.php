<?php
$servername = "localhost";
$username = "studentL641";
$password = "Web9324!";
$database = "studentl641";

$conn = mysqli_connect($servername,$username,$password,$database);

$title = $_POST["title"];
$message = $_POST["message"];

$statement = mysqli_prepare($conn, "INSERT INTO message (title, message, join_date) VALUES (?,?,now())");
             mysqli_stmt_bind_param($statement, "ss", $title, $message);
             mysqli_stmt_execute($statement);
             mysqli_stmt_close($statement);

 $response = array();
 $response["success"] = true;

 echo json_encode($response);
?>
