package com.example.assg_2.fragment;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.assg_2.CourseList;
import com.example.assg_2.R;
import com.example.assg_2.Students;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CourseFragment extends Fragment {


    Spinner course, year, sem;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    CourseList courseList;
    ArrayList<Students> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View root2 = inflater.inflate(R.layout.fragment_course, container, false);


        // Year Dropdown
        year = root2.findViewById(R.id.year);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Year, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        year.setAdapter(adapter3);

        // Semester Dropdown
        sem = root2.findViewById(R.id.sem);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity(), R.array.Semester, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sem.setAdapter(adapter4);

        // Course Dropdown
        course = root2.findViewById(R.id.course1);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getActivity(), R.array.course, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_item);
        course.setAdapter(adapter5);

        // Create Default Dropdown Value


        // Can only select default course

        // Units
        recyclerView = root2.findViewById(R.id.units);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        courseList = new CourseList(getActivity(), list);
        recyclerView.setAdapter(courseList);
        String semester = sem.getSelectedItem().toString();

        databaseReference = FirebaseDatabase.getInstance().getReference("sem");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Students students = dataSnapshot.getValue(Students.class);
                    list.add(students);
                }
                if(semester=="I") {
                    courseList.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return root2;
    }
}