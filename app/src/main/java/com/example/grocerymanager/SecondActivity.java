package com.example.grocerymanager;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.sql.*;

public class SecondActivity extends AppCompatActivity {
    TextView textView, errorText;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView errorText = (TextView) findViewById(R.id.errorText);
        /*TextView textView3 = (TextView)findViewById(R.id.textView);
        TextView textView4 = (TextView)findViewById(R.id.textView);
        TextView textView5 = (TextView)findViewById(R.id.textView);
        TextView textView6 = (TextView)findViewById(R.id.textView);*/

        show = (Button) findViewById(R.id.button4);

        /*Intent intent = getIntent();
        String str = intent.getStringExtra("key");
        textView.setText(str);*/
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                return;
            }
        });

    }
}