package com.example.a11791.statrtproject_418lb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a11791.statrtproject_418lb.bean.WeatherInfo;
import com.example.a11791.statrtproject_418lb.iface.WeatherListener;
import com.example.a11791.statrtproject_418lb.model.Weather51Model;
import com.example.a11791.statrtproject_418lb.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherListener,View.OnClickListener{
    private EditText etcityno;
    private Button btnfind1;
    private Button btnfind2;
    private TextView tvcityname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init()
    {
        etcityno=(EditText)findViewById(R.id.editText);
        btnfind1=(Button)findViewById(R.id.button);
        btnfind2=(Button)findViewById(R.id.button2);
        tvcityname=(TextView)findViewById(R.id.textView);

        btnfind1.setOnClickListener(this);
        btnfind2.setOnClickListener(this);
}

    @Override
    public void onResponse(WeatherInfo weatherInfo) {
        if (weatherInfo!=null)
        {
            tvcityname.setText(weatherInfo.getCity());
        }
        else
        {
            tvcityname.setText("未知");
        }
    }

    @Override
    public void onFail(String msg) {
        tvcityname.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                WeatherModel weatherModel=new WeatherModel();
                weatherModel.getWeather(etcityno.getText().toString(),this);
                break;
            case R.id.button2:
                Weather51Model weather51Model=new Weather51Model();
                weather51Model.getWeather(etcityno.getText().toString(),this);
                break;
            default:
                break;
        }
    }
}
