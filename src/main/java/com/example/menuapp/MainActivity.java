package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar a Toolbar como ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.carrinho) {
            Toast.makeText(MainActivity.this, "Clicou para ver o carrinhp", Toast.LENGTH_LONG).show();
        } else if (id == R.id.sair) {
            Toast.makeText(MainActivity.this, "Clicou para sair", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Clicou para ver o perfil", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}

