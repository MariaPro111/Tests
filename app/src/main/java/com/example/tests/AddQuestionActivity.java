package com.example.tests;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddQuestionActivity extends AppCompatActivity {

    Button button1;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addquestion);

        Bundle arguments = getIntent().getExtras();
        int id = arguments.getInt("testid");

        button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(AddQuestionActivity.this, CreateQuestionActivity.class);
                intent.putExtra("testid", id);
                startActivity(intent);

            }
        });

        button4=(Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(AddQuestionActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
