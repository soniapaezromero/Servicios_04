package com.example.paez_sonia_servicios04.Divisas;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paez_sonia_servicios04.Divisas.model.Monedas;
import com.example.paez_sonia_servicios04.Divisas.utilidades.Analisis;
import com.example.paez_sonia_servicios04.R;
import com.example.paez_sonia_servicios04.databinding.ActivityMainDivisasBinding;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static com.example.paez_sonia_servicios04.Divisas.Conversion.convertirDolares;
import static com.example.paez_sonia_servicios04.Divisas.Conversion.convertirEuros;


public class MainActivityDivisas extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainDivisasBinding binding;
    private final String ENLACE = "http://api.exchangeratesapi.io/v1/latest?access_key=84672a9f5d5dc9db750d42dd5d3deecf&symbols=USD&format=1";
    ArrayList<Monedas> monedas = null;
    double cambio;
    Monedas euro;
    Analisis analisis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_divisas);
        binding = ActivityMainDivisasBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.botonconv.setOnClickListener(this);
        descargaOkHTTP(ENLACE);
        binding.eurosDolares.setChecked(true);

    }


    @Override
    public void onClick(View v) {
        if (v == binding.botonconv) {

            try {
                if (binding.eurosDolares.isChecked()) {
                    binding.dolares.setText("");
                    binding.dolares.setText(convertirDolares(binding.euros.getText().toString(), cambio));
                } else {
                    binding.euros.setText("");
                    binding.euros.setText(convertirEuros(binding.dolares.getText().toString(), cambio));
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Error en la conversión: " + e.getMessage(), Toast.LENGTH_SHORT).show();

            }


        }


    }


    private void descargaOkHTTP(String uri) {
        URL web = null;
        try {
            web = new URL(uri);
        } catch (MalformedURLException e) {
            mostrarError("Fallo: " + e.getMessage());
        }
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(web)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        final String responseData = response.body().string();
                        monedas = analisis.analizarMonedas(responseData);//Pasamos el fichero descrgado al metodo anlizar monedas para convertir el json en objeto
                        cambio = monedas.get(0).getRates().getUsd();//Extraemos el valor de dolares si huebierta mas monedas habraia quecer un for para buscar la moneda
                        String valor = String.valueOf(cambio);
                        //Iniciamos la aplicaion conel valor de un dólar a euros
                        binding.euros.setText("1");
                        binding.dolares.setText(convertirDolares(binding.euros.getText().toString(), cambio));
                        // Esto corrige la excepcion :java.lang.RuntimeException: Can't toast on a thread that has not called Looper.prepare()
                        Looper.prepare();
                        Toast.makeText(MainActivityDivisas.this, "Cambio descargado de Euros a Dólares:" + valor, Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    } else {
                        Looper.prepare();
                        mostrarError("Unexpected code: " + response);
                        Looper.loop();
                    }

                }

            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Looper.prepare();
                mostrarError("Fallo: " + e.getMessage());
                Looper.loop();

            }
        });

    }

    private void mostrarError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void mostrarMensaje(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}


