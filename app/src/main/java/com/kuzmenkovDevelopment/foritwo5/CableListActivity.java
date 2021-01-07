package com.kuzmenkovDevelopment.foritwo5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CableListActivity extends AppCompatActivity {

    private static String TAG = "CableListActivity";

    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cable_list);

        mListView = findViewById(R.id.list_view);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Cursor data = mDatabaseHelper.getData();

        ArrayList<String> listData = new ArrayList<>();
        String listDataAdditional = "";
        while (data.moveToNext()){
            listDataAdditional = "Length: " +  data.getString(1) + "\nType: " + data.getString(2) + "\nQuadratura: " + data.getString(3) + "\nLine: ";
            listData.add(listDataAdditional);
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);
    }
}