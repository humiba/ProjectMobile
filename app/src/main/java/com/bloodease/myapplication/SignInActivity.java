package com.bloodease.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class SignInActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private TextView forgotPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);

        MaterialButton signInButton = findViewById(R.id.signinbtn);
        forgotPasswordText = findViewById(R.id.forgotpassword);
        final TextView signUpText = findViewById(R.id.signUpLink);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý đăng nhập tại đây
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Kiểm tra xác thực người dùng và thực hiện đăng nhập

                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xử lý quên mật khẩu, ví dụ: chuyển đến màn hình khôi phục mật khẩu
                Intent intent = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(signUpText.getText().toString());
        SpannableString spannableString = new SpannableString("Đăng ký ngay");
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FB6F78")), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.replace(spannableStringBuilder.toString().indexOf("Đăng ký ngay"), spannableStringBuilder.toString().indexOf("Đăng ký ngay") + "Đăng ký ngay".length(), spannableString);
        signUpText.setText(spannableStringBuilder);
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}
