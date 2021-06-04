package com.example.a11791.widgettest_418lb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tv;
    private EditText et;
    private Button btngettext,btnsetimg;
    private ImageView iv;
    private ImageButton ibtn;
    private RadioGroup rg;
    private RadioButton rbnan,rbnv;
    private CheckBox cblan,cbzu,cbyou;
    private Button btngetgender,btngetfun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init()
    {
        tv=(TextView)findViewById(R.id.textView);
        et=(EditText) findViewById(R.id.editText);
        btngettext=(Button) findViewById(R.id.button);
        btnsetimg=(Button) findViewById(R.id.button2);
        iv=(ImageView) findViewById(R.id.imageView);
        ibtn=(ImageButton) findViewById(R.id.imageButton);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        rbnan=(RadioButton) findViewById(R.id.radioButton);
        rbnv=(RadioButton) findViewById(R.id.radioButton2);
        cblan=(CheckBox) findViewById(R.id.checkBox);
        cbzu=(CheckBox) findViewById(R.id.checkBox2);
        cbyou=(CheckBox) findViewById(R.id.checkBox3);
        btngetgender=(Button) findViewById(R.id.button4);
        btngetfun=(Button) findViewById(R.id.button5);

        btngettext.setOnClickListener(this);
        btnsetimg.setOnClickListener(this);
        ibtn.setOnClickListener(this);
        btngetgender.setOnClickListener(this);
        btngetfun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                String str=et.getText().toString();
                tv.setText(str);
                break;
            case R.id.button2:
                iv.setImageResource(R.drawable.steam);
                break;
            case R.id.imageButton:
                Intent intent=new Intent(MainActivity.this,NewActivity.class);
                intent.putExtra("param1",et.getText().toString());
                intent.putExtra("param2",3);
                startActivity(intent);
                break;
            case R.id.button4://获取性别
                if (rbnan.isChecked()) tv.setText("男");
                if (rbnv.isChecked()) tv.setText("女");
                break;
            case R.id.button5://兴趣
                String msg="";
                if (cblan.isChecked()) msg+="篮球";
                if (cbzu.isChecked()) msg+="足球";
                if (cbyou.isChecked()) msg+="排球";
                tv.setText(msg);
                break;
        }
    }
}
