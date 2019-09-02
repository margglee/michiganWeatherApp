package com.margglee.MichiganWeatherApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkWeatherReport(View view) {
        //[min = 0, max = 1]
        int randomInt = new Random().nextInt(2);
        Class statusArray[] = new Class[] {SunnyStatus.class, PartlyCloudyStatus.class};

        Intent intent = new Intent(this, statusArray[randomInt]);
        //Intent intent = new Intent(this, SunnyStatus.class);
        startActivity(intent);
        view.setBackgroundResource(0);
        this.finish();
    }
}
