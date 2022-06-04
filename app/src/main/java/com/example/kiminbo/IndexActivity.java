package com.example.kiminbo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Debug;
import android.service.autofill.OnClickAction;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.google.android.material.navigation.NavigationView;

public class IndexActivity extends AppCompatActivity{
    //달력
    public String fname=null;
    public String str=null;
    public CalendarView calendarView;
    public Button cha_Btn,del_Btn,save_Btn;
    public TextView textView2;
    public EditText contextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_main);

        //[달력]
        calendarView=findViewById(R.id.calendarView);
        //diaryTextView=findViewById(R.id.diaryTextView);
        save_Btn=findViewById(R.id.save_Btn);
        del_Btn=findViewById(R.id.del_Btn);
        cha_Btn=findViewById(R.id.cha_Btn);
        textView2=findViewById(R.id.textView2);
        //textView3=findViewById(R.id.textView3);
        contextEditText=findViewById(R.id.contextEditText);
        //로그인 및 회원가입 엑티비티에서 이름을 받아옴
        Intent intent=getIntent();
        String name=intent.getStringExtra("userName");
        //String name="김승훈";
        final String userID=intent.getStringExtra("userID");
        //textView3.setText(name+"님의 시간표");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                //diaryTextView.setText(String.format("%d / %d / %d",year,month+1,dayOfMonth));
                contextEditText.setText("");
                checkDay(year,month,dayOfMonth,userID);
            }
        });
        save_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDiary(fname);
                str=contextEditText.getText().toString();
                textView2.setText(str);
                save_Btn.setVisibility(View.INVISIBLE);
                cha_Btn.setVisibility(View.VISIBLE);
                del_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.VISIBLE);

            }
        });

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

    public void  checkDay(int cYear,int cMonth,int cDay,String userID){
        fname=""+userID+cYear+"-"+(cMonth+1)+""+"-"+cDay+".txt";//저장할 파일 이름설정
        FileInputStream fis=null;//FileStream fis 변수

        try{
            fis=openFileInput(fname);

            byte[] fileData=new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            str=new String(fileData);

            contextEditText.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(str);

            save_Btn.setVisibility(View.INVISIBLE);
            cha_Btn.setVisibility(View.VISIBLE);
            del_Btn.setVisibility(View.VISIBLE);

            cha_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    contextEditText.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText(str);

                    save_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                    textView2.setText(contextEditText.getText());
                }

            });
            del_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView2.setVisibility(View.INVISIBLE);
                    contextEditText.setText("");
                    contextEditText.setVisibility(View.VISIBLE);
                    save_Btn.setVisibility(View.VISIBLE);
                    cha_Btn.setVisibility(View.INVISIBLE);
                    del_Btn.setVisibility(View.INVISIBLE);
                    removeDiary(fname);
                }
            });
            if(textView2.getText()==null){
                textView2.setVisibility(View.INVISIBLE);
                //diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.INVISIBLE);
                del_Btn.setVisibility(View.INVISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay){
        FileOutputStream fos=null;

        try{
            fos=openFileOutput(readDay,MODE_NO_LOCALIZED_COLLATORS);
            String content="";
            fos.write((content).getBytes());
            fos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay) {
        FileOutputStream fos = null;

        try {
            fos = openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = contextEditText.getText().toString();
            fos.write((content).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
