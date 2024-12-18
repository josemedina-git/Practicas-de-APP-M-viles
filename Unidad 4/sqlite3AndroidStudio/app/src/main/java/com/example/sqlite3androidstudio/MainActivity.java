package com.example.sqlite3androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sqlite3androidstudio.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button btnCrear, btnAgregarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear = findViewById(R.id.btnCrear);
        btnAgregarRegistro = findViewById(R.id.btnAgregarRegistro);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnAgregarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NuevoActivity.class);
                startActivity(intent);
            }
        });
    }
}