<?php


    $out = "";

    $servername = 'localhost';
    $username = 'newUser';
    $password = 'pass';
    $databasename = 'exam';
       
    $conn = new mysqli($servername, $username, $password,$databasename);

    if($conn->connect_error){
        $out="selectOneEnf: error serveur";
    }else{
  
        $req = "SELECT * FROM Enfants WHERE username='$_POST[username]'";
        $res=$conn->query($req);

        
        if($res->num_rows != 0)
        {
            
            while ($ligne = $res->fetch_assoc()){
                $counter=0;
                foreach ($ligne as $colomnName => $value)
                {
                    if($colomnName=="id"){
                        $out .= "--selectOneEnf--".$value.","; 
                    }else{
                        if($counter%10==0){
                            $out .= $value; 
                        }else{
                            $out .= $value.","; 
                        }
                    } 
                     $counter++;             
                }
            }
        }else{
            $out="selectOneEnf: vide";
        }

        
    }

    echo $out;
?>




