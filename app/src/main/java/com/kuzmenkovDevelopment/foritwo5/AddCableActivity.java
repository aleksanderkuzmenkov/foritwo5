package com.kuzmenkovDevelopment.foritwo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCableActivity extends AppCompatActivity {
    private TextView length;
    private Spinner type;
    private Spinner quadratura;
    private Spinner line;

    private Button submitButton;

    private ImageView addTypeButton;
    private ImageView addQuadraturaButton;
    private ImageView addLineButton;

    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> quadraturas = new ArrayList<>();
    private ArrayList<String> lines = new ArrayList<>();

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cable);

        mDatabaseHelper = new DatabaseHelper(this);

        addTypeButton = findViewById(R.id.addTypeButton);
        addTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTypeButton();
            }
        });

        addQuadraturaButton = findViewById(R.id.addQuadraturaButton);
        addQuadraturaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuadraturaButton();
            }
        });

        addLineButton = findViewById(R.id.addLineButton);
        addLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLineButton();
            }
        });

        length = findViewById(R.id.lengthInput);

        createTypesDropDownSpinner();
        createQuadraturaDropDownSpinner();
        createLineDropDownSpinner();

        populateListView();


        submitButton = findViewById(R.id.submitButton);
        mDatabaseHelper = new DatabaseHelper(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertCableToDataBase();
                goToShowCableListActivity();
            }
        });

    }

    private void addLineButton() {
        Intent intent = new Intent(this, AddLine.class);
        startActivity(intent);
    }

    private void addQuadraturaButton() {
        Intent intent = new Intent(this, AddQuadratura.class);
        startActivity(intent);
    }

    private void addTypeButton() {
        Intent intent = new Intent(this, AddCableType.class);
        startActivity(intent);
    }

    private void getToast(){
        Toast.makeText(this, "ja", Toast.LENGTH_LONG).show();
    }

    private void createLineDropDownSpinner() {
        lines.add("Добавить линию");
        line = findViewById(R.id.spinnerLine);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lines);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        line.setAdapter(adapter);
    }

    private void createQuadraturaDropDownSpinner() {
        quadraturas.add("Добавить квадратуру");
        quadratura = findViewById(R.id.spinnerQuadratura);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quadraturas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quadratura.setAdapter(adapter);
    }

    private void createTypesDropDownSpinner() {
        types.add("Добавить тип");
        type = findViewById(R.id.spinnerType);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);
    }


    private void insertCableToDataBase() {
        boolean insert = mDatabaseHelper.addData(Double.parseDouble(length.getText().toString()), 1,1, 3);

        if(insert){
            Toast.makeText(this, "ja", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "nein", Toast.LENGTH_LONG).show();
        }
    }

    private void goToShowCableListActivity() {
        Intent intent = new Intent(this, CableListActivity.class);
        startActivity(intent);
    }

    private void populateListView() {
        Cursor data = mDatabaseHelper.getTypeData();

        String listDataAdditional = "";
        while (data.moveToNext()) {
            listDataAdditional = data.getString(2);
            types.add(listDataAdditional);
        }

    }
}