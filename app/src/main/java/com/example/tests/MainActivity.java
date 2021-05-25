package com.example.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {

      case R.id.create_settings:
          Intent intent = new Intent(this, CreateTestActivity.class);
          startActivity(intent);
          return true;


          case R.id.take_settings:
          Intent i = new Intent(this, TestsActivity.class);
          startActivity(i);
          return true;



          default:
       return super.onOptionsItemSelected(item);

      }
    }



}
