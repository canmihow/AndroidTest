package com.example.a11791.widgettest_418lb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent intent=getIntent();
        String str=intent.getStringExtra("param1");
        int n=intent.getIntExtra("param2",10);
        System.out.println("----"+str+"--"+String.valueOf(n));
        Toast.makeText(this, str+"--"+String.valueOf(n), Toast.LENGTH_SHORT).show();
        TextView tv=(TextView) findViewById(R.id.textView2);
        tv.setText(str+"--"+String.valueOf(n));
        Button button=(Button)findViewById(R.id.button3);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button3:
                finish();
        }
    }
}
