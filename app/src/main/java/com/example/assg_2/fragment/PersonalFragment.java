package com.example.assg_2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.assg_2.R;
import com.example.assg_2.Students;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalFragment extends Fragment {

    Spinner course, department, school;
    EditText fName, mName, lName, id, regNo;
    Button submit, cancel;
    DatabaseReference student;
    RadioButton male, female;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_personal, container, false);


        // Course Drop down menu

        course = root.findViewById(R.id.course);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.course, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        course.setAdapter(adapter);

        // Department Drop down menu
        department = root.findViewById(R.id.department);
        ArrayAdapter<CharSequence>adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.Department, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        department.setAdapter(adapter1);

        // School Drop down menu
        school = root.findViewById(R.id.school);
        ArrayAdapter<CharSequence>adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.School, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        school.setAdapter(adapter2);

        // Radio button
        male = root.findViewById(R.id.male);
        female = root.findViewById(R.id.female);

        // Database Reference
        FirebaseApp.initializeApp(getActivity());
        student = FirebaseDatabase.getInstance().getReference().child("Detail");

        // EditText
        fName = root.findViewById(R.id.fname);
        mName = root.findViewById(R.id.mname);
        lName = root.findViewById(R.id.lname);
        id = root.findViewById(R.id.id);
        regNo = root.findViewById(R.id.regno);

        //Submit Button
        submit = root.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String f_name = fName.getText().toString();
                String m_name = mName.getText().toString();
                String l_name = lName.getText().toString();
                String Id = id.getText().toString();
                String reg_no = regNo.getText().toString();
                String m1 = male.getText().toString();
                String m2 = female.getText().toString();
                String s_course = course.getSelectedItem().toString();
                String s_department = department.getSelectedItem().toString();
                String s_school = school.getSelectedItem().toString();

                // Radio button action(s)
                String gender = null;
                if(male.isChecked()){
                    gender = m1;
                } else if(female.isChecked()) {
                    gender = m2;
                }


                Students students = new Students(f_name, m_name, l_name, Id, reg_no, gender, s_course, s_department, s_school);
                student.push().setValue(students);
                Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();


            }
        });
        // Cancel Button
        cancel = root.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fName.getText().clear();
                mName.getText().clear();
                lName.getText().clear();
                id.getText().clear();
                regNo.getText().clear();
                male.setChecked(false);
                female.setChecked(false);

            }
        });
        return root;
    }
}