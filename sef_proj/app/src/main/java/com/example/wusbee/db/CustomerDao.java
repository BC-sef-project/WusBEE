package com.example.wusbee.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.wusbee.db.CustomerModel;

import java.util.List;

@Dao
public interface CustomerDao {
    @Query("SELECT * FROM CustomerModel")
    List<CustomerModel> loadAll();

    @Query("SELECT fullname FROM CustomerModel")
    List<String> loadCustomersByFullname();

    @Query("SELECT * FROM CustomerModel WHERE username=:user AND password=:pass")
    boolean logInCustomer(String user, String pass);

    @Query("SELECT * FROM CustomerModel WHERE username=:user")
    boolean checkIfCustomerExists(String user);

    @Insert
    void insertCustomer(CustomerModel customerModel);

    @Delete
    void delete(CustomerModel customerModel);

}

