<?php

// QRY String 
// http://127.0.0.1/sql.php?opration=selectall
// http://127.0.0.1/sql.php?opration=select&id=VALUE
// http://127.0.0.1/sql.php?opration=insert&name=VALUE&address=VALUE

	


	if(isset($_REQUEST['opration'])){

	}elseif(isset($_REQUEST['id'])){
		select($_REQUEST['id']);

	}elseif(isset($_REQUEST['name']) && isset($_REQUEST['address'])){
		insert($_REQUEST['name'],$_REQUEST['address']);	

	}else{
		select(null);
	}
	// isset REQUEST[] Check



	function select($id=null){
		$conn = new mysqli("localhost", "root","", "test");
		if ($conn->connect_error) {die("Connection failed: " . $conn->connect_error);} 

		$sql = "SELECT * FROM students "; 
		if($id){$sql .="WHERE id=".$id;}

		if($result = mysqli_query($conn, $sql)){
		    if(mysqli_num_rows($result) > 0){
	        	while($row = mysqli_fetch_array($result)){$data[] = $row; }
				echo json_encode($data);
		    }
		} else{
		    // echo "ERROR: Could not able to execute $sql. " . mysqli_error($link);
		}
	};


	function insert($name,$address){
		$conn = new mysqli("localhost", "root","", "test");
		if ($conn->connect_error) {die("Connection failed: " . $conn->connect_error);} 

		$sql = "INSERT INTO students (name,address,mobile)" ;
		$sql .="VALUES('".$_REQUEST['name']."', '".$_REQUEST['address']."',".rand(100000,9000000)." )";
		if ($conn->query($sql) === TRUE) { echo "inserted"; } else {echo "Error: " . $sql . "<br>" . $conn->error; }
		$conn->close();
	};





// QRY String  (URL)
// http://10.0.2.2/sql.php?opration=selectall

// http://10.0.2.2/sql.php?opration=select&id=VALUE
	//http://127.0.0.1/sql.php?opration=select&id=4

// http://10.0.2.2/sql.php?opration=insert&name=VALUE&address=VALUE
	//http://127.0.0.1/sql.php?opration=selectall&name=DIpen%20Pamrar&address=Kutch,Rajkot




// public interface IService { 
//   String BASE_URL = "https://api.demo.com/";

//   @GET("Login") //i.e https://api.demo.com/Search? 
//   Call<Products> getUserDetails(@Query("email") String emailID, @Query("password") String password)

// } 
// It will be called this way. Considering you did the rest of the code already.


// Call<Results> call = service.authenticateUser("abc@gmail.com", "Password@123");
// For example when a query is returned, it will look like this.

// https://api.demo.com/Login?email=abc@gmail.com&password=Password@123

