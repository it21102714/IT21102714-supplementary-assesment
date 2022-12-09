package com.example.it21006098supplementaryassessment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.it21006098supplementaryassessment.R;
import com.example.it21006098supplementaryassessment.db.DBHelper;
import com.example.it21006098supplementaryassessment.model.Student;

public class UpdateStudentActivity extends AppCompatActivity {
    EditText edName, edCourse, edMobile, edTotal, edPaid;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        Student s = (Student) getIntent().getExtras().getSerializable("STUDENT");

        id = s.getId();
        edName = findViewById(R.id.edName);
        edCourse = findViewById(R.id.edCourse);
        edMobile = findViewById(R.id.edMobile);
        edTotal = findViewById(R.id.edTotal);
        edPaid = findViewById(R.id.edPaid);

        edName.setText(s.getName());
        edCourse.setText(s.getCourse());
        edMobile.setText(s.getMobile());
        edTotal.setText(String.valueOf(s.getTotalFee()));
        edPaid.setText(String.valueOf(s.getFeePaid()));
    }

    public void update(View view) {
        String name = edName.getText().toString().trim();
        String course = edCourse.getText().toString().trim();
        String mobile = edMobile.getText().toString().trim();
        String total = edTotal.getText().toString().trim();
        String paid = edPaid.getText().toString().trim();

        Student s = new Student(id, name, course, mobile, Integer.parseInt(total), Integer.parseInt(paid));

        DBHelper dbHelper = new DBHelper(this);
        int result = dbHelper.updateStudent(s);

        if( result > 0)
        {
            Toast.makeText(this, "Updated " + result, Toast.LENGTH_SHORT).show();
            finish();
        }
        else
        {
            Toast.makeText(this, "Failed " + result, Toast.LENGTH_SHORT).show();
        }
    }
}