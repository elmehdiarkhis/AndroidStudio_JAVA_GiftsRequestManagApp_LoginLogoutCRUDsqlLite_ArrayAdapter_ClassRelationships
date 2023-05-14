<?php

    $out = "";

    $servername = 'localhost';
    $username = 'newUser';
    $password = 'pass';
    $databasename = 'exam';
       
    $conn = new mysqli($servername, $username, $password,$databasename);

    if($conn->connect_error){
        $out="insert: error serveur";
    }else{

 
        $req = "SELECT id FROM Enfants WHERE nom='$_POST[nom]' AND prenom='$_POST[prenom]';";
        $res=$conn->query($req);
        
        if($res->num_rows == 0)
        {
            $age = intval($_POST['age']);
            $niveaudesagesse = intval($_POST['niveaudesagesse']);
            
            $req2 = "INSERT INTO Enfants (nom,prenom,pays,ville,codepostal,age,cadeau,niveaudesagesse,username,pass) VALUES ('$_POST[nom]','$_POST[prenom]','$_POST[pays]','$_POST[ville]','$_POST[codepostal]',$age,'$_POST[cadeau]',$niveaudesagesse,'$_POST[username]','$_POST[pass]')"; 

            $res2=$conn->query($req2);
            if($res2)
            {
                $out = "insert: succes";
            }       
        }
        else{
            $out = "insert: exist";
        }


    }

    echo $out;

?>




