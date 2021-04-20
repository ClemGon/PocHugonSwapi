package org.diiage.clementh.poc.hugon.swapi.transformations;

import android.view.View;
import android.widget.TextView;
import org.diiage.clementh.poc.hugon.swapi.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PeopleListViewHolder extends RecyclerView.ViewHolder {
   public TextView txtName;
   public TextView txtGender;
   public TextView txtBirthYear;

    public PeopleListViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtGender = itemView.findViewById(R.id.txtGender);
        txtBirthYear = itemView.findViewById(R.id.txtBirthYear);
    }
}
