package com.landayan.landayan_labexer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_username, et_password;
        Button btn_shared, btn_internal, btn_next;

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_shared = (Button) findViewById(R.id.btn_shared);
        btn_internal = (Button) findViewById(R.id.btn_internal);
        btn_next = (Button) findViewById(R.id.btn_next);

    }
}
