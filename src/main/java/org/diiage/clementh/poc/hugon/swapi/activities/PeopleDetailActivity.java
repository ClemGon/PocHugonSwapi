package org.diiage.clementh.poc.hugon.swapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.diiage.clementh.poc.hugon.swapi.R;
import org.diiage.clementh.poc.hugon.swapi.interfaces.IPeopleService;
import org.diiage.clementh.poc.hugon.swapi.models.People;
import org.diiage.clementh.poc.hugon.swapi.transformations.PeopleListAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleDetailActivity extends AppCompatActivity {

    public final static String PARAM_PEOPLE_URL = "PARAM_PEOPLE_URL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_detail);

        Button btnBack = findViewById(R.id.buttonBackDetail);
        btnBack.setOnClickListener(view -> finish());

        Intent intent = getIntent();

        //find all textView
        TextView txtName = findViewById(R.id.txtNameDetail);
        TextView txtGenre = findViewById(R.id.txtGenreDetail);
        TextView txtBirth = findViewById(R.id.txtBirtYearDetail);
        TextView txtHeight = findViewById(R.id.txtHeightDetail);
        TextView txtMass = findViewById(R.id.txtMassDetail);
        TextView txtHairColor = findViewById(R.id.txtHairColorDetail);
        TextView txtSkinColor = findViewById(R.id.txtSkinColorDetail);
        TextView txtHomeWorld = findViewById(R.id.txtHomeWorldDetail);
        TextView txtCreated = findViewById(R.id.txtCreatedDetail);
        TextView txtEdited = findViewById(R.id.txtEditedDetail);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IPeopleService iPeopleService = retrofit.create(IPeopleService.class);

        iPeopleService.people(intent.getStringExtra(PARAM_PEOPLE_URL)).enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                Log.d("APIDEBUG", "Retrieved " + response.body().name + " People ");
                txtName.setText(response.body().name);
                txtGenre.setText("Gender: " + response.body().gender);
                txtBirth.setText("Birth Day: " +response.body().birthYear);
                txtHeight.setText("Height: " +response.body().height + " Meters");
                txtMass.setText("Mass: " +response.body().mass + " Kg");
                txtHairColor.setText("Hair Color: " +response.body().hairColor);
                txtSkinColor.setText("Skin Color: " +response.body().skinColor);
                txtHomeWorld.setText("Home World: " +response.body().homeWorldUrl);
                txtCreated.setText("Created at: " +response.body().created);
                txtEdited.setText("Edited at: " +response.body().edited);

            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                Log.d("APIDEBUG", "RPROBL7MES ");
            }
        });




    }
}