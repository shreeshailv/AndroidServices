package com.shreeshail.jobschedular.Views;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.shreeshail.jobschedular.Services.ForegroundService;
import com.shreeshail.jobschedular.Services.JobSchedularService;
import com.shreeshail.jobschedular.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button jobschedulebtn,foregroundservivebtn;
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foregroundservivebtn = findViewById(R.id.foregroundservivebtn);
        jobschedulebtn = findViewById(R.id.jobschedulebtn);

        foregroundservivebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(),ForegroundServiceActivity.class);
                startActivity(intent);
            }
        });

        jobschedulebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getBaseContext(),JobSchedularActivity.class);
                startActivity(intent);
            }
        });
    }


}
