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
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

public class SliderActivity extends AppCompatActivity {

    ViewPager viewPager;
    Button btnNext;
    int[] layouts;
    PageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        viewPager = findViewById(R.id.pager);
        btnNext = findViewById(R.id.nextBtn);

        layouts = new int[] {
                R.layout.slider1,
                R.layout.slider2,
                R.layout.slider3
        };
        adapter = new PageAdapter(this, layouts);
        viewPager.setAdapter(adapter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()+1<layouts.length){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else{
                    //Masuk ke login activity
                    startActivity(new Intent(SliderActivity.this, LoginActivity.class));
                    finish();
                }
            }
        });
        viewPager.addOnPageChangeListener(viewPagerChangeListener);
    }
        ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int ii) {

            }
            @Override
            public void onPageSelected(int i) {
                if(i == layouts.length -1 ){
                    btnNext.setText("Mulai");
                }else {
                    btnNext.setText("Next");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
}