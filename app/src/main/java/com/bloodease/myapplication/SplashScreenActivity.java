package com.bloodease.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Handler được sử dụng để gửi và xử lý các thông điệp và các tác vụ trong một luồng cụ thể, thường là luồng giao diện người dùng (UI thread).
        handler = new Handler();

        // Trong Android, Handler.postDelayed được sử dụng để đặt lịch trình thực hiện một tác vụ cụ thể sau một khoảng thời gian nhất định.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Sử dụng khi cần chuyển từ activity này => activity khác
                Intent intent = new Intent(SplashScreenActivity.this,OnboardingActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}