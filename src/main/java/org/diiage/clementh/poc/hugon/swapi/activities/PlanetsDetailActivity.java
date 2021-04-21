package org.diiage.clementh.poc.hugon.swapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import org.diiage.clementh.poc.hugon.swapi.R;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IPeopleService;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IPlanetsService;
import org.diiage.clementh.poc.hugon.swapi.models.Planet;
import org.w3c.dom.Text;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlanetsDetailActivity extends AppCompatActivity {

    public final static String PARAM_PELANET_URL = "VIDEVIDEVIDE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets_detail);

        Button btnBack = findViewById(R.id.buttonBackDetailPlanet);
        btnBack.setOnClickListener(view -> finish());


        TextView txtNamePlanets = findViewById(R.id.txtNamePlanetsDetail);
        Intent intent = getIntent();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IPlanetsService iPlanetsService = retrofit.create(IPlanetsService.class);

        iPlanetsService.planet(intent.getStringExtra(PARAM_PELANET_URL)).enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {
                txtNamePlanets.setText(response.body().name);
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {

            }
        });
    }
}