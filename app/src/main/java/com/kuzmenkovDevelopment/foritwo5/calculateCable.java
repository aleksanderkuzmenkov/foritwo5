package com.kuzmenkovDevelopment.foritwo5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculateCable extends AppCompatActivity {

    private EditText cableLength;
    private EditText cableType;
    private EditText cableQuadratura;

    private Button calculateButton;

    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_cable);

        cableLength = findViewById(R.id.cableLengthInput);
        cableType = findViewById(R.id.cableTypeInput);
        cableQuadratura = findViewById(R.id.cableQuadratura);

        calculateButton = findViewById(R.id.caclulateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

    }

    private void calculate() {

    }
}