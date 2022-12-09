package com.example.it21006098supplementaryassessment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.it21006098supplementaryassessment.R;
import com.example.it21006098supplementaryassessment.adapter.StudentAdapter;
import com.example.it21006098supplementaryassessment.db.DBHelper;
import com.example.it21006098supplementaryassessment.model.Student;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {

    TextView tvTotal;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    ArrayList<Student> students;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        recyclerView = findViewById(R.id.recyclerView);
        tvTotal = findViewById(R.id.tvTotal);

        dbHelper = new DBHelper(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        students = dbHelper.getAllStudents();
        tvTotal.setText("Total Students : " + students.size());

        studentAdapter = new StudentAdapter(students, this);
        recyclerView.setAdapter(studentAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }
}