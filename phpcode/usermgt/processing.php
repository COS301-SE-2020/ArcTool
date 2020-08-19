 
<?php include ("simple_html_dom.php");
include "base.php";
$arrayName = array();
$file1 = "";
$file2 = "";
$file3 = "";

$userInput = $_POST['comment'];  ///////////////////this is the user input from the text area.
$fileName = $GLOBALS['fileName1'];
$html = file_get_html('uploads/'.$fileName);
foreach ($html->find("div.block") as $p) {
	$data = $p->plaintext;
	if (strpos($data, $userInput) !== false) {
		// echo 'Functional';
		fr2();
	}
	else {
		// fr2();
		echo "No class availabe.";
	}
}

function fr2(){
	$dat1 = $GLOBALS['html'];
	$dat2 = $GLOBALS['userInput'];

	
	foreach ($dat1->find("span.typeNameLink") as $p) {
			$data = $p->plaintext;
			echo 'Class: '.$data;
		}
}


?>

