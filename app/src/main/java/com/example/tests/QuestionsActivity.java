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
//        Test test = (Test)getIntent().getExtras().get("test");
//        long id=test.getId();


        List<Question> questions = generateQuestions();
        QuestionsActivity.QuestionsAdapter adapter = new QuestionsActivity.QuestionsAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, questions);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Question question = questions.get(position);
                Intent intent = new Intent(getApplicationContext(), AnswersActivity.class);
                intent.putExtra("question", question);
                startActivity(intent);
            }
        });
    }
    private List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();

        TestsDataBase testsdb=new TestsDataBase(this);

        SQLiteDatabase database=testsdb.getWritableDatabase();

        Cursor c =database.rawQuery("select _id, question, test_id from questions", null);
        int questionIndex = c.getColumnIndex("question");
        int idIndex = c.getColumnIndex("_id");
        int test_idIndex=c.getColumnIndex("test_id");
        c.moveToFirst();
        while (!c.isAfterLast()) {
                Question q = new Question(c.getLong(idIndex), c.getString(questionIndex));
                questions.add(q);
            c.moveToNext();
        }

        return questions;

    }

    public static class QuestionsAdapter extends ArrayAdapter<Question> {
        public QuestionsAdapter(@NonNull Context context, int resource, @NonNull List<Question> objects) {
            super(context, resource, objects);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Question q = getItem(position);
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.question_item, null);
            TextView question = convertView.findViewById(R.id.question);
            question.setText(q.getQuestion());

            return convertView;
        }
    }

 }


