package org.diiage.clementh.poc.hugon.swapi.transformations;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.diiage.clementh.poc.hugon.swapi.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleListViewHolder extends RecyclerView.ViewHolder {
   public TextView txtName;
   public TextView txtGender;
   public TextView txtBirthYear;
   public Button btnDetail;
   public View itemView;

    public PeopleListViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        txtName = itemView.findViewById(R.id.txtNameStarShip);
        txtGender = itemView.findViewById(R.id.txtManufacturerStarShip);
        txtBirthYear = itemView.findViewById(R.id.txtCostInCreditsStarShip);
        btnDetail = itemView.findViewById(R.id.buttonDetailsPeople);
    }
}
