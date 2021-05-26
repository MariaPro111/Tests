package com.example.tests;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateQuestionActivity extends AppCompatActivity {

    Button button2;
    EditText editTitle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createquestion);

        Bundle arguments = getIntent().getExtras();


        TestsDataBase testsdb = new TestsDataBase(this);
        button2 = (Button) findViewById(R.id.button2);
        editTitle1 = (EditText) findViewById(R.id.editTitle1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question=editTitle1.getText().toString();
                int id = arguments.getInt("testid");

                SQLiteDatabase database = testsdb.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(TestsDataBase.QUESTION, question);
                contentValues.put(TestsDataBase.TEST_ID, id);
                Long idIndex = database.insert(TestsDataBase.QUESTIONS, null, contentValues);
                database.close();

                Intent intent = new Intent();
                intent.setClass(CreateQuestionActivity.this, CreateAnswerActivity.class);
                intent.putExtra("questionid", idIndex.intValue());
                startActivity(intent);

            }
        });

    }
}
