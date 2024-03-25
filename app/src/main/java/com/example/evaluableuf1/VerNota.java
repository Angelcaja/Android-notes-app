package com.example.evaluableuf1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerNota extends AppCompatActivity {

    private Button botonBorrar;
    private Button botonVolver;
    private TextView cajaTexto2;
    private DataBaseSQL db;

    private Intent pasarPantalla;
    private String paquete1;
    private Bundle extras;
    private String texto1;
    private String texto2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla5);

        db  = new DataBaseSQL(this);

        botonBorrar = (Button) findViewById(R.id.botonBorrar_VerNota);
        botonVolver = (Button) findViewById(R.id.botonVolver_VerNota);
        cajaTexto2 = (TextView) findViewById(R.id.infoNota2_VerNota);
        extras = getIntent().getExtras();

        if (extras!=null){
            paquete1 = extras.getString("valor");
            cajaTexto2.setText(paquete1);

        }else{
            Toast.makeText(VerNota.this,"La nota está vacia", Toast.LENGTH_SHORT).show();
        }

        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] partes = paquete1.split("-.");

                texto1= partes[1];
                texto2= partes[0];


                db.borrarNota(texto2);
                pasarPantalla = new Intent(VerNota.this, ListadoActivity.class);
                startActivity(pasarPantalla);


            }
        });

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pasarPantalla = new Intent(VerNota.this, ListadoActivity.class);
                startActivity(pasarPantalla);


            }
        });

    }
}