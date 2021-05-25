package com.example.tests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class QuestionsActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        listView = findViewById(R.id.questions);
        Test test = (Test)getIntent().getExtras().get("test");
        Toast.makeText(getApplicationContext(), test.toString(), Toast.LENGTH_SHORT).show();

//        List<Question> data = DataUtils.getInstance().getTests().get(0).getQuestions();
//        ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(this, android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                final Intent intent = new Intent(getApplicationContext(), AnswersActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
