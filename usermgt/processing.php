 
<?php include ("simple_html_dom.php");
include "base.php";
$arrayName = array();
$file1 = "";
$file2 = "";
$file3 = "";
// $filepath = $_FILES['file'];
// echo $filepath;
// $html = file_get_html($file1);
// $html2 = file_get_html($file2);
$userInput = $_POST['comment'];  ///////////////////this is the user input from the text area.

// copy($_FILES['file']['tmp_name'], $path);

// $fileinput = $_POST[];
// echo $userInput;

// $data_input= split ("\,", $userInput); /////////////////splitting by comma

// $conn = new mysqli($servername, $username, $password, $dbname);
$resultQuery = "SELECT file,id FROM uploads ORDER BY id DESC LIMIT 3";
// echo $resultQuery;

$result = $conn->query($resultQuery);

if ($result->num_rows > 0) {
	$j = 0;   
  while($row = $result->fetch_assoc()) {
    // echo "id: " . $row["id"]. " - Name: " . $row["file"]. "<br>";
  	array_push($arrayName, $row['file']);
  	if($j == 0)
  	{
  		$file1 = $row["file"];
  	}
  	elseif ($j == 1)
  	{
  		$file2 = $row["file"];
  	}
  	elseif($j == 2)
  	{
  		$file3 = $row["file"];
  	}

  	$j++;
  }
} else {
  echo "0 results";
}

// echo $file1;
// $html = file_get_html($file1);
// // foreach($arrayName as $i => $files) { 
// //     // echo $files[$i];
// //     echo $arrayName[0];
// //  }

// foreach ($html->find("td.colLast div") as $p) {
// 	$data = $p->plaintext;
// 	if (strpos($data, $userInput) !== false) {
// 		echo 'Functional';
// 	}
// 	else {
// 		// fr2();
// 	}
// }

// function fr2(){
// 	$dat1 = $GLOBALS['html2'];
// 	$dat2 = $GLOBALS['func_req'];

	
// 	foreach ($dat1->find("td.colLast div") as $p) {
// 			$data = $p->plaintext;
// 			if (strpos($data, $dat2) !== false) {
// 	    		echo 'Paintings';
// 			}
// 			else {
// 				echo "Non of the above";
// 			}				
// 		}
// }

?>

