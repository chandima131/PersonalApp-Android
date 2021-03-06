package com.example.papp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class ViewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView tvNote = findViewById(R.id.tv_note);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("NAME");
        try {
            FileInputStream fis = openFileInput(name);
            byte[] chars = new byte[fis.available()];
            fis.read(chars);
            fis.close();
            String text = new String(chars);
            tvNote.setText(text);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error: Failed to Read the file", Toast.LENGTH_LONG).show();
        }
    }
}
