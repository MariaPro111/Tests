package com.example.tests;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAnswerActivity extends AppCompatActivity {

    Button button3;
    EditText editAnswer1;
    EditText editAnswer2;
    EditText editAnswer3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createanswer);

        Bundle arguments = getIntent().getExtras();

        TestsDataBase testsdb = new TestsDataBase(this);
        button3 = (Button) findViewById(R.id.button3);
        editAnswer1 = (EditText) findViewById(R.id.editAnswer1);
        editAnswer2 = (EditText) findViewById(R.id.editAnswer2);
        editAnswer3 = (EditText) findViewById(R.id.editAnswer3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer1=editAnswer1.getText().toString();
                String answer2=editAnswer2.getText().toString();
                String answer3=editAnswer3.getText().toString();
                int id = arguments.getInt("questionid");

                SQLiteDatabase database = testsdb.getWritableDatabase();
                ContentValues contentValues1 = new ContentValues();
                contentValues1.put(TestsDataBase.ANSWER, answer1);
                contentValues1.put(TestsDataBase.SCORE, 2);
                contentValues1.put(TestsDataBase.QUESTION_ID, id);
                database.insert(TestsDataBase.ANSWERS, null, contentValues1);

                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(TestsDataBase.ANSWER, answer2);
                contentValues2.put(TestsDataBase.SCORE, 1);
                contentValues2.put(TestsDataBase.QUESTION_ID, id);
                database.insert(TestsDataBase.ANSWERS, null, contentValues2);

                ContentValues contentValues3 = new ContentValues();
                contentValues3.put(TestsDataBase.ANSWER, answer3);
                contentValues3.put(TestsDataBase.SCORE, 0);
                contentValues3.put(TestsDataBase.QUESTION_ID, id);
                database.insert(TestsDataBase.ANSWERS, null, contentValues3);

                Cursor c=database.rawQuery("SELECT MAX(_ID) as max_id FROM tests", null);
                int idIndex = c.getColumnIndex("max_id");


                database.close();

                Intent intent = new Intent();
                intent.setClass(CreateAnswerActivity.this, AddQuestionActivity.class);
                intent.putExtra("testid", idIndex);
                startActivity(intent);

            }
        });


    }
}