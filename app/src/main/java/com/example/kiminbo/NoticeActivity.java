package com.example.kiminbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        View back_btn = findViewById(R.id.back_btn);
        View notice_btn = findViewById(R.id.notice_btn);
        View notice2_btn = findViewById(R.id.notice2_btn);
        View notice3_btn = findViewById(R.id.notice3_btn);


        back_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),IndexActivity.class);
                startActivity(intent);
            }
        });

        notice_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.mjc.ac.kr/bbs/data/list.do?menu_idx=66"));
                startActivity(i);

            }
        });

        notice2_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.mjc.ac.kr/bbs/data/list.do?menu_idx=169"));
                startActivity(i);

            }
        });

        notice3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://cafe.naver.com/iseaas"));
                startActivity(i);
            }
        });



    }
}