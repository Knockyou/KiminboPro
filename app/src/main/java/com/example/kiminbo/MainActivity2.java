package com.example.kiminbo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {
    //내정보 TEst
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    View navHeader;

    FragmentManager fragmentManager; //Fragment 관리자

    MainFragment mainFragment; //Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //DrawerLayout
        drawer = (DrawerLayout) findViewById(R.id.main_drawer);

        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //navigation toggle home
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.d_open, R.string.d_close);
        toggle.syncState();
        //Fragment

        mainFragment= new MainFragment();

        //Fragment 배치
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.container, mainFragment, null);
        fragmentTransaction.commit();

        //NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navHeader = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.menu_home) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.replace(R.id.container, mainFragment, null);
                    fragmentTransaction.commit();
                    Toast.makeText(getApplicationContext(), "NavigationDrawer home", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.menu_menu1) {

                } else if (id == R.id.menu_menu2) {
                    Toast.makeText(getApplicationContext(), "NavigationDrawer menu2", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){  //navigation toggle
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
}