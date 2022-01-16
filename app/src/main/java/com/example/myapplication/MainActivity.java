package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                AlertDialog.Builder alert  = new AlertDialog.Builder(this);
                alert.setMessage("Password Manager v1.0")
                        .setNeutralButton("Ok",null)
                        .show();
                return true;
            case R.id.configs:
                Intent intentConfig = new Intent(this, PreferencesActivity.class);
                startActivity(intentConfig);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void entrarClicado(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String prefLogin = sharedPreferences.getString("Login", "");
        String prefPass = sharedPreferences.getString("Senha", "");
        String editLogin = ((EditText) findViewById(R.id.editLogin)).getText().toString();
        String editPass = ((EditText) findViewById(R.id.editSenha)).getText().toString();
        if (editLogin.equals(prefLogin) && editPass.equals(prefPass)) {
            Intent intent = new Intent(this, ListActivity.class);
            EditText inputLogin = findViewById(R.id.editLogin);
            intent.putExtra("login", inputLogin.getText().toString());
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Login/senha inválidos!", Toast.LENGTH_SHORT).show();
    }
}