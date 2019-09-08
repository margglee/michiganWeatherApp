package com.margglee.MichiganWeatherApp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SnowStatus extends AppCompatActivity {
    ImageView viewSnow;
    private int posX = 0;
    private int posY = 0;
    private int posZ = 0;
    private int centerScreenX = 0;
    private int centerScreenY = 0;
    private float accX, accY, accZ;

    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snow_status);
        viewSnow = findViewById(R.id.snowflake);

        Point windowSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(windowSize);
        centerScreenX = (int)(windowSize.x * 0.45f);
        centerScreenY = (int)(windowSize.y * 0.55f);

        posX = centerScreenX;
        posY = centerScreenY;
        updateImagePosition(posX, posY, 0);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(accelerometerListener, sensor, 30000, 30000);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(accelerometerListener);
    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(accelerometerListener, sensor, 30000, 30000);
    }

    @Override
    protected void onDestroy(){
        sensorManager.unregisterListener(accelerometerListener);
        super.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(accelerometerListener);
    }

    public SensorEventListener accelerometerListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            Sensor sensor = event.sensor;
            if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                accX = event.values[0];
                accY = event.values[1];
                accZ = event.values[2];

                posX = posX - (int) accX;
                posY = posY + (int) accY;
                posZ = posZ + (int) (accZ * .15);

                if ((posX - centerScreenX) > 350) {
                    posX = centerScreenX + 350;
                } else if ((posX - centerScreenX) < -350) {
                    posX = centerScreenX - 350;
                }

                if ((posY - centerScreenY) > 300) {
                    posY = centerScreenY + 300;
                } else if ((posY - centerScreenY) < -300) {
                    posY = centerScreenY - 300;
                }

                updateImagePosition(posX, posY, posZ);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    public void updateImagePosition(int x, int y, int z) {
        viewSnow.setX(x);
        viewSnow.setY(y);
        viewSnow.setRotation(z);
    }

    public void resetLocation(View view) {
        posX = centerScreenX;
        posY = centerScreenY;
        viewSnow.setX(posX);
        viewSnow.setY(posY);
    }

    public void goToMenuActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        view.setBackgroundResource(0);
        this.finish();
    }
}
