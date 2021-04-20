package org.diiage.clementh.poc.hugon.swapi.transformations;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.diiage.clementh.poc.hugon.swapi.R;

public class PlanetsListViewHolder extends RecyclerView.ViewHolder {
   public TextView txtName;
   public TextView txtClimatePlanets;
   public TextView txtTerrainPlanets;
   public TextView txtDimameterPlanets;

    public PlanetsListViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtNameStarShip);
        txtClimatePlanets = itemView.findViewById(R.id.txtManufacturerStarShip);
        txtTerrainPlanets = itemView.findViewById(R.id.txtCostInCreditsStarShip);
        txtDimameterPlanets = itemView.findViewById(R.id.txtClassStarShip);
    }
}
