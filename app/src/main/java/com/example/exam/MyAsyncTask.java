package com.example.exam;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask {

    private Context ctx;

    //Return de doInBackground
    StringBuffer myStringB;
    //=====================

    //apres Login , en sauvegarde le username(unique)==========
    public static String username;
    //===========

    //SELECT ALL================
    public static ArrayList<Enfant> arrayOfEnfant;
    //=======================

    //SELECT BY name===
    public static String[] theUserValues;
    //================

    //Const
    public MyAsyncTask(Context _ctx){
        ctx=_ctx;
    }



    @Override
    protected void onPreExecute() {
//        super.onPreExecute();

    }



    @Override
    //Object... : autant de params de tout type.
    protected Object doInBackground(Object[] param) {
//        return null;


        //LOGIN ===============================================================
        if(param[0]=="login"){

            String myPhpSelect_Url = "http://172.20.10.2/exam/login.php";

            try{

                //Requette========================================
                URL myUrl = new URL(myPhpSelect_Url);

                HttpURLConnection myConn = (HttpURLConnection) myUrl.openConnection();
                myConn.setDoInput(true);
                myConn.setDoOutput(true);
                myConn.setRequestMethod("POST");
                //====================

                //Envoyer la requette===================================================
                OutputStream myOutS = myConn.getOutputStream();
                BufferedWriter myBufW = new BufferedWriter(new OutputStreamWriter(myOutS,"utf-8"));

                //!!!!!!!mettre les Variable dans le Link en parametre!!!!!!!!!
                String msg = URLEncoder.encode("username","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[1]),"utf-8") + "&" + URLEncoder.encode("pass","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[2]),"utf-8");
                //!!!!!!!!!!!!!!=================================

                myBufW.write(msg);
                myBufW.flush();
                myBufW.close();
                myOutS.close();
                //========================================================================


                //Recuperer la Reponse de php dans > myStringB=====================
                InputStream myInpS = myConn.getInputStream();
                BufferedReader myBufR = new BufferedReader(new InputStreamReader(myInpS,"iso-8859-1"));

                String resultat;

                myStringB = new StringBuffer();

                while ( (resultat=myBufR.readLine()) != null ){
                    myStringB.append(resultat + "\n");
                }
                //===================================================



            }catch(Exception ex){
                return ex.getMessage();
            }
        }
        //=============================================================================


        //INSERT===============================================================
        if(param[0]=="insert"){

            String myPhpSelect_Url = "http://172.20.10.2/exam/insert.php";

            try{

                //Requette========================================
                URL myUrl = new URL(myPhpSelect_Url);

                HttpURLConnection myConn = (HttpURLConnection) myUrl.openConnection();
                myConn.setDoInput(true);
                myConn.setDoOutput(true);
                myConn.setRequestMethod("POST");
                //====================

                //Envoyer la requette===================================================
                OutputStream myOutS = myConn.getOutputStream();
                BufferedWriter myBufW = new BufferedWriter(new OutputStreamWriter(myOutS,"utf-8"));

                //!!!!!!!mettre les Variable dans le Link en parametre!!!!!!!!!
                String msg = URLEncoder.encode("nom","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[1]),"utf-8") + "&" + URLEncoder.encode("prenom","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[2]),"utf-8") + "&" + URLEncoder.encode("pays","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[3]),"utf-8")+ "&" + URLEncoder.encode("ville","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[4]),"utf-8")+ "&" + URLEncoder.encode("codepostal","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[5]),"utf-8")+ "&" + URLEncoder.encode("age","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[6]),"utf-8")+ "&" + URLEncoder.encode("cadeau","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[7]),"utf-8")+ "&" + URLEncoder.encode("niveaudesagesse","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[8]),"utf-8")+ "&" + URLEncoder.encode("username","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[9]),"utf-8")+ "&" + URLEncoder.encode("pass","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[10]),"utf-8");
                //!!!!!!!!!!!!!!=================================

                myBufW.write(msg);
                myBufW.flush();
                myBufW.close();
                myOutS.close();
                //========================================================================


                //Recuperer la Reponse de php dans > myStringB=====================
                InputStream myInpS = myConn.getInputStream();
                BufferedReader myBufR = new BufferedReader(new InputStreamReader(myInpS,"iso-8859-1"));

                String resultat;

                myStringB = new StringBuffer();

                while ( (resultat=myBufR.readLine()) != null ){
                    myStringB.append(resultat + "\n");
                }
                //===================================================



            }catch(Exception ex){
                return ex.getMessage();
            }
        }
        //=============================================================================



        //SELECT ALL REQUETTE===============================================================
        if(param[0]=="selectAll"){
            String myPhpSelect_Url = "http://172.20.10.2/exam/selectAll.php";

            try{
                //Requette========================================
                URL myUrl = new URL(myPhpSelect_Url);
                HttpURLConnection myConn = (HttpURLConnection) myUrl.openConnection();
                myConn.setDoInput(true);
                myConn.setDoOutput(true);
                myConn.setRequestMethod("POST");
                //====================

                //Envoyer la requette===================================================
                OutputStream myOutS = myConn.getOutputStream();
                BufferedWriter myBufW = new BufferedWriter(new OutputStreamWriter(myOutS,"utf-8"));

                myBufW.flush();
                myBufW.close();
                myOutS.close();
                //========================================================================

                //Recuperer la Reponse de php dans > myStringB=====================
                InputStream myInpS = myConn.getInputStream();
                BufferedReader myBufR = new BufferedReader(new InputStreamReader(myInpS,"iso-8859-1"));

                String resultat;

                myStringB = new StringBuffer();

                while ( (resultat=myBufR.readLine()) != null ){
                    myStringB.append(resultat + "\n");
                }
                //===================================================


            }catch(Exception ex){
                return ex.getMessage();
            }
        }
        //=============================================================================



        //SELECT BY name : REQUETTE===============================================================
        if(param[0]=="selectByName"){
            String myPhpSelect_Url = "http://172.20.10.2/exam/selectByName.php";

            try{

                //Requette========================================
                URL myUrl = new URL(myPhpSelect_Url);
                HttpURLConnection myConn = (HttpURLConnection) myUrl.openConnection();
                myConn.setDoInput(true);
                myConn.setDoOutput(true);
                myConn.setRequestMethod("POST");
                //====================

                //Envoyer la requette===================================================
                OutputStream myOutS = myConn.getOutputStream();
                BufferedWriter myBufW = new BufferedWriter(new OutputStreamWriter(myOutS,"utf-8"));

                //!!!!!!!mettre les Variable dans le Link en parametre!!!!!!!!!
                String msg = URLEncoder.encode("nom","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[1]),"utf-8");
                //!!!!!!!!!!!!!!=================================

                myBufW.write(msg);
                myBufW.flush();
                myBufW.close();
                myOutS.close();
                //========================================================================

                //Recuperer la Reponse de php dans > myStringB=====================
                InputStream myInpS = myConn.getInputStream();
                BufferedReader myBufR = new BufferedReader(new InputStreamReader(myInpS,"iso-8859-1"));

                String resultat;

                myStringB = new StringBuffer();

                while ( (resultat=myBufR.readLine()) != null ){
                    myStringB.append(resultat + "\n");
                }
                //===================================================

            }catch(Exception ex){
                return ex.getMessage();
            }
        }
        //=============================================================================

        //ODDER BY Ns : REQUETTE===============================================================
        if(param[0]=="orderByNs"){
            String myPhpSelect_Url = "http://172.20.10.2/exam/orderByNs.php";

            try{

                //Requette========================================
                URL myUrl = new URL(myPhpSelect_Url);
                HttpURLConnection myConn = (HttpURLConnection) myUrl.openConnection();
                myConn.setDoInput(true);
                myConn.setDoOutput(true);
                myConn.setRequestMethod("POST");
                //====================

                //Envoyer la requette===================================================
                OutputStream myOutS = myConn.getOutputStream();
                BufferedWriter myBufW = new BufferedWriter(new OutputStreamWriter(myOutS,"utf-8"));

                //!!!!!!!mettre les Variable dans le Link en parametre!!!!!!!!!
                String msg = URLEncoder.encode("niveaudesagesse","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[1]),"utf-8");
                //!!!!!!!!!!!!!!=================================

                myBufW.write(msg);
                myBufW.flush();
                myBufW.close();
                myOutS.close();
                //========================================================================

                //Recuperer la Reponse de php dans > myStringB=====================
                InputStream myInpS = myConn.getInputStream();
                BufferedReader myBufR = new BufferedReader(new InputStreamReader(myInpS,"iso-8859-1"));

                String resultat;

                myStringB = new StringBuffer();

                while ( (resultat=myBufR.readLine()) != null ){
                    myStringB.append(resultat + "\n");
                }
                //===================================================

            }catch(Exception ex){
                return ex.getMessage();
            }
        }
        //=============================================================================

        //SELECT BY userName One Enfants Profile : REQUETTE===============================================================
        if(param[0]=="selectOneEnf"){
            String myPhpSelect_Url = "http://172.20.10.2/exam/selectOneEnf.php";

            try{

                //Requette========================================
                URL myUrl = new URL(myPhpSelect_Url);
                HttpURLConnection myConn = (HttpURLConnection) myUrl.openConnection();
                myConn.setDoInput(true);
                myConn.setDoOutput(true);
                myConn.setRequestMethod("POST");
                //====================

                //Envoyer la requette===================================================
                OutputStream myOutS = myConn.getOutputStream();
                BufferedWriter myBufW = new BufferedWriter(new OutputStreamWriter(myOutS,"utf-8"));

                //!!!!!!!mettre les Variable dans le Link en parametre!!!!!!!!!
                String msg = URLEncoder.encode("username","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[1]),"utf-8");
                //!!!!!!!!!!!!!!=================================

                myBufW.write(msg);
                myBufW.flush();
                myBufW.close();
                myOutS.close();
                //========================================================================

                //Recuperer la Reponse de php dans > myStringB=====================
                InputStream myInpS = myConn.getInputStream();
                BufferedReader myBufR = new BufferedReader(new InputStreamReader(myInpS,"iso-8859-1"));

                String resultat;

                myStringB = new StringBuffer();

                while ( (resultat=myBufR.readLine()) != null ){
                    myStringB.append(resultat + "\n");
                }
                //===================================================

            }catch(Exception ex){
                return ex.getMessage();
            }
        }
        //=============================================================================


        //SELECT BY userName One Enfants Profile : REQUETTE===============================================================
        if(param[0]=="deleteOneEnf"){
            String myPhpSelect_Url = "http://172.20.10.2/exam/deleteOneEnf.php";

            try{

                //Requette========================================
                URL myUrl = new URL(myPhpSelect_Url);
                HttpURLConnection myConn = (HttpURLConnection) myUrl.openConnection();
                myConn.setDoInput(true);
                myConn.setDoOutput(true);
                myConn.setRequestMethod("POST");
                //====================

                //Envoyer la requette===================================================
                OutputStream myOutS = myConn.getOutputStream();
                BufferedWriter myBufW = new BufferedWriter(new OutputStreamWriter(myOutS,"utf-8"));

                //!!!!!!!mettre les Variable dans le Link en parametre!!!!!!!!!
                String msg = URLEncoder.encode("username","utf-8") + "=" + URLEncoder.encode(String.valueOf(param[1]),"utf-8");
                //!!!!!!!!!!!!!!=================================

                myBufW.write(msg);
                myBufW.flush();
                myBufW.close();
                myOutS.close();
                //========================================================================

                //Recuperer la Reponse de php dans > myStringB=====================
                InputStream myInpS = myConn.getInputStream();
                BufferedReader myBufR = new BufferedReader(new InputStreamReader(myInpS,"iso-8859-1"));

                String resultat;

                myStringB = new StringBuffer();

                while ( (resultat=myBufR.readLine()) != null ){
                    myStringB.append(resultat + "\n");
                }
                //===================================================

            }catch(Exception ex){
                return ex.getMessage();
            }
        }
        //=============================================================================



        //return la response=========
        return  myStringB.toString();
        //==========================

    }

    @Override
    protected void onPostExecute(Object o) {
//        super.onPostExecute(o);

        String response = (String) o;
        response = response.trim();

        //GESTION ERREUR PHP========================================
        if(response.contains("error serveur")){
            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Message du Pere Noel");
            builder.setMessage("Ouch!! Une Erreur du serveur est survenu , veuillez ressayer plus tard");
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        //=============================================================


        //LOGIN=============================================================
        if(response.contains("login:")){
            if(response.contains("failed")){
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Message du Pere Noel");
                builder.setMessage("Username ou Password incorrecte");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
            else{
                //Si c l'enfants qui c LOGIN
                if(response.contains("Enfants:")){
                    response = response.replace("Enfants:", "");
                    //recuperer le username (unique) de L'Enfants qui c connecter
                    String[] array = response.split(":");
                    username = array[1].trim();
                    //========
                    Intent i = new Intent(ctx,MainEnfant.class);
                    ctx.startActivity(i);
                }
                //Si c le Pere Noeal qui c LOGIN
                else{
                    //recuperer le username (unique) du pereNoel qui c connecter
                    String[] array = response.split(":");
                    username = array[1].trim();
                    //========
                    Intent i = new Intent(ctx,MainActivity.class);
                    ctx.startActivity(i);
                }
            }
        }
        //=================================================================

        //INSERT============================================================
        else if(response.contains("insert")){

            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Message du Pere Noel");

            if(response.contains("exist")){
                builder.setMessage("Vous avez deja soumis Un Souhait Avant.  Vous avez le Droit a juste 1 seul Souhait par Christmas");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }else if(response.contains("succes")){
                builder.setMessage("Mon Enfant :) ton Souhait a ete Enregistrer avec succes !! ;) ");
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

        }
        //=================================================================


        //SELECT ALL========================================================
        else if(response.contains("--selectAll--")){
            response = response.replace("--selectAll--", "");

            //chaque case du tableau , represente toute une ligne d'enregistrement
            String[] arrayOfLignes = response.split("//");

            arrayOfEnfant = new ArrayList<>();

            //en boucle dans les lignes pour creer des ptit tableau de valeur
            for(int i=1;i<arrayOfLignes.length;i++){

                //chaque case de ce nouveau tableau , represente une case de ligne[i]
                String[] arrayOfValues = arrayOfLignes[i].split(",");

                int id = Integer.parseInt(arrayOfValues[0]);
                String nom = arrayOfValues[1];
                String prenom = arrayOfValues[2];
                String pays = arrayOfValues[3];
                String ville = arrayOfValues[4];
                String codePostal = arrayOfValues[5];
                int age = Integer.parseInt(arrayOfValues[6]);
                String cadeau = arrayOfValues[7];
                int nivDeSagesse = Integer.parseInt(arrayOfValues[8]);

                //Ajouter Dynamiquement a chaque itteration , un nouveau enfant dans l'array qui va etre utiliser pour peupler le ListView
                arrayOfEnfant.add(new Enfant(id,nom,prenom,pays,ville,codePostal,age,cadeau,nivDeSagesse));
            }

            //Adapter le ListView avec l'array
            try{
                myAdapterC adapter = new myAdapterC
                        (ctx,R.layout.one_listview_ligne_layout,arrayOfEnfant);
                MainActivity.lstEnfant.setAdapter(adapter);
            }catch (Exception ex){
                Log.i("error",ex.getMessage());
            }
        }
        //=================================================================



        //SELECT BY Name==========================================================
        else if (response.contains("--selectByName--")){

            if(response.contains("vide")){
                arrayOfEnfant = new ArrayList<>();
                //Adapter le ListView avec le nouvelle Array l'array
                try{
                    myAdapterC adapter = new myAdapterC
                            (ctx,R.layout.one_listview_ligne_layout,arrayOfEnfant);
                    MainActivity.lstEnfant.setAdapter(adapter);
                    return;
                }catch (Exception ex){
                    Log.i("error",ex.getMessage());
                }
            }
            response = response.replace("--selectByName--", "");

            response = response.replace(",", " ");
            theUserValues = response.split(" ");

            arrayOfEnfant = new ArrayList<>();
            int id = Integer.parseInt(theUserValues[0]);
            String nom = theUserValues[1];
            String prenom = theUserValues[2];
            String pays = theUserValues[3];
            String ville = theUserValues[4];
            String codePostal = theUserValues[5];
            int age = Integer.parseInt(theUserValues[6]);
            String cadeau = theUserValues[7];
            int nivDeSagesse = Integer.parseInt(theUserValues[8]);

            arrayOfEnfant.add(new Enfant(id,nom,prenom,pays,ville,codePostal,age,cadeau,nivDeSagesse));

            //Adapter le ListView avec le nouvelle Array l'array
            try{
                myAdapterC adapter = new myAdapterC
                        (ctx,R.layout.one_listview_ligne_layout,arrayOfEnfant);
                MainActivity.lstEnfant.setAdapter(adapter);
            }catch (Exception ex){
                Log.i("error",ex.getMessage());
            }
        }
        //=================================================================


        //ORDER By Ns========================================================
        else if(response.contains("--orderByNs--")){

            response = response.replace("--orderByNs--", "");

            //chaque case du tableau , represente toute une ligne d'enregistrement
            String[] arrayOfLignes = response.split("//");

            arrayOfEnfant = new ArrayList<>();

            //en boucle dans les lignes pour creer des ptit tableau de valeur
            for(int i=1;i<arrayOfLignes.length;i++){

                //chaque case de ce nouveau tableau , represente une case de ligne[i]
                String[] arrayOfValues = arrayOfLignes[i].split(",");

                int id = Integer.parseInt(arrayOfValues[0]);
                String nom = arrayOfValues[1];
                String prenom = arrayOfValues[2];
                String pays = arrayOfValues[3];
                String ville = arrayOfValues[4];
                String codePostal = arrayOfValues[5];
                int age = Integer.parseInt(arrayOfValues[6]);
                String cadeau = arrayOfValues[7];
                int nivDeSagesse = Integer.parseInt(arrayOfValues[8]);

                //Ajouter Dynamiquement a chaque itteration , un nouveau enfant dans l'array qui va etre utiliser pour peupler le ListView
                arrayOfEnfant.add(new Enfant(id,nom,prenom,pays,ville,codePostal,age,cadeau,nivDeSagesse));
            }

            //Adapter le ListView avec l'array
            try{
                myAdapterC adapter = new myAdapterC
                        (ctx,R.layout.one_listview_ligne_layout,arrayOfEnfant);
                MainActivity.lstEnfant.setAdapter(adapter);
            }catch (Exception ex){
                Log.i("error",ex.getMessage());
            }
        }
        //=================================================================

        //SELECT BY USERNAME==========================================================
        else if (response.contains("--selectOneEnf--")){
            response = response.replace("--selectOneEnf--", "");

            response = response.replace(",", " ");
            theUserValues = response.split(" ");

            arrayOfEnfant = new ArrayList<>();
            int id = Integer.parseInt(theUserValues[0]);
            String nom = theUserValues[1];
            String prenom = theUserValues[2];
            String pays = theUserValues[3];
            String ville = theUserValues[4];
            String codePostal = theUserValues[5];
            int age = Integer.parseInt(theUserValues[6]);
            String cadeau = theUserValues[7];
            int nivDeSagesse = Integer.parseInt(theUserValues[8]);

            //set the MainEnfant Element (static) ================
            MainEnfant.txtNom.setText(nom);
            MainEnfant.txtPrenom.setText(prenom);
            MainEnfant.txtPays.setText(pays);
            MainEnfant.txtVille.setText(ville);
            MainEnfant.txtCP.setText(codePostal);
            MainEnfant.txtAge.setText(String.valueOf(age));
            MainEnfant.txtCadeau.setText(cadeau);
            MainEnfant.txtNs.setText(String.valueOf(nivDeSagesse));
            //=====================================================


            arrayOfEnfant.add(new Enfant(id,nom,prenom,pays,ville,codePostal,age,cadeau,nivDeSagesse));

        }
        //=================================================================


        //DELETE BY USERNAME==========================================================
        else if (response.contains("--deleteOneEnf--")){
            if(response.contains("succes")){
                Intent i = new Intent(ctx,First.class);
                ctx.startActivity(i);
            }else{
                Toast.makeText(ctx, "Erreur serveur 404", Toast.LENGTH_SHORT).show();
            }
        }
        //=================================================================

    }
}
