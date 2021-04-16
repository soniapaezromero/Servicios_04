package com.example.paez_sonia_servicios04.Divisas.utilidades;

import android.util.Log;

import  com.example.paez_sonia_servicios04.Divisas.model.*;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Analisis {
// He creado un método Array de monedas porque aunque solo tengo una moneda se puede ampliar con el enlace en un futuro
    public  static ArrayList <Monedas> analizarMonedas(String response) {
        JSONObject objeto, jOrates;
        Monedas moneda;
        Rates ratio;
        ArrayList<Monedas> monedas = new ArrayList<>();
        // añadir moneda (en formato JSON) a Monedas

        try {
         //Creamos objeto JSON  con el mensaje descargado  del enlace y pasamos los datos a los POJOS
            objeto = new JSONObject(response);
                moneda = new Monedas();
                moneda.setSuccess(objeto.getBoolean("success"));
                moneda.setTimestamp(objeto.getLong("timestamp"));
                moneda.setBase(objeto.getString("base"));
                moneda.setDate(objeto.getString("rates"));
                jOrates = objeto.getJSONObject("rates");
                ratio = new Rates();
                ratio.setUsd(jOrates.getDouble("USD"));
                moneda.setRates(ratio);

                monedas.add(moneda);

        } catch (JSONException e) {
            Log.e( "JSONException:" ,e.getMessage());
        }
        return monedas;
    }

}
