package com.example.evaluableuf1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BorrarNota extends AppCompatActivity {

    private DataBaseSQL bd;

    private Button volver;
    private Button borrarTodo;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla4);

        bd = new DataBaseSQL(this);

        volver = (Button) findViewById(R.id.botonVolver_Ajustes);
        borrarTodo = (Button) findViewById(R.id.botonBorroarTodo_Ajustes);


        borrarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.borrarTodasNotas();
                Toast.makeText(BorrarNota.this, "Se han borrado todas las notas", Toast.LENGTH_SHORT).show();
                pasarPantalla = new Intent(BorrarNota.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pasarPantalla = new Intent(BorrarNota.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);


            }
        });
    }
}