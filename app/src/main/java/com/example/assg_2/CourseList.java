package com.example.assg_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseList extends RecyclerView.Adapter<CourseList.MyViewHolder> {

    Context context;
    ArrayList<Students> list;

    public CourseList(Context context, ArrayList<Students> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.course_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Students students = list.get(position);

        holder.unit_code.setText(students.getS1_unitCode());
        holder.unit_name.setText(students.getS1_unitName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView unit_name, unit_code;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            unit_code = itemView.findViewById(R.id.unitCode);
            unit_name = itemView.findViewById(R.id.unitName);
        }
    }
}
