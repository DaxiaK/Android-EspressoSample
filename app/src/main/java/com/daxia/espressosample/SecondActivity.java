package com.daxia.espressosample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by daxia on 2016/6/8.
 */
public class SecondActivity extends Activity {

    private TextView TV_second_activity_str;

    @Override
    public void onCreate(Bundle savedInstanceStat) {
        super.onCreate(savedInstanceStat);
        setContentView(R.layout.activity_second);
        TV_second_activity_str = (TextView) findViewById(R.id.TV_second_activity_str);
        Bundle b = this.getIntent().getExtras();
        TV_second_activity_str.setText(b.getString("Str"));
    }
}
