package com.monstertechno.otpverificationuidesign;

import android.graphics.Color;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private PinView pinView;
    private Button next;
    private TextView topText,textU;
    private EditText userName, userPhone;
    private ConstraintLayout first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);*/
        setContentView(R.layout.activity_main);

        topText = findViewById(R.id.topText);
        pinView = findViewById(R.id.pinView);
        next = findViewById(R.id.button);
        userName = findViewById(R.id.username);
        userPhone = findViewById(R.id.userPhone);
        first = findViewById(R.id.first_step);
        second = findViewById(R.id.secondStep);
        textU = findViewById(R.id.textView_noti);
        first.setVisibility(View.VISIBLE);

        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (next.getText().equals("Let's go!")) {
            String name = userName.getText().toString();
            String phone = userPhone.getText().toString();

            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone)) {
                next.setText("Verify");
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
                topText.setText("I Still don't trust you.\nTell me something that only two of us know.");
            } else {
                Toast.makeText(MainActivity.this, "Please enter the details", Toast.LENGTH_SHORT).show();
            }
        } else if (next.getText().equals("Verify")) {
            String OTP = pinView.getText().toString();
            if (OTP.equals("3456")) {
                pinView.setLineColor(Color.GREEN);
                textU.setText("OTP Verified");
                textU.setTextColor(Color.GREEN);
                next.setText("Next");
            } else {
                pinView.setLineColor(Color.RED);
                textU.setText("X Incorrect OTP");
                textU.setTextColor(Color.RED);
            }
        }

    }
}
