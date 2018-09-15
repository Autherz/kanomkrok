package com.example.atisit.thongyod;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;


public class SplashScreenActivity extends AppCompatActivity {
    private Handler handler ;
    private Runnable runnable ;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView();

        final Intent intent = new Intent(this, MainActivity.class);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        /*handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },100);*/

    }

    public void onResume(){
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }

    public void onStop(){
        super.onStop();
        handler.removeCallbacks(runnable);
    }
}
