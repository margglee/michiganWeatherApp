package com.margglee.MichiganWeatherApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
//When the weather icon is clicked, shows a random temperature
public class SunnyStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunny_status);
        View v = findViewById(R.id.sunnyView);
        refreshTemperature(v);
    }

    public void refreshTemperature(View view) {
        int randomTemp = (int)(Math.random()*(150-60)) + 60;
        ((TextView)findViewById(R.id.lux)).setText( "Temperature: " + randomTemp + "°F");
    }

    public void goToMenuActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        view.setBackgroundResource(0);
        this.finish();
    }
}
