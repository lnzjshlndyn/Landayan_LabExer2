package com.landayan.landayan_labexer2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button btn_shared, btn_internal, btn_next;
    SharedPreferences preferences;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_shared = (Button) findViewById(R.id.btn_shared);
        btn_internal = (Button) findViewById(R.id.btn_internal);
        btn_next = (Button) findViewById(R.id.btn_next);

        preferences = getSharedPreferences("prefer", Context.MODE_WORLD_READABLE);
    }

        public void Next(View view){
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            finish();

        }

        public void SharedPreferences(View view){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("user", et_username.getText().toString());
            editor.putString("pass", et_password.getText().toString());
            editor.commit();

            Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
        }

        public void InternalStorage(View view){
            String user = et_username.getText().toString();
            String pass = et_password.getText().toString();
            String output = "Internal Storage: The username: " + user + ", and password: " + pass;

            try{
                fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
                fos.write(output.getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try{
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Toast.makeText(this, "Saved in Internal Storage!", Toast.LENGTH_LONG).show();
        }
    }