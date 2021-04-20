package org.diiage.clementh.poc.hugon.swapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.diiage.clementh.poc.hugon.swapi.R;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IPeopleService;
import org.diiage.clementh.poc.hugon.swapi.models.People;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleDetailActivity extends AppCompatActivity {

    public final static String PARAM_PERSON_ID = "PARAM_PERSON_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IPeopleService iPeopleService = retrofit.create(IPeopleService.class);

        iPeopleService.people( Integer.parseInt(PARAM_PERSON_ID)).enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {

            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {

            }
        });




    }
}