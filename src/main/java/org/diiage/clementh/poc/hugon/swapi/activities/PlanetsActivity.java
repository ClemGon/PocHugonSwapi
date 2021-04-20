package org.diiage.clementh.poc.hugon.swapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import org.diiage.clementh.poc.hugon.swapi.R;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IPeopleService;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IPlanetsService;
import org.diiage.clementh.poc.hugon.swapi.models.People;
import org.diiage.clementh.poc.hugon.swapi.models.Planet;
import org.diiage.clementh.poc.hugon.swapi.models.SWModelList;
import org.diiage.clementh.poc.hugon.swapi.transformations.PeopleListAdapter;
import org.diiage.clementh.poc.hugon.swapi.transformations.PlanetsListAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlanetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        Button btnBack = findViewById(R.id.buttonBackPlanets);
        btnBack.setOnClickListener(view -> finish());

        RecyclerView lstPlanets = findViewById(R.id.lstPlanets);
        lstPlanets.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IPlanetsService iPlanetsService = retrofit.create(IPlanetsService.class);

        iPlanetsService.listPlanets().enqueue(new Callback<SWModelList<Planet>>() {
            @Override
            public void onResponse(Call<SWModelList<Planet>> call, Response<SWModelList<Planet>> response) {
                if (response.isSuccessful()){
                    Log.d("API", "Retrieved " + response.body().results + " Planet ");

                    PlanetsListAdapter planetsListAdapter = new PlanetsListAdapter(response.body().results);
                    lstPlanets.setAdapter(planetsListAdapter);
                }
            }

            @Override
            public void onFailure(Call<SWModelList<Planet>> call, Throwable t) {

            }
        });
    }
}