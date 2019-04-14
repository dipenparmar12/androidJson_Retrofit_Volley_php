package com.example.retrofitlocalhost;




import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public  class StudentAdapter_ extends RecyclerView.Adapter<StudentAdapter_.ViewHolder> {

    ArrayList<StudentsJson_> studentsJson_;
    Context context;

    public StudentAdapter_(ArrayList<StudentsJson_> studentsJson_, Context context) {
        this.studentsJson_ = studentsJson_;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_info_layout,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(studentsJson_.get(i).getName());
        viewHolder.mobile.setText(studentsJson_.get(i).getMobile());
        viewHolder.address.setText(studentsJson_.get(i).getAddress());
    }

    @Override
    public int getItemCount() {
        return studentsJson_.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,mobile,address;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView5);
            mobile= itemView.findViewById(R.id.textView6);
            address= itemView.findViewById(R.id.textView7);

        }
    }

}
