package com.example.androidvolley;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    ArrayList<StudentsJson> studentsJson;
    Context context;

    public StudentAdapter(ArrayList<StudentsJson> studentsJson, Context context) {
        this.studentsJson = studentsJson;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.student_list_layout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.name.setText(studentsJson.get(i).getDisplayName());
        viewHolder.address.setText(studentsJson.get(i).getAddress());

        final int position = i;

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+studentsJson.get(position).getDisplayName(), Toast.LENGTH_SHORT).show();
            }
        });

    } 

    @Override
    public int getItemCount() {
        return studentsJson.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);

        }
    }

}
