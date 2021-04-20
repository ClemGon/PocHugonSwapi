package org.diiage.clementh.poc.hugon.swapi.transformations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.diiage.clementh.poc.hugon.swapi.R;
import org.diiage.clementh.poc.hugon.swapi.models.People;
import org.diiage.clementh.poc.hugon.swapi.models.Planet;

import java.util.List;

public class PlanetsListAdapter extends RecyclerView.Adapter<PlanetsListViewHolder> {
    private List<Planet> planetsList;

    public PlanetsListAdapter(List<Planet> planetsList){
        this.planetsList = planetsList;
    }

    @NonNull
    @Override
    public PlanetsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.planets_item, parent,false);

        return new PlanetsListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsListViewHolder holder, int position){
        Planet planet = planetsList.get(position);
        holder.txtName.setText(planet.getName());
        holder.txtClimatePlanets.setText(String.valueOf(planet.getClimate()));
        holder.txtTerrainPlanets.setText(planet.getTerrain());
        holder.txtDimameterPlanets.setText(planet.getDiameter());
    }

    @Override
    public int getItemCount() {
        return planetsList.size();
    }

}
