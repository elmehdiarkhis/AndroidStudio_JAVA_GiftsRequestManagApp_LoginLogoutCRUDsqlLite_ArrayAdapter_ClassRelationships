package com.example.exam;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainEnfant extends AppCompatActivity {

    //Element declaration
    public static TextView txtNom;
    public static TextView txtPrenom;
    public static TextView txtPays;
    public static TextView txtVille;
    public static TextView txtCP;
    public static TextView txtAge;
    public static TextView txtCadeau;
    public static TextView txtNs;

    //Command
    String command;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_enfant);

        //Element instrance
        txtNom = (TextView) findViewById(R.id.txtNom_Enf);
        txtPrenom = (TextView) findViewById(R.id.txtPrenom_Enf);
        txtPays = (TextView) findViewById(R.id.txtPays_Enf);
        txtVille = (TextView) findViewById(R.id.txtVille_Enf);
        txtCP = (TextView) findViewById(R.id.txtCP_Enf);
        txtAge = (TextView) findViewById(R.id.txtAge_Enf);
        txtNs = (TextView) findViewById(R.id.txtNs_Enf);
        txtCadeau = (TextView) findViewById(R.id.txtCadeau_Enf);

        //DEMANDE DE REQUETTE POUR SELECT les Enfants  ON LOAD==================
        MyAsyncTask myAsyncTAsk = new MyAsyncTask(MainEnfant.this);
        command = "selectOneEnf";
        String username = MyAsyncTask.username; //(unique)
        myAsyncTAsk.execute(command,username);//on Set le ListView(static)
        //========

    }

    public void deleteSouhait(View view) {

        AlertDialog.Builder Alert = new AlertDialog.Builder(this);
        Alert.setTitle("Message du Pere Noel");
        Alert.setMessage("Etes-tu sur mon Enfants de Vouloir Delete Ton souhait ? veux tu refaire un autre ????");

        Alert.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //DEMANDE DE REQUETTE POUR Delete le Souhait de l'enfant connecter sur ca demande==================
                MyAsyncTask myAsyncTAsk = new MyAsyncTask(MainEnfant.this);
                command = "deleteOneEnf";
                String username = MyAsyncTask.username; //(unique)
                myAsyncTAsk.execute(command,username);//on Set le ListView(static)
                //========

            }
        });

        Alert.setNegativeButton("NON", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        Alert.create();
        Alert.show();

    }


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
