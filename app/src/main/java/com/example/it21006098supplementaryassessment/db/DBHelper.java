package com.example.it21006098supplementaryassessment.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.it21006098supplementaryassessment.model.Student;

import java.util.ArrayList;


public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "deans.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE tb1_student ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, course TEXT, mobile TEXT, total_fee INTEGER, fee_paid INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tb1_student");
        onCreate(sqLiteDatabase);
    }

    public long addStudent(Student s) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", s.getName());
        cv.put("course", s.getCourse());
        cv.put("mobile", s.getMobile());
        cv.put("total_fee", s.getTotalFee());
        cv.put("fee_paid", s.getFeePaid());

        return db.insert("tb1_student", null, cv);
    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * from tb1_student", null);

        if ( cursor.moveToFirst())
        {
            do {

                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String course = cursor.getString(2);
                String mobile = cursor.getString(3);
                int tf = cursor.getInt(4);
                int fp = cursor.getInt(5);

                Student s = new Student(id, name, course, mobile, tf, fp);
                students.add(s);

            }while( cursor.moveToNext());
        }

        return students;
    }

    public int updateStudent(Student s) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", s.getName());
        cv.put("course", s.getCourse());
        cv.put("mobile", s.getMobile());
        cv.put("total_fee", s.getTotalFee());
        cv.put("fee_paid", s.getFeePaid());

        return db.update("tb1_student", cv, "id=?", new String[]{String.valueOf(s.getId())});
    }

    public int deleteStudent(int id) {

        SQLiteDatabase db = getWritableDatabase();

        return db.delete("tb1_student", "id=?", new String[]{ String.valueOf(id)} );
    }
}
