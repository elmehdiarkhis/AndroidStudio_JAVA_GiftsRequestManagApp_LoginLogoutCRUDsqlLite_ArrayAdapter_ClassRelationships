<?php


    $out = "";

    $servername = 'localhost';
    $username = 'newUser';
    $password = 'pass';
    $databasename = 'exam';
       
    $conn = new mysqli($servername, $username, $password,$databasename);

    if($conn->connect_error){
        $out="orderByNs: error serveur";
    }else{
  
        $niveaudesagesse = intval($_POST['niveaudesagesse']);

        $req = "SELECT * FROM Enfants WHERE niveaudesagesse>$niveaudesagesse";
        $res=$conn->query($req);

        if($res->num_rows != 0)
        {
            $out = "--orderByNs--";
            while ($ligne = $res->fetch_assoc()){
                $counter=0;
                foreach ($ligne as $colomnName => $value)
                {
                    if($colomnName=="id"){
                        $out .= "//".$value.","; 
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
            $out="--orderByNs-- vide";
        }
    }

    echo $out;
?>




