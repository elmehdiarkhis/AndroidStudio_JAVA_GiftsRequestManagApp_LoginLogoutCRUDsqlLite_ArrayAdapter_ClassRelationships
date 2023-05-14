<?php

    $out = "";

    $servername = 'localhost';
    $username = 'newUser';
    $password = 'pass';
    $databasename = 'exam';
       
    $conn = new mysqli($servername, $username, $password,$databasename);

    if($conn->connect_error){
        $out="login: error serveur";
    }else{
  

        $req = "SELECT username FROM pereNoel WHERE username='$_POST[username]' AND pass='$_POST[pass]';";
        $res=$conn->query($req);

        if($res->num_rows != 0)
        {
            while ($ligne = $res->fetch_assoc()){
                $out ="login: ".$ligne['username'];
            }   
        }else{

            $req2 = "SELECT username FROM Enfants WHERE username='$_POST[username]' AND pass='$_POST[pass]';";
            $res2=$conn->query($req2);

            if($res2->num_rows != 0){
                while ($lignee = $res2->fetch_assoc()){
                    $out ="login: Enfants: ".$lignee['username'];
                }  
            }else{
                $out="login: failed:";
            }
        }
        
    }

    echo $out;
?>




