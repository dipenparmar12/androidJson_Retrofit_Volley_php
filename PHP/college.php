<?php

$data=["college"=>"Atmiya","streme"=>"Mscit"];

$conn = mysqli_connect("localhost","root","","test");
$qry = "SELECT * FROM students";

if ($result = mysqli_query($conn,$qry)) {
	// print_r($result);
	if(mysqli_num_rows($result) > 0){
		while($row = mysqli_fetch_array($result)){
			$data["students"][] = $row;
		}
	}
}

mysqli_close($conn);
echo json_encode($data);







// /* Attempt MySQL server connection. Assuming you are running MySQL
// server with default setting (user 'root' with no password) */
// $link = mysqli_connect("localhost", "root", "", "test");
 
// // Check connection
// if($link === false){
//     // die("ERROR: Could not connect. " . mysqli_connect_error());
// }
// $data = [];
// // Attempt select query execution
// $sql = "SELECT * FROM students";
// if($result = mysqli_query($link, $sql)){
//     if(mysqli_num_rows($result) > 0){
//          while($row = mysqli_fetch_array($result)){
//             $data[] = $row;
//         }
//     } else{
//         // echo "No records matching your query were found.";
//     }
// } else{
//     // echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
// }
// // Close connection
// mysqli_close($link);
// echo json_encode($data);



// $s1 = ["name"=>"Roshni ", "address"=>"Rajkot"];
// $s2 = ["name"=>"Atmiya1","address"=>"Rajkot"];
// $s3 = ["name"=>"Atmiya 2","address"=>"Rajkot "];
// echo json_encode([$s1,$s2]);


// echo '[{"0":"1","1":"Namarta","2":"Main Raod","3":"1234567890","id":"1","name":"Namarta","address":"Main Raod","mobile":"1234567890"},{"0":"2","1":"Riaz","2":"hello there","3":"1234567890","id":"2","name":"Riaz","address":"hello there","mobile":"1234567890"},{"0":"3","1":"PUD","2":"hello there","3":"1234567890","id":"3","name":"PUD","address":"hello there","mobile":"1234567890"},{"0":"4","1":"Gaurav","2":"hello there","3":"1234567890","id":"4","name":"Gaurav","address":"hello there","mobile":"1234567890"},{"0":"5","1":"Dharmesh","2":"hello there","3":"1234567890","id":"5","name":"Dharmesh","address":"hello there","mobile":"1234567890"},{"0":"6","1":"Jay","2":"Okay","3":"1234567890","id":"6","name":"Jay","address":"Okay","mobile":"1234567890"},{"0":"16","1":"DIpen Pamrar","2":"Plot not 20 Kutch","3":"8837837","id":"16","name":"DIpen Pamrar","address":"Plot not 20 Kutch","mobile":"8837837"},{"0":"20","1":"DIpen Pamrar","2":"Plot not 20 Kutch","3":"8957939","id":"20","name":"DIpen Pamrar","address":"Plot not 20 Kutch","mobile":"8957939"},{"0":"21","1":"Hello ","2":"Honey Bod","3":null,"id":"21","name":"Hello ","address":"Honey Bod","mobile":null}]';



// if($result = mysqli_query($link, $sql)){
//     if(mysqli_num_rows($result) > 0){
//          while($row = mysqli_fetch_array($result)){
//             $data[] = $row;
//         }
//     } else{
//         // echo "No records matching your query were found.";
//     }
// } else{
//     // echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
// }
 

// Close connection
// mysqli_close($link);
