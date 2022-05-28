package com.example.kiminbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class EclActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecl);

        ListViewAdapter adapter = null;

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("http://cyber.mjc.ac.kr/index.jsp"));
        startActivity(i);

        View back_btn = findViewById(R.id.back_btn);


        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),IndexActivity.class);
                startActivity(intent);
            }
        });
    }

    private class ListViewAdapter {
    }
}