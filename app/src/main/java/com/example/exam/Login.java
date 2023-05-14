package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtUserName = findViewById(R.id.idEdtUserName);
        edtPassword = findViewById(R.id.idEdtPassword);
        btnLogin = findViewById(R.id.idBtnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString();
                String pass = edtPassword.getText().toString();

                //DEMANDE DE REQUETTE pou check le Login==================
                MyAsyncTask myAsyncTAsk = new MyAsyncTask(Login.this);
                String command = "login";
                myAsyncTAsk.execute(command,userName,pass);
                //===========================

            }
        });
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
