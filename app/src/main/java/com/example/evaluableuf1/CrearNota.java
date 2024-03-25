package com.example.evaluableuf1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CrearNota extends AppCompatActivity {

    private DataBaseSQL db;

    private Button volver;

    private Button crear;
    private EditText cajaTexto;

    private Intent pasarPantalla;


    ArrayAdapter<String> adaptador;
    ArrayList<String> cadenaTexto = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla3);

        db = new DataBaseSQL(this);

        volver = (Button) findViewById(R.id.botonVolver_Agregar);
        crear = (Button) findViewById(R.id.botonCrear_Agregar);
        cajaTexto = (EditText) findViewById(R.id.cajaTexto_Agregar);


        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cajaTexto.getText().toString().equals("")){
                    Toast.makeText(CrearNota.this, "Nota obligatoria", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.insertarNota(cajaTexto.getText().toString());
                    Toast.makeText(CrearNota.this, "La nota se ha creado correctamente", Toast.LENGTH_SHORT).show();
                    pasarPantalla = new Intent(CrearNota.this, ListadoActivity.class);
                    finish();
                    startActivity(pasarPantalla);
                }
            }
        });


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pasarPantalla = new Intent(CrearNota.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);


            }
        });


    }
}