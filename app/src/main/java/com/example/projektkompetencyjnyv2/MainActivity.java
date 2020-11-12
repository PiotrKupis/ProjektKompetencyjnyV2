package com.example.projektkompetencyjnyv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT="com.example.projektkompetencyjnyv2.EXTRA_TEXT";
    public static final String EXTRA_NUMBER="com.example.projektkompetencyjnyv2.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_courses:
                            selectedFragment = new CoursesFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };


    public void registerBtnClick(View view) {
        Intent myIntent = new Intent(getBaseContext(), register.class);
        startActivity(myIntent);
    }

    public void moveToWordLists(View view){
        EditText userIdEdtTxt=findViewById(R.id.userIdTxt);
        int userId=Integer.parseInt(userIdEdtTxt.getText().toString());

        Intent intent=new Intent(this,WordLists.class);
        intent.putExtra(EXTRA_NUMBER,userId);

        startActivity(intent);
    }

    public void bodyPartsClick(View view) {
        Intent myIntent = new Intent(getBaseContext(), PlantsDifficulty.class);
        startActivity(myIntent);
    }

    //jest inne niż to wyżej bo jest na dolnym pasku???
//    public void profileClick(MenuItem item) {
//        Intent myIntent = new Intent(getBaseContext(), Profile.class);
//        startActivity(myIntent);
//    }
}