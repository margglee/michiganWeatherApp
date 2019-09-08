package com.margglee.MichiganWeatherApp;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//Shows the brightness from the brightness sensor
public class PartlyCloudyStatus extends AppCompatActivity {
    TextView textLight;
    ImageView sunIcon;
    private SensorManager sensorManager;
    private Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partly_cloudy_status);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        textLight = findViewById(R.id.lux);
        sunIcon = findViewById(R.id.hiddenSun);
    }

    public SensorEventListener lightListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) {}
        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];
            textLight.setText((int)x + " Lux");
        }
    };

    public void changeVisibility(View view){
        if (sunIcon.getVisibility() == View.VISIBLE) {
            sunIcon.setVisibility(View.INVISIBLE);
        }
        else{
            sunIcon.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(lightListener);
    }

    @Override
    public void onResume() {
        super.onResume();
        //updates the sensor value every second
        sensorManager.registerListener(lightListener, sensor, 1000000, 1000000);
    }

    @Override
    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(lightListener);
    }

    public void goToMenuActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        view.setBackgroundResource(0);
        this.finish();
    }
}
