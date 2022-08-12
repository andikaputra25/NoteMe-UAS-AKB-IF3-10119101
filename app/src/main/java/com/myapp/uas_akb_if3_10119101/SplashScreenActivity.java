package com.myapp.uas_akb_if3_10119101;

/**
 *
 * NIM : 10119101
 * Nama : Andika Putra
 * Kelas : IF-3
 *
 * **/

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Thread thread = new Thread(){
            public  void run(){
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreenActivity.this, SliderActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}