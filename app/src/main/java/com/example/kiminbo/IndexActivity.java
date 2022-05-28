package com.example.kiminbo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.View;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class IndexActivity extends AppCompatActivity{
    TextView timeTabletext;
    View timeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_main);

        timeTable = findViewById(R.id.time_table_layout);

        timeTable.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                float curX = event.getX(); //눌린 곳의 X좌표
                float curY = event.getY(); //눌린 곳의 Y좌표

                if(action == event.ACTION_DOWN) { //처음 눌렸을 때
                    System.out.println("손가락 눌림 : " + curX + ", " + curY);
                } else if(action == event.ACTION_MOVE) { //누르고 움직였을 때
                    System.out.println("손가락 움직임 : " + curX + ", " + curY);
                } else if(action == event.ACTION_UP) { //누른걸 뗐을 때
                    System.out.println("손가락 뗌 : " + curX + ", " + curY);
                }
                return true;
            }
        });

        //private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { @Override public void onItemClick(AdapterView<?> parent, View view, int position, long l_position) {
        // parent는 AdapterView의 속성의 모두 사용 할 수 있다.
        //String tv = (String)parent.getAdapter().getItem(position); Toast.makeText(getApplicationContext(), tv, Toast.LENGTH_SHORT).show(); // view는 클릭한 Row의 view를 Object로 반환해 준다. TextView tv_view = (TextView)view.findViewById(R.id.tv_row_title); tv_view.setText("바꿈"); // Position 은 클릭한 Row의 position 을 반환해 준다. Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show(); // l_Position 은 클릭한 Row의 long type의 position 을 반환해 준다. Toast.makeText(getApplicationContext(), "l = " + l_position, Toast.LENGTH_SHORT).show(); } };



        //페이지 이동
        View commu_btn = findViewById(R.id.commu_btn);
        View notice_btn = findViewById(R.id.notice_btn);
        View prof_btn = findViewById(R.id.prof_btn);
        View docu_btn = findViewById(R.id.docu_btn);
        View mob_btn = findViewById(R.id.mob_btn);
        View ecl_btn = findViewById(R.id.ecl_btn);

        commu_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),CommunicationActivity.class);
                startActivity(intent);
            }
        });

        notice_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),NoticeActivity.class);
                startActivity(intent);
            }
        });

        prof_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),ProfActivity.class);
                startActivity(intent);
            }
        });

        docu_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),DocuActivity.class);
                startActivity(intent);
            }
        });

        mob_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MobActivity.class);
                startActivity(intent);
            }
        });

        ecl_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),EclActivity.class);
                startActivity(intent);
            }
        });


    }

    //시간표 만들기
    /*public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println(event.getAxisValue());
                timeTabletext = findViewById(R.id.mon_02);
                timeTabletext.setText("과학");
                break;
            *//*case MotionEvent.ACTION_MOVE:
                System.out.println("ddddd");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("ddddd");
                break;
            case MotionEvent.ACTION_CANCEL:
                System.out.println("ddddd");
                break;
            default:
                break;*//*
        }
        return true;
    }*/




}
