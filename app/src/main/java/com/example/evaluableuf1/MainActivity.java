package com.example.evaluableuf1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

private Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla1);

        TimerTask myTimerTask = new TimerTask() {
            @Override
            public void run() {

                //codigo que se ejecuta tras la espera
                //por ejemplo, codigo para pasar a la siguiente actividad

                pasarPantalla = new Intent(MainActivity.this, ListadoActivity.class);
                finish();
                startActivity(pasarPantalla);


            }

        };
        //new timer
        Timer timer = new Timer();
        //Schedule timer
        timer.schedule(myTimerTask,2000);
    }
}