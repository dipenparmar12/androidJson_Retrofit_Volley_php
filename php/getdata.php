<?php

$s1 = ["name"=>"dpen","address"=>"PLot no 2","mobile"=>"1234567"];
$s2 = ["name"=>"Hitesh","address"=>"PLot no 2","mobile"=>"1234567"];
$s3 = ["name"=>"Janvi","address"=>"PLot no 2","mobile"=>"1234567"];
$s4 = ["name"=>"Ria","address"=>"PLot no 2","mobile"=>"1234567"];
echo json_encode([$s1,$s2,$s3,$s4,$s3,$s2]);

// echo json_encode([["name"=>"Nikhil","College"=>"Atmiya","couse"=>"Mscit"],["name"=>"Nikhil","College"=>"Atmiya","couse"=>"Mscit"]]);



// function randomString($length = 5) {
//     $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
//     $randomString = '';
//     for ($i = 0; $i < $length; $i++) {
//       $randomString .= $characters[rand(0, strlen($characters) - 1)];
//     }
//     return $randomString;
// }

// for($i=1; $i<30; $i++){
// 	$data[] = ["name"=>$i."_N ".randomString(),"mobile"=>rand(10999,1000000),"address"=>randomString(7)];
// }
// echo json_encode($data);