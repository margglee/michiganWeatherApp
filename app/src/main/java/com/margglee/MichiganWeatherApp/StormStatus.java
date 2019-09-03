package com.margglee.MichiganWeatherApp;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StormStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storm_status);
    }

    public void toVibrate(View view){
        //need permission for vibration
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //Start without delay
        //Then alternates between vibrate and sleep
        long[] pattern = {0, 300, 500, 400, 200, 600};
        //Only vibrate the pattern once
        v.vibrate(pattern, -1);
    }

    public void goToMenuActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        view.setBackgroundResource(0);
        this.finish();
    }
}
