
<?php
/*
* Discription: 1. Connent to Server
*              2. register a client
*              3. if register successful, insert client details into database server
*/

  //database and server account information
  $servername = "localhost";
  $username = "studentL641";
  $password = "Web9324!";
  $database = "studentl641";
  //set connection
  $conn = mysqli_connect($servername,$username,$password,$database);

    //set registration valuable
    $name = $_POST["name"]; //client name
    $username = $_POST["username"]; //client username
    $password = $_POST["password"];//client account password
    $coffeepoint = "0"; //defalt coffee point
    $totalCoffee = "0";// defalt total coffee point

    //Set function to insert registration details
    function registerClient()
    {
      global $conn, $name, $username, $password; // global the valuable
      $passwordHash = password_hash($password, PASSWORD_DEFAULT); //encrypt client account password
      $statement = mysqli_prepare($conn, "INSERT INTO client (name, username, password, coffeepoint, totalCoffee,join_date)
                                          VALUES (?, ?, ?,?,?,now())"); // set the direction of the valuable to insert in the correct fields
                   mysqli_stmt_bind_param($statement, "sssii", $name, $username, $password,$coffeepoint,$totalCoffee);
                   mysqli_stmt_execute($statement);//execute the statement
                   mysqli_stmt_close($statement);//close the statement
    }

    //set function check clent username if is available to use
    function clientUsernameAvaliable()
    {
      global $conn, $username; // global the valuable
      $statement = mysqli_prepare($conn, "SELECT * FROM client WHERE username = ?");
      mysqli_stmt_bind_param($statement, "s", $username);
      mysqli_stmt_execute($statement);
      mysqli_stmt_store_result($statement);
      $count = mysqli_stmt_num_rows($statement);
      mysqli_stmt_close($statement);
      if($count<1)
      {
        return true;
      }
      else
      {
        return false;
      }
    }

  //in this stage
  $response = array();
  $response["success"] = false;

  //if the client username is available, then run (registerClient) function to insert client into database server
  if(clientUsernameAvaliable())
  {
    registerClient();// run the register client function
    $response["success"] = true;
  }
  echo json_encode($response);

?>
