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

public class CreateTestActivity extends AppCompatActivity {

    Button button;
    EditText editTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createtest);


        TestsDataBase testsdb = new TestsDataBase(this);
        button = (Button) findViewById(R.id.button);
        editTitle = (EditText) findViewById(R.id.editTitle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String title=editTitle.getText().toString();


                SQLiteDatabase database = testsdb.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(TestsDataBase.TESTS_TITLE, title);
                Long idIndex = database.insert(TestsDataBase.TESTS, null, contentValues);



                Intent intent = new Intent();
                intent.setClass(CreateTestActivity.this, AddQuestionActivity.class);
                intent.putExtra("testid", idIndex.intValue());
                startActivity(intent);

            }
        });
    }
}
