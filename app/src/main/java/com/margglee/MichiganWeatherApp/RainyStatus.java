package com.margglee.MichiganWeatherApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RainyStatus extends AppCompatActivity {

    ImageView viewRain;

    //index for intArray
    private int index = 0;
    //array with dp sizes to change the image size
    private int[] intArray = new int[] {100, 200, 300, 400, 500, 600, 700};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainy_status);

        viewRain = findViewById(R.id.snowflake);

    }

    public void changeVisibility(View view){

        viewRain.getLayoutParams().height = intArray[index];
        viewRain.getLayoutParams().width = intArray[index];
        viewRain.requestLayout();

        //if the index points at the end of the array, index restarts at the beginning of the array
        if ((index + 1) == intArray.length) {
            index = 0;
        }
        else {
            index++;
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void goToMenuActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        view.setBackgroundResource(0);
        this.finish();
    }
}
