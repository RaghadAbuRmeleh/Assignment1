package com.example.assignment1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

public class AddTask extends AppCompatActivity {

    private HomePage hp;
    public static final String DATA = "DATA";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    private TextInputEditText inputEditText;
    private TextView textView;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        setupSharedPrefs();
        textView = findViewById(R.id.txtView1);

        ImageButton btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTask.this,HomePage.class);
                startActivity(intent);
            }
        });

    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

    }

    public void btnSaveOnClick(View view) {
        Task[] tasks = new Task[100];

        Gson gson = new Gson();
        String tasksString = gson.toJson(tasks);

        editor.putString(DATA, tasksString);
        editor.commit();

        textView.setText(tasksString+ "\n");

    }
   /* public void btnLoadOnClick(View view) {

        Gson gson = new Gson();
        String str = prefs.getString(DATA, "");
        if(!str.equals("")) {
            Task[] books = gson.fromJson(str, Task[].class);

        }
        else{
            txtResults.setText("No data found");
        }
    }*/
}