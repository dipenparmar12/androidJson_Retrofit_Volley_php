package com.example.retrofitlocalhost;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{

    ArrayList<StudentsJson> studentsJsons;
    Context context;

    public StudentAdapter(Context context,ArrayList<StudentsJson> studentsJsons) {
        this.studentsJsons = studentsJsons;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_item_layout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.sName.setText(studentsJsons.get(i).getDisplayName());
        viewHolder.sMobile.setText(studentsJsons.get(i).getMobile());
        viewHolder.sAddress.setText(studentsJsons.get(i).getDisplayName());
    }

    @Override
    public int getItemCount() {
        return studentsJsons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Context context;

        TextView sMobile;
        TextView sName;
        TextView sAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sName= itemView.findViewById(R.id.name);
            sMobile = itemView.findViewById(R.id.mobile);
            sAddress= itemView.findViewById(R.id.address);

        }
    }

}