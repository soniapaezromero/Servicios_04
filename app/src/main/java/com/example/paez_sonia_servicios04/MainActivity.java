package com.example.paez_sonia_servicios04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paez_sonia_servicios04.Bicis.MainActivityBicis;
import com.example.paez_sonia_servicios04.Divisas.MainActivityDivisas;

public class MainActivity extends AppCompatActivity {

    Button ejercicioDivisas;
    Button ejercicioBicis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ejercicioDivisas= findViewById(R.id.btEjercicio1);
        ejercicioBicis= findViewById(R.id.bttEjercicio2);
        ejercicioDivisas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(), MainActivityDivisas.class);
                startActivity(intento);
            }
        });
        ejercicioBicis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(), MainActivityBicis.class);
                startActivity(intento);
            }
        });
    }
}