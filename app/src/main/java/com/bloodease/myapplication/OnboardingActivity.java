package com.bloodease.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private OnboardingAdapter onboardingAdapter;
    private Button nextBtn;
    private TextView skipStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(view -> nextPage(view));

        makeStatusbarTransparent();

        viewPager = findViewById(R.id.onboarding_view_pager);

        onboardingAdapter = new OnboardingAdapter(this);
        viewPager.setAdapter(onboardingAdapter);
//        viewPager.setPageTransformer(false, new OnboardingPageTransformer());
    }


    // Listener for next button press
    public void nextPage(View view) {
        if (view.getId() == R.id.nextBtn) {
            nextBtn = findViewById(R.id.nextBtn);
            skipStep = findViewById(R.id.skipStep);
            if (viewPager.getCurrentItem() < onboardingAdapter.getCount() - 1) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                nextBtn.setText("Hãy bắt đầu");
                skipStep.setText("Bỏ qua");
            }
            if (viewPager.getCurrentItem() + 1 == onboardingAdapter.getCount()) {
                nextBtn.setText("Tôi lần đầu tham gia");
                skipStep.setText("Đăng nhập");
                nextBtn.setOnClickListener(v2 -> {
                    Intent intent=new Intent(OnboardingActivity.this,SignUpActivity.class);
                    startActivity(intent);
                    finish();
                });
                skipStep.setOnClickListener(v3 -> {
                    Intent intent=new Intent(OnboardingActivity.this,SignInActivity.class);
                    startActivity(intent);
                    finish();
                });
            }
        }
    }

    private void makeStatusbarTransparent() {

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}