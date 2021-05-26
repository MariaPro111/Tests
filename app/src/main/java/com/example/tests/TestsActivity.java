package com.example.tests;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TestsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);


        listView = findViewById(R.id.tests);
        List<Test> tests = generateTests();
       //ArrayAdapter<Test> adapter = new ArrayAdapter<Test>(this, android.R.layout.simple_list_item_1, tests);
        TestsAdapter adapter = new TestsAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, tests);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Test test = tests.get(position);
                Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
                intent.putExtra("test", test);
                startActivity(intent);
            }
        });
    }
    private List<Test> generateTests() {
        List<Test> tests = new ArrayList<>();

        TestsDataBase testsdb=new TestsDataBase(this);

        SQLiteDatabase database=testsdb.getWritableDatabase();

        Cursor c =database.rawQuery("select _ID, title from tests", null);
        int titleIndex = c.getColumnIndex("title");
        int idIndex = c.getColumnIndex("_ID");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            Test test = new Test(c.getLong(idIndex), c.getString(titleIndex));
            tests.add(test);
            c.moveToNext();
        }

        return tests;



    }

    public static class TestsAdapter extends ArrayAdapter<Test> {
        public TestsAdapter(@NonNull Context context, int resource, @NonNull List<Test> objects) {
            super(context, resource, objects);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Test test = getItem(position);
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.test_item, null);
            TextView title = convertView.findViewById(R.id.title);
            title.setText(test.getTitle());

            return convertView;
        }
    }
}
