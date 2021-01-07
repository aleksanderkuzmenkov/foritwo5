package com.kuzmenkovDevelopment.foritwo5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    // --- Initialize columns for cable table ---
    private static final String TABLE_NAME = "cable";
    private static final String COL1 = "length";
    private static final String  COL2 = "type";
    private static final String COL3 = "quadratura";
    private static final String COL4 = "line";

    // --- Initialize columns for type table ---
    private static final String TYPE_TABLE_NAME = "type";
    private static final String TYPE_NAME = "type_name";

    // --- Initialize columns for quadratura table ---
    private static final String QUADRATURA_TABLE_NAME = "quadratura";
    private static final String QUADRATURA_NAME = "quadratura_name";

    // --- Initialize columns for type table ---
    private static final String LINE_TABLE_NAME = "line";
    private static final String LINE_NAME = "line_name";


    public DatabaseHelper(Context context) {

        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createCableTable(db);
        createTypeTable(db);
        createQuadraturaTable(db);
        createLineTable(db);
    }

    private void createLineTable(SQLiteDatabase db) {
        String createLineTable = "CREATE TABLE " + LINE_TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + LINE_NAME + " TEXT)";
        db.execSQL(createLineTable);
    }

    private boolean createQuadraturaTable(SQLiteDatabase db) {
        try {
            String createQuadraturaTable = "CREATE TABLE " + QUADRATURA_TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + QUADRATURA_NAME + " TEXT)";
            db.execSQL(createQuadraturaTable);
        }catch (Exception c){
            return false;
        }
        return true;
    }

    private void createTypeTable(SQLiteDatabase db) {
        String createTypeTable = "CREATE TABLE " + TYPE_TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + TYPE_NAME + " TEXT)";
        db.execSQL(createTypeTable);
    }

    private void createCableTable(SQLiteDatabase db) {
        String createTable = "create table if not exists " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL1 + " DOUBLE, " + COL2 + " INTEGER, " + COL3 + " INTEGER, " + COL4 + " INTEGER)";
        db.execSQL(createTable);
        Log.i("broo", "work");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCableTableUpgade(db);
        onTypeTableUpgrade(db);
        onQuadraturaTableUpgrade(db);
        onLineTableUpgrade(db);
    }

    private void onLineTableUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + LINE_TABLE_NAME);
        onCreate(db);
    }

    private void onQuadraturaTableUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + QUADRATURA_TABLE_NAME);
        onCreate(db);
    }

    private void onTypeTableUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TYPE_TABLE_NAME);
        onCreate(db);


    }

    private void onCableTableUpgade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(double length, int type, int quadratura, int line){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, length);
        contentValues.put(COL2, type);
        contentValues.put(COL3, quadratura);
        contentValues.put(COL4, line);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == 1){
            return false;
        }else{
            return true;
        }
    }

    public boolean addDataToLineTable(String lineName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LINE_NAME, lineName);
        long result = db.insert(LINE_TABLE_NAME, null, contentValues);

        if (result == 1){
            return false;
        }else{
            return true;
        }
    }

    public boolean addDataToQuadraturaTable(String quadraturaName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUADRATURA_NAME, quadraturaName);
        long result = db.insert(QUADRATURA_TABLE_NAME, null, contentValues);

        if (result == 1){
            return false;
        }else{
            return true;
        }
    }

    public boolean addDataToTypeTable(String typeName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TYPE_NAME, typeName);

        long result = db.insert(TYPE_TABLE_NAME, null, contentValues);
        if (result == 1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getTypeData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TYPE_TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getQuadraturaData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + QUADRATURA_TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getLinesData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + LINE_TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }


}
