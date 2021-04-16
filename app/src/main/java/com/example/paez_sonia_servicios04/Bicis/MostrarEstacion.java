package com.example.paez_sonia_servicios04.Bicis;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import com.example.paez_sonia_servicios04.R;
import com.example.paez_sonia_servicios04.databinding.ActivityMostrarEstacionBinding;


/**
 * @author :Sonia Páez Romero fecha: 15/03/2021
 * Activity que nos muestra los datos de las estaciones
 */
public class MostrarEstacion extends AppCompatActivity {
  private ActivityMostrarEstacionBinding bindingMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_estacion);
        bindingMostrar = ActivityMostrarEstacionBinding.inflate(getLayoutInflater());
        View view = bindingMostrar.getRoot();
        setContentView(view);
        Bundle extras = getIntent().getExtras();
        String estado=extras.getString("estado");
        int anclas=extras.getInt("anclajes");
        String anclajes= String.valueOf(anclas);
        int disponibles=extras.getInt("bicisDisponibles");
        String bicisDisponibles=String.valueOf(disponibles);
        String actualizacion=extras.getString("actualizacion");
        bindingMostrar.estadobizis.setText(estado);
        bindingMostrar.anclajesBizis.setText(anclajes);
        bindingMostrar.bizisdisponibles.setText(bicisDisponibles);
        bindingMostrar.actualizacionBizis.setText(actualizacion);
        bindingMostrar.btoVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}