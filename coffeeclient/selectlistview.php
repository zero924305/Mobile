<?php
$servername = "localhost";
$username = "studentL641";
$password = "Web9324!";
$database = "studentl641";

$conn = mysqli_connect($servername,$username,$password,$database);

$sql = "SELECT * FROM message";

$result = mysqli_query($conn,$sql);
if($result)
{
  while ($row = mysqli_fetch_array($result))
  {
      $flag[]=$row;
  }
  echo json_encode($flag);
}
mysqli_close($conn);

 ?>
