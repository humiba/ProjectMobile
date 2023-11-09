package com.bloodease.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private MaterialButton resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        emailEditText = findViewById(R.id.email);
        resetButton = findViewById(R.id.fpwbtn);

        // Set a TextWatcher to monitor text changes in the EditText field
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not needed for this example
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Not needed for this example
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Check if the email EditText is empty
                String email = emailEditText.getText().toString().trim();
                boolean isEmailEmpty = email.isEmpty();

                // Enable or disable the reset button based on whether the email field is empty
                resetButton.setEnabled(!isEmailEmpty);
            }
        };

        // Set the TextWatcher for the email EditText field
        emailEditText.addTextChangedListener(textWatcher);

        // Set an OnClickListener for the reset button
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the password reset process here
                // You can send a reset link or perform the necessary actions
                // After the reset process, you can navigate to another screen if needed

                // For example, navigate to a confirmation screen
                Intent intent = new Intent(ForgotPasswordActivity.this, OTPActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

