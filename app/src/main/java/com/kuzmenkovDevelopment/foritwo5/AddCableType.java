package com.kuzmenkovDevelopment.foritwo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCableType extends AppCompatActivity {

    private EditText cableTypeInput;
    private Button cableTypeInputAddButton;

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cable_type);

        cableTypeInput = findViewById(R.id.cableTypeInput);
        cableTypeInputAddButton = findViewById(R.id.cableTypeInputAddButton);

        cableTypeInputAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                addCableTypeToDatabase();

                changeToAddCableActivity();
            }
        });
    }

    private void changeToAddCableActivity() {
        Intent intent = new Intent(this, AddCableActivity.class);
        startActivity(intent);
    }

//    private void addCableTypeToDatabase() {
//        boolean insert = mDatabaseHelper.addDataToTypeTable(cableTypeInput.getText().toString());
//
//        if(insert){
//            Toast.makeText(this, "ja", Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(this, "nein", Toast.LENGTH_LONG).show();
//        }
//    }
}