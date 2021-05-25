package com.example.tests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AnswersActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

//        List<Answer> data = DataUtils.getInstance().getTests().get(0).getQuestions().get(0).getAnswers();
//        ArrayAdapter<Answer> adapter = new ArrayAdapter<Answer>(this, android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                final Intent intent = new Intent(getApplicationContext(), TestsActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
