package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class HomePage extends AppCompatActivity {
    private TextView taskNameTextView;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ArrayAdapter<Task> listAdapter = new ArrayAdapter<Task>(this,
                android.R.layout.simple_list_item_1,
                Task.tasks);

        ListView listView = (ListView)findViewById(R.id.tasks_list);
        listView.setAdapter(listAdapter);

       ImageButton btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,AddTask.class);
                startActivity(intent);
            }
        });

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                Intent intent = new Intent(HomePage.this,
                        TasksActivity.class);
                intent.putExtra("task_id", (int)id);
                startActivity(intent);

            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }



}