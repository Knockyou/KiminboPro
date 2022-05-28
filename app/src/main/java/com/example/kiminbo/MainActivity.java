package com.example.kiminbo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        View login_btn = findViewById(R.id.login_btn);
        EditText id_text = findViewById(R.id.id_str);
        EditText pwd_text = findViewById(R.id.pwd_str);

        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder notice_alter = new AlertDialog.Builder(MainActivity.this);

                if(id_text.getText().toString().length() <= 0 || pwd_text.getText().toString().length() <= 0){
                    notice_alter.setTitle("Notice");
                    notice_alter.setMessage("Check the your id, pwd");
                    notice_alter.show();
                }else{
                    //notice_alter.setTitle("Sucess");
                    notice_alter.setMessage("id:"+id_text.getText().toString()+"\n"+"pwd:"+pwd_text.getText().toString());
                    notice_alter.show();

                    //Response.Li



                    Intent intent = new Intent(getApplicationContext(),IndexActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}