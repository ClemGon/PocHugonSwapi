package org.diiage.clementh.poc.hugon.swapi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.diiage.clementh.poc.hugon.swapi.R;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IPeopleService;
import org.diiage.clementh.poc.hugon.swapi.models.People;
import org.diiage.clementh.poc.hugon.swapi.models.SWModelList;
import org.diiage.clementh.poc.hugon.swapi.transformations.PeopleListAdapter;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        RecyclerView lstPeople = findViewById(R.id.LstPeople);
        lstPeople.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IPeopleService iPeopleService = retrofit.create(IPeopleService.class);

        iPeopleService.listPeoples().enqueue(new Callback<SWModelList<People>>() {
            @Override
            public void onResponse(Call<SWModelList<People>> call, Response<SWModelList<People>> response) {
                if (response.isSuccessful()){
                    Log.d("API", "Retrieved " + response.body().results + " People ");




                    PeopleListAdapter peopleListAdapter = new PeopleListAdapter(response.body().results);
                    lstPeople.setAdapter(peopleListAdapter);
                }
            }

            @Override
            public void onFailure(Call<SWModelList<People>> call, Throwable t) {

            }
        });

    }





}