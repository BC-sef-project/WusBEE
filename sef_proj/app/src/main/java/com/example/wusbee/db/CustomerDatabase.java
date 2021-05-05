package com.example.wusbee.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.wusbee.db.CustomerDao;
import com.example.wusbee.db.CustomerModel;

@Database(entities = {CustomerModel.class}, version = 1)
public abstract class CustomerDatabase extends RoomDatabase {

    public abstract CustomerDao customerDao();
    private static CustomerDatabase INSTANCE;

    public static  CustomerDatabase getDbInstance(Context context){

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CustomerDatabase.class, "DB")
                    .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
