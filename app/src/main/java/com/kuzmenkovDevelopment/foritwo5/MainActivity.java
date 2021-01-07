package com.kuzmenkovDevelopment.foritwo5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private CardView calculateCable;
    private CardView addCable;
    private CardView showCableList;
    private CardView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateCable = findViewById(R.id.calculateCable);

        calculateCable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTocalculateActivity();
            }
        });

        addCable = findViewById(R.id.addCable);
        addCable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddCableActivity();
            }
        });

        showCableList = findViewById(R.id.showCablesList);
        showCableList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToShowCableListActivity();
            }
        });

    }

    private void goToAddCableActivity() {
        Intent intent = new Intent(this, AddCableActivity.class);
        startActivity(intent);
    }

    private void goToShowCableListActivity() {
        Intent intent = new Intent(this, CableListActivity.class);
        startActivity(intent);
    }

    private void goTocalculateActivity() {
        Intent intent = new Intent(this, calculateCable.class);
        startActivity(intent);
    }

}