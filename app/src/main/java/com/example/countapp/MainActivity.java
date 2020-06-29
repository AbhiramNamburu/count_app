package com.example.countapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3;
    TextView tv;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.add);
        tv=findViewById(R.id.textcount);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             a++;
             tv.setText(""+a);
            }
        });
        b2=findViewById(R.id.sub);
        tv=findViewById(R.id.textcount);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a--;
                tv.setText(""+a);
            }
        });
        b3=findViewById(R.id.reset);
        tv=findViewById(R.id.textcount);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=0;
                tv.setText(""+a);
            }
        });
        if(savedInstanceState!=null){

            String s= savedInstanceState.getString("var");
            a = Integer.parseInt(s);
            tv.setText(""+a);
        }
    }


    public void display(View view) {
        String b =tv.getText().toString();
       Toast.makeText(this,"Your count is :"+b,Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("var",tv.getText().toString());
    }
}