package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class First extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //====
        setContentView(R.layout.first);


    }

    public void goToInsert(View view) {
        Intent i = new Intent(getApplicationContext(),InsertGift.class);
        startActivity(i);
    }

    public void goToLogin(View view) {
        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
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
