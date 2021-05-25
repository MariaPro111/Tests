package com.example.tests;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestsDataBase  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test_database.db";
    private static final int DATABASE_VERSION = 1;


    public static final String TESTS="tests";
    public static final String TESTS_ID="_ID";
    public static final String TESTS_TITLE="title";

    public static final String QUESTIONS="questions";
    public static final String QUESTIONS_ID="_id";
    public static final String TEST_ID="test_id";
    public static final String QUESTION="question";

    public static final String ANSWERS="answers";
    public static final String ANSWERS_ID="_id";
    public static final String ANSWER="answer";
    public static final String QUESTION_ID="question_id";
    public static final String SCORE="score";


    public TestsDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TESTS + "(" + TESTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TESTS_TITLE + " TEXT" + ")");
        db.execSQL("create table "+ QUESTIONS + "(" + QUESTIONS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + QUESTION + " TEXT," + TEST_ID + " INTEGER" +")");
        db.execSQL("create table "+ ANSWERS +"(" + ANSWERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ANSWER + " TEXT," + SCORE +" INTEGER," + QUESTION_ID + " INTEGER" +")");


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
