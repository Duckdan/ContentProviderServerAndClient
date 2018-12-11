package com.study.yang.contentproviderserverdemo.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val CREATE_TABLE = "create table if not exists user(_id integer primary key autoincrement," +
        "name varchar(12),description varchar(20),age integer )"

class DBHelper(context: Context) : SQLiteOpenHelper(context, "user.db", null, 1) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}