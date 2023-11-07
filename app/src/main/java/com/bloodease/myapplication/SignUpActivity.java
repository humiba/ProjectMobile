package com.bloodease.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class SignUpActivity extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, passwordEditText, rePasswordEditText;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        usernameEditText = findViewById(R.id.username);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        rePasswordEditText = findViewById(R.id.repassword);

        MaterialButton signUpButton = findViewById(R.id.signupbtn);
        final TextView signInText = findViewById(R.id.signInLink);



        // Show/hide password with an eye icon
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());

        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eyesoff, 0);

        passwordEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int DRAWABLE_RIGHT = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (motionEvent.getRawX() >= (passwordEditText.getRight() - passwordEditText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        isPasswordVisible = !isPasswordVisible;
                        if (isPasswordVisible) {
                            passwordEditText.setTransformationMethod(null);
                            passwordEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eyeson, 0);
                        } else {
                            passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eyesoff, 0);
                        }
                        return true;
                    }
                }
                return false;
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if any of the EditText fields are empty
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String rePassword = rePasswordEditText.getText().toString().trim();

                boolean isAnyFieldEmpty = username.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty();

                if (isAnyFieldEmpty) {
                    Toast.makeText(SignUpActivity.this, "Nhập thông tin của bạn!", Toast.LENGTH_SHORT).show();
                } else {
                    // Perform the sign-up process here

                    // After successful sign-up, navigate to the main screen
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(signInText.getText().toString());
        SpannableString spannableString = new SpannableString("Đăng nhập");
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FB6F78")), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.replace(spannableStringBuilder.toString().indexOf("Đăng nhập"), spannableStringBuilder.toString().indexOf("Đăng nhập") + "Đăng nhập".length(), spannableString);
        signInText.setText(spannableStringBuilder);
        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Điều hướng đến màn hình đăng nhập ở đây
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class); // Thay thế LoginActivity bằng tên hoạt động đăng nhập thực tế của bạn
                startActivity(intent);
            }
        });

    }
}
