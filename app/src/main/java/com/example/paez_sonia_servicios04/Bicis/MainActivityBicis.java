package com.example.paez_sonia_servicios04.Bicis;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.paez_sonia_servicios04.*;
import com.example.paez_sonia_servicios04.Bicis.BicisModel.Estaciones;
import com.example.paez_sonia_servicios04.Bicis.BicisModel.Result;
import com.example.paez_sonia_servicios04.Bicis.adaptadores.BicisAdapter;
import com.example.paez_sonia_servicios04.Bicis.adaptadores.ClickListener;
import com.example.paez_sonia_servicios04.Bicis.adaptadores.RecyclerTouchListener;
import com.example.paez_sonia_servicios04.Bicis.networks.ApiAdapter;
import com.example.paez_sonia_servicios04.databinding.ActivityMainBicisBinding;
import com.example.paez_sonia_servicios04.databinding.ItemViewBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author :Sonia Páez Romero fecha: 15/03/2021
 * Activity Principal de nuestra app
 */
public class MainActivityBicis extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBicisBinding bicisBinding;
    private BicisAdapter adapter;
    private ItemViewBinding itembinding;
    public  ArrayList<Result> resultados;
    public String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bicis);
        bicisBinding = ActivityMainBicisBinding.inflate(getLayoutInflater());
        View view = bicisBinding.getRoot();
        setContentView(view);
        adapter = new BicisAdapter();
        bicisBinding.recyclerView.setAdapter(adapter);
        bicisBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        obtenerEstaciones(); //Metodo para obtener la estaciones
        bicisBinding.fab.setOnClickListener(this);
        // Tocando una estacion se abre la ventana que muestra su informacionn
        bicisBinding.recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, bicisBinding.recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Result estacionSeleccionada= resultados.get(position);
                // Pasar a la actividad MostrarEstacion,.java
                Intent intent = new Intent(MainActivityBicis.this, MostrarEstacion.class);
                intent.putExtra("estado", estacionSeleccionada.getTipo());
                intent.putExtra("anclajes",estacionSeleccionada.getPlazas());
                intent.putExtra("bicisDisponibles", estacionSeleccionada.getAnclajes());
                intent.putExtra("actualizacion",estacionSeleccionada.getLastUpdated());
                startActivity(intent);
            }
        }));
    }
        @Override
        public void onClick (View v) {
            if (v == bicisBinding.fab) {
                obtenerEstaciones();
                mostrarError("Datos actualizados");

            }
        }
       // En este método hacemos la llamada de la api y lo utilizamos tanto para  obtenerla como pra actualizar
        public void obtenerEstaciones(){
     Call<Estaciones> estacionesList = ApiAdapter.getInstance().getAllEstaciones();
     estacionesList.enqueue(new Callback<Estaciones>() {
         @Override
         public void onResponse(Call<Estaciones> call, Response<Estaciones> response) {
             if (response.isSuccessful()) {
                 List<Estaciones> estaciones = Collections.singletonList(response.body());   // pasamos  la infromacion rec
                 resultados = new ArrayList<>();
                 for (Estaciones e : estaciones) {
                     resultados = (ArrayList<Result>) e.getResult(); //Pasamos los datos de estaciones a una rray de estaciones
                     adapter.setRepos(resultados);
                     bicisBinding.recyclerView.setAdapter(adapter);

                 }

             }
         }

         @Override
         public void onFailure(Call<Estaciones> call, Throwable t) {     //si falllara el OKHTTp te inforam de fallo
             Log.e("Fallo", t.getLocalizedMessage());

             mostrarError("Fallos: "+ t.getLocalizedMessage());
         }
     });

 }
 //Muestra los errores
    private void mostrarError(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


}






