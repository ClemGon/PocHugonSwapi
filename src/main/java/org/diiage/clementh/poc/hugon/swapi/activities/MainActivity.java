package org.diiage.clementh.poc.hugon.swapi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import org.diiage.clementh.poc.hugon.swapi.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToPeople = findViewById(R.id.buttonPeople);
        btnGoToPeople.setOnClickListener(view -> {
            Intent intent = new Intent(this, PeopleActivity.class);

            startActivity(intent);
        });

        Button binGoToStarships = findViewById(R.id.buttonStarships);
        binGoToStarships.setOnClickListener(view -> {
            Intent intent = new Intent(this, StarshipsActivity.class);

            startActivity(intent);
        });

        Button binGoToPlanets = findViewById(R.id.buttonPlanets);
        binGoToPlanets.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlanetsActivity.class);

            startActivity(intent);
        });

    }
}