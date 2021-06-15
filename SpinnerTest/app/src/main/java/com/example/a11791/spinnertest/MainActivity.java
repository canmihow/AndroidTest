package com.example.a11791.spinnertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvinfo;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        String[] cities={"北京","上海","天津","大连"};
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                cities

        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setPrompt("请选择城市");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    tvinfo.setText("您选择的是:"
           +parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
    }

    private void init() {
        tvinfo=(TextView)findViewById(R.id.textView);
        spinner=(Spinner)findViewById(R.id.spinner);
    }
}
