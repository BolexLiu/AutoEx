package com.bolex.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //  AutoEx.apply(getApplication()); 更加推荐把AutoEx放在Application中初始化
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout mainView = (LinearLayout) findViewById(R.id.activity_main);

    }
}
