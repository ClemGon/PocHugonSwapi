package org.diiage.clementh.poc.hugon.swapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import org.diiage.clementh.poc.hugon.swapi.R;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IPlanetsService;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IStarShipService;
import org.diiage.clementh.poc.hugon.swapi.models.Planet;
import org.diiage.clementh.poc.hugon.swapi.models.SWModelList;
import org.diiage.clementh.poc.hugon.swapi.models.Starship;
import org.diiage.clementh.poc.hugon.swapi.transformations.PlanetsListAdapter;
import org.diiage.clementh.poc.hugon.swapi.transformations.StarShipListAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarshipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starships);

        Button btnBack = findViewById(R.id.buttonBackStarShips);
        btnBack.setOnClickListener(view -> finish());

        RecyclerView lstStarShip = findViewById(R.id.lstStarShip);
        lstStarShip.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IStarShipService iStarShipService = retrofit.create(IStarShipService.class);

        iStarShipService.listStarship().enqueue(new Callback<SWModelList<Starship>>() {
            @Override
            public void onResponse(Call<SWModelList<Starship>> call, Response<SWModelList<Starship>> response) {
                if (response.isSuccessful()){
                    Log.d("API", "Retrieved " + response.body().results + " Starship ");

                    StarShipListAdapter starShipListAdapter = new StarShipListAdapter(response.body().results);
                    lstStarShip.setAdapter(starShipListAdapter);
                }
            }

            @Override
            public void onFailure(Call<SWModelList<Starship>> call, Throwable t) {

            }
        });






    }
}