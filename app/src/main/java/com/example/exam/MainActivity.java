package com.example.exam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //ListView (static) pour l'utiliser dans l'asyncTask et pour faire ici le setOnItemLongClickListener si necessaire
    public static ListView lstEnfant;
    //===

    //AsyncTask tache===
    String command;
    //=====

    //Filter
    public EditText txtFilterName;
    public EditText txtFilteNs;
    //===

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //=Filter==
        txtFilterName = (EditText) findViewById(R.id.filterName_ID);
        txtFilteNs = (EditText) findViewById(R.id.filterNS_ID);
        //=====

        //listView
        lstEnfant = findViewById(R.id.lstUsers);
        //===

        //DEMANDE DE REQUETTE POUR SELECT les Enfants  ON LOAD==================
        MyAsyncTask myAsyncTAsk = new MyAsyncTask(MainActivity.this);
        command = "selectAll";
        myAsyncTAsk.execute(command);//on Set le ListView(static)
        //========
    }

    //FILTERS=======================================================================================
    public void filterByNom(View view) {
        String nom = txtFilterName.getText().toString();

        if(nom.length()==0){
            AlertDialog.Builder Alert = new AlertDialog.Builder(this);
            Alert.setTitle("Message du Pere Noel");
            Alert.setMessage("Veuillez enter un username a chercher SVP!!!");
            Alert.create();
            Alert.show();
            return;
        }else{
            //DEMANDE DE REQUETTE POUR Select les Enfant By Name ==================
            MyAsyncTask myAsyncTAsk = new MyAsyncTask(MainActivity.this);
            command = "selectByName";
            myAsyncTAsk.execute(command,nom);
            //========
        }
    }

    public void filterSuperieurAtNs(View view) {
        String ns = txtFilteNs.getText().toString();

        //validation 1
        if(ns.length()==0){
            AlertDialog.Builder Alert = new AlertDialog.Builder(this);
            Alert.setTitle("Message du Pere Noel");
            Alert.setMessage("veuillez entrer une valeur de Niveau de Sagesse SVP!!!");
            Alert.create();
            Alert.show();
            return;
        }
        //====


        try {
            int num = Integer.parseInt(ns); //si string > NumberFormatException
            //validation2
            if(num<1 || num>10){
                AlertDialog.Builder Alert = new AlertDialog.Builder(this);
                Alert.setTitle("Message du Pere Noel");
                Alert.setMessage("veuillez entrer un numero entre 1 et 10!!!");
                Alert.create();
                Alert.show();
                return;
            }//OK==============
            else{
                //DEMANDE DE REQUETTE POUR DELETE un User ==================
                MyAsyncTask myAsyncTAsk = new MyAsyncTask(MainActivity.this);
                command = "orderByNs";
                myAsyncTAsk.execute(command,num);
                //========
            }
        } //Check si c'est un numero ou pas =======================
        catch (NumberFormatException e) {
            AlertDialog.Builder Alert = new AlertDialog.Builder(this);
            Alert.setTitle("Message du Pere Noel");
            Alert.setMessage("veuillez entrer un numero non pas une String!!!");
            Alert.create();
            Alert.show();
            return;
        }
        //=======================================================

    }

    public void reset(View view) {
        //DEMANDE DE REQUETTE POUR SELECT les Enfant==================
        MyAsyncTask myAsyncTAsk = new MyAsyncTask(MainActivity.this);
        command = "selectAll";
        myAsyncTAsk.execute(command);//on Set un ListView lstUsers dans myAsyncTask (public static)
    }
    //==============================================================================================


    //    //Menu======================================================
    @Override
    public boolean onCreateOptionsMenu(Menu _menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item_login, _menu);
        return true;
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.login_item_Menu:
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                return true;

            case R.id.register_item_Menu:
                Intent in = new Intent(getApplicationContext(),InsertGift.class);
                startActivity(in);
                return true;

            case R.id.home_item_Menu:
                Intent inte = new Intent(getApplicationContext(),First.class);
                startActivity(inte);
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }
    }
    //=========================================
}