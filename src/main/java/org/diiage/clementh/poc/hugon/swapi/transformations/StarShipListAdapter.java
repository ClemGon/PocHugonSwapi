package org.diiage.clementh.poc.hugon.swapi.transformations;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.diiage.clementh.poc.hugon.swapi.R;
import org.diiage.clementh.poc.hugon.swapi.models.Planet;
import org.diiage.clementh.poc.hugon.swapi.models.Starship;

import java.util.List;

public class StarShipListAdapter extends RecyclerView.Adapter<StarShipListViewHolder> {
    private List<Starship> starshipList;

    public StarShipListAdapter(List<Starship> starshipList){
        this.starshipList = starshipList;
    }

    @NonNull
    @Override
    public StarShipListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.starship_item, parent,false);

        return new StarShipListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StarShipListViewHolder holder, int position){
        Starship starship = starshipList.get(position);
        holder.txtNameStarShip.setText(starship.getName());
        holder.txtManufacturerStarShip.setText(String.valueOf(starship.getManufacturer()));
        holder.txtCostInCreditsStarShip.setText(starship.getCostInCredits());
        holder.txtClassStarShip.setText(starship.getStarshipClass());
        holder.txtMaxSpeedStarship.setText(starship.getMaxAtmospheringSpeed());
    }

    @Override
    public int getItemCount() {
        return starshipList.size();
    }

}
