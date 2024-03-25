package com.example.evaluableuf1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {


    private Button botonLlave;
    private Button botonAgrregar;
    private ListView lista;
    private DataBaseSQL bd;
    private Intent pasarPantalla;
    private String texto;
    private Intent pasarPantalla2;

    private ArrayList <String> cadenaTexto = new ArrayList<String>();
    private ArrayAdapter <String> adaptador;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla2);

        bd = new DataBaseSQL(this);
        lista = (ListView) findViewById(R.id.lista_Listado);
        botonLlave = (Button) findViewById(R.id.botonLlave);
        botonAgrregar = (Button) findViewById(R.id.botonAgregar);

        cadenaTexto = bd.getProductos();

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cadenaTexto);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                texto = parent.getItemAtPosition(position).toString();
                pasarPantalla = new Intent(ListadoActivity.this, VerNota.class);
                pasarPantalla.putExtra("valor", texto);
                startActivity(pasarPantalla);
            }
        });




        botonAgrregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(ListadoActivity.this, CrearNota.class);
                finish();
                startActivity(pasarPantalla);

            }
        });
        botonLlave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(ListadoActivity.this, BorrarNota.class);
                startActivity(pasarPantalla);

            }
        });



    }
}