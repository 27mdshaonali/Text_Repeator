package com.example.textrepeator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edText, edRepeatTime;
    Button btnClear, btnRepeat;
    TextView tvResult;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);
        edRepeatTime = findViewById(R.id.edRepeatTime);
        btnClear = findViewById(R.id.btnClear);
        btnRepeat = findViewById(R.id.btnRepeat);
        tvResult = findViewById(R.id.tvResult);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                edText.setText("");
                edText.setHint("Enter text here");

                edRepeatTime.setText("");
                edRepeatTime.setHint("Enter Repeat Time");

                tvResult.setText("Result: ");
            }
        });

        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String text = edText.getText().toString().trim();
                String repeatTimeStr = edRepeatTime.getText().toString().trim();

                try {
                    int repeatTime = Integer.parseInt(repeatTimeStr);

                    // Check if the repeat time is within the allowed range
                    if (repeatTime < 1 || repeatTime > 1000) {
                        Toast.makeText(MainActivity.this, "Please enter a number between 1 and 10,000", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Clear previous results
                    tvResult.setText("Result: ");

                    // Append the text the specified number of times
                    for (int i = 0; i < repeatTime; i++) {
                        tvResult.append(" " + text + " ");
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid number format", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
