package org.diiage.clementh.poc.hugon.swapi.transformations;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.diiage.clementh.poc.hugon.swapi.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.diiage.clementh.poc.hugon.swapi.models.People;
import org.diiage.clementh.poc.hugon.swapi.models.SWModelList;


import java.util.List;
import java.util.function.Consumer;

public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListViewHolder> {
    private List<People> peopleList;
    private Consumer<People>  peopleConsumer;

    public PeopleListAdapter(List<People> peopleList){
        this.peopleList = peopleList;
    }

    public void setPeopleConsumer(Consumer<People> peopleConsumer) {
        this.peopleConsumer = peopleConsumer;
    }

    @NonNull
    @Override
    public PeopleListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_item, parent,false);

        return new PeopleListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleListViewHolder holder, int position){
        People people = peopleList.get(position);
        holder.txtName.setText(people.getName());
        holder.txtBirthYear.setText(String.valueOf(people.getBirthYear()));
        holder.txtGender.setText(people.getGender());

        holder.btnDetail.setOnClickListener(v1 ->  {
            peopleConsumer.accept(people);
        });

    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

}
