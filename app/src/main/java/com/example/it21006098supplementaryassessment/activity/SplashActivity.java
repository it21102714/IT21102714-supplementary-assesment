package com.example.it21006098supplementaryassessment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.it21006098supplementaryassessment.R;

public class SplashActivity extends AppCompatActivity {

    ImageView iv;
    TextView titleaxios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        iv = findViewById(R.id.iv);
        titleaxios = findViewById(R.id.titleaxios);

        iv.animate()
                .rotation(360f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(2000);

        titleaxios.animate().alpha(1f).setDuration(1000).setStartDelay(1000);







        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(4 * 1000);

                    startActivity(new Intent(SplashActivity.this, AddStudentActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
    }
}
