package com.example.lera.megaminder;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MainActivity extends Activity {
    private Button logic, el;
    NumberPicker time;
    public int enabledTime;
    private EditText name;
    public String personName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        logic = (Button) findViewById(R.id.logic);
        el = (Button) findViewById(R.id.el);
        name = (EditText) findViewById(R.id.editName);
        time = (NumberPicker) findViewById(R.id.time);
        time.setMinValue(30);
        time.setMaxValue(300);
        time.setValue(60);

        logic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enabledTime = time.getValue();
                Intent intent = new Intent(MainActivity.this, LogicActivity.class);
                personName = name.getText().toString();
                startActivity(intent);
            }
        });
        el.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ELActivity.class);
//                personName = name.getText().toString();
//                startActivity(intent);
            }
        });
    }
}
