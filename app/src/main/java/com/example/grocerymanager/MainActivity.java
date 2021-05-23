package com.example.grocerymanager;

import android.content.Intent;
import android.os.Bundle;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    EditText Et1, Et2;
    Button Btn;
    TextView Tv;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Et1 = (EditText)findViewById(R.id.editText);
        Btn = (Button)findViewById(R.id.button3);


        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
        //final PyObject[] obj = {null};
        Python py = Python.getInstance();
        final PyObject pyobj = py.getModule("script");

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PyObject obj = pyobj.callAttr("main", Et1.getText().toString(), Et2.getText().toString());
                //Tv.setText(obj.toString());
                String str = Et1.getText().toString();
                openSecondActivity(str);

            }
        });
    }
    public void openSecondActivity(String str){
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("key", str);
        startActivity(intent);
    }
}
