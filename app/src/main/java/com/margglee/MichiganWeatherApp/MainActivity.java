package com.margglee.MichiganWeatherApp;

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
        Class statusArray[] = new Class[] {SunnyStatus.class, PartlyCloudyStatus.class,
                RainyStatus.class, SnowStatus.class, StormStatus.class};
        //[min = 0, max = 4]
        int randomInt = new Random().nextInt(statusArray.length);
        //get a different page than the previous time
        Intent intent = new Intent(this, statusArray[randomInt]);
        startActivity(intent);
        view.setBackgroundResource(0);
        this.finish();
    }
}
