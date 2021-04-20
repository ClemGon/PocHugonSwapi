package org.diiage.clementh.poc.hugon.swapi.transformations;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.diiage.clementh.poc.hugon.swapi.R;

public class StarShipListViewHolder extends RecyclerView.ViewHolder {
   public TextView txtNameStarShip;
   public TextView txtManufacturerStarShip;
   public TextView txtCostInCreditsStarShip;
   public TextView txtClassStarShip;
   public TextView txtMaxSpeedStarship;

    public StarShipListViewHolder(@NonNull View itemView) {
        super(itemView);
        txtNameStarShip = itemView.findViewById(R.id.txtNameStarShip);
        txtManufacturerStarShip = itemView.findViewById(R.id.txtManufacturerStarShip);
        txtCostInCreditsStarShip = itemView.findViewById(R.id.txtCostInCreditsStarShip);
        txtClassStarShip = itemView.findViewById(R.id.txtClassStarShip);
        txtMaxSpeedStarship = itemView.findViewById(R.id.txtMaxSpeedStarship);
    }
}
