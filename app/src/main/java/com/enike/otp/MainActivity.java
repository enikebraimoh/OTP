package com.enike.otp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText PhoneNumber;
    private Button Send;
    private String CompletePhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhoneNumber = findViewById(R.id.phonenumber);
        Send = findViewById(R.id.buttonsend);


        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompletePhoneNumber = "+234"+PhoneNumber.getText().toString();
                ValidateNumber(CompletePhoneNumber);
            }
        });


    }

    private void ValidateNumber(String completePhoneNumber) {

        if(PhoneNumber.getText().toString().equals("") || PhoneNumber.length()!=10){
            Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(MainActivity.this,verifycode.class);
            intent.putExtra("number",completePhoneNumber);
            startActivity(intent);
        }


    }

}