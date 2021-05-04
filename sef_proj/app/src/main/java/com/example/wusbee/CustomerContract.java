package com.example.wusbee;

import android.provider.BaseColumns;

public final class CustomerContract {

    private CustomerContract(){}

    public static class CustomerEntry implements BaseColumns{
        public static final String TABLE_NAME = "CUSTOMER_TABLE";
        public static final String COLUMN_CUSTOMER_USERNAME = "USERNAME";
        public static final String COLUMN_CUSTOMER_FULLNAME = "FULLNAME";
        public static final String COLUMN_CUSTOMER_EMAIL = "EMAIL";
        public static final String COLUMN_CUSTOMER_PASSWORD = "PASSWORD";
        public static final String COLUMN_CUSTOMER_PHONE = "PHONE";
    }
}
