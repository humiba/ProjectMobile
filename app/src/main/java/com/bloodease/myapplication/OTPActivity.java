package com.bloodease.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class OTPActivity extends AppCompatActivity {

    private EditText otp1, otp2, otp3, otp4, otp5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        otp5 = findViewById(R.id.otp5);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String otp1Text = otp1.getText().toString().trim();
                String otp2Text = otp2.getText().toString().trim();
                String otp3Text = otp3.getText().toString().trim();
                String otp4Text = otp4.getText().toString().trim();
                String otp5Text = otp5.getText().toString().trim();

                if (otp1Text.length() == 1 && otp2Text.length() == 1 && otp3Text.length() == 1
                        && otp4Text.length() == 1 && otp5Text.length() == 1) {
                }
            }
        };

        otp1.addTextChangedListener(textWatcher);
        otp2.addTextChangedListener(textWatcher);
        otp3.addTextChangedListener(textWatcher);
        otp4.addTextChangedListener(textWatcher);
        otp5.addTextChangedListener(textWatcher);

        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    EditText editText = (EditText) view;
                    String text = editText.getText().toString().trim();
                    if (!text.isEmpty()) {
                        // Highlight the text with pink color
                        highlightText(editText);
                    }
                }
            }
        };

        otp1.setOnFocusChangeListener(onFocusChangeListener);
        otp2.setOnFocusChangeListener(onFocusChangeListener);
        otp3.setOnFocusChangeListener(onFocusChangeListener);
        otp4.setOnFocusChangeListener(onFocusChangeListener);
        otp5.setOnFocusChangeListener(onFocusChangeListener);
    }

    private void highlightText(EditText editText) {
        String text = editText.getText().toString();
        Spannable spannable = new SpannableString(text);
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#FB6F78")), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        editText.setText(spannable);
    }
}
