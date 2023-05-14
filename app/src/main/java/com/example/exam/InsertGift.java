package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class InsertGift extends AppCompatActivity {

    public EditText edtNom;
    public EditText edtPrenom;
    public EditText edtPays ;
    public EditText edtVille;
    public EditText edtCodePostal;
    public EditText edtAge;
    public EditText edtCadeau;
    public EditText edtNivDeSagesse;
    public EditText edtUsername;
    public EditText edtPassword;


    //Pour Afficher des message
    AlertDialog.Builder Alert;
    //==============


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertgift);

        edtNom = (EditText) findViewById(R.id.i_nom);
        edtPrenom = (EditText) findViewById(R.id.i_prenom);
        edtPays = (EditText) findViewById(R.id.i_pays);
        edtVille = (EditText) findViewById(R.id.i_ville);
        edtCodePostal = (EditText) findViewById(R.id.i_codeP);
        edtAge = (EditText) findViewById(R.id.i_age);
        edtCadeau = (EditText) findViewById(R.id.i_cadeau);
        edtNivDeSagesse = (EditText) findViewById(R.id.i_nivDeSagess);
        edtUsername = (EditText) findViewById(R.id.i_Username);
        edtPassword= (EditText) findViewById(R.id.i_Pass);

        //Alert Dialogue Initialisation
        Alert = new AlertDialog.Builder(this);
        Alert.setTitle("Message du Pere Noel");
        //=====
    }

    public void soumettre(View view) {

        String nom = edtNom.getText().toString();
        String prenom = edtPrenom.getText().toString();
        String pays = edtPays.getText().toString();
        String ville = edtVille.getText().toString();
        String codeP = edtCodePostal.getText().toString();
        String cadeau = edtCadeau.getText().toString();
        String username = edtUsername.getText().toString();
        String pass = edtPassword.getText().toString();



        if(nom.length()==0 || prenom.length()==0 || pays.length()==0 || ville.length()==0 || codeP.length()==0 || cadeau.length()==0){
            Alert.setMessage("Touts les Champs doivent etre Remplie , SVP :)!!");
            Alert.create();
            Alert.show();
            return;
        }

        int age = Integer.parseInt(edtAge.getText().toString());
        if(age<1 || age>14){
            Alert.setMessage("C'est que les enfant qui ont entre 1 et 14 qui ont le Droit de Faire des Souhait de Cadeau!!");
            Alert.create();
            Alert.show();
            return;
        }

        int nivDeSagesse = Integer.parseInt(edtNivDeSagesse.getText().toString());
        if(nivDeSagesse<1 || nivDeSagesse>10){
            Alert.setMessage("Votre Niveau de Sagesse doit etre compris entre 1 et 10");
            Alert.create();
            Alert.show();
            return;
        }


        //DEMANDE DE REQUETTE pour Insert le Souhait==================
        MyAsyncTask myAsyncTAsk = new MyAsyncTask(InsertGift.this);
        String command = "insert";
        myAsyncTAsk.execute(command,nom,prenom,pays,ville,codeP,age,cadeau,nivDeSagesse,username,pass);
        //===========================
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
