<?php

/* Attempt MySQL server connection. Assuming you are running MySQL
server with default setting (user 'root' with no password) */
$link = mysqli_connect("localhost", "root", "", "test");
 
// Check connection
if($link === false){
    // die("ERROR: Could not connect. " . mysqli_connect_error());
}

$data = [];

// Attempt select query execution
$sql = "SELECT * FROM students";
if($result = mysqli_query($link, $sql)){
    if(mysqli_num_rows($result) > 0){
         while($row = mysqli_fetch_array($result)){
            $data[] = $row;
        }
    } else{
        // echo "No records matching your query were found.";
    }
} else{
    // echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
}
 

// Close connection
mysqli_close($link);


echo json_encode($data);
