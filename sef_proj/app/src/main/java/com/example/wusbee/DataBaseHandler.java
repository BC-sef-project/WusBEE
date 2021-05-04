package com.example.wusbee;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import androidx.annotation.Nullable;

public class DataBaseHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "CUSTOMER.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CustomerContract.CustomerEntry.TABLE_NAME + "("+
                    CustomerContract.CustomerEntry.COLUMN_CUSTOMER_USERNAME + " TEXT PRIMARY KEY," +
                    CustomerContract.CustomerEntry.COLUMN_CUSTOMER_FULLNAME + " TEXT," +
                    CustomerContract.CustomerEntry.COLUMN_CUSTOMER_EMAIL + " TEXT," +
                    CustomerContract.CustomerEntry.COLUMN_CUSTOMER_PHONE + " INT, " +
                    CustomerContract.CustomerEntry.COLUMN_CUSTOMER_PASSWORD + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            " DROP TABLE IF EXISTS " + CustomerContract.CustomerEntry.TABLE_NAME;


    public DataBaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //called first time accessing the db
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    //called whenever something is changed in the db design
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public boolean addCustomer(CustomerModel customerModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CustomerContract.CustomerEntry.COLUMN_CUSTOMER_FULLNAME, customerModel.getFullName());
        values.put(CustomerContract.CustomerEntry.COLUMN_CUSTOMER_USERNAME, customerModel.getUsername());
        values.put(CustomerContract.CustomerEntry.COLUMN_CUSTOMER_EMAIL, customerModel.getEmail());
        values.put(CustomerContract.CustomerEntry.COLUMN_CUSTOMER_PHONE, customerModel.getPhoneNumber());
        values.put(CustomerContract.CustomerEntry.COLUMN_CUSTOMER_PASSWORD, customerModel.getPassword());

        long rowID = db.insert(CustomerContract.CustomerEntry.TABLE_NAME, null, values);
        if(rowID < 0)
            return false;
        else return true;
    }
}
