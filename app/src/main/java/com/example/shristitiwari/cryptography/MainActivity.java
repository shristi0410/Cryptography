package com.example.shristitiwari.cryptography;


import android.app.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {



    private FrameLayout mainFrame;
    private  BottomNavigationView navigation;

    private HomeFragment homeFragment;
    private AimFragment aimFragment;
    private TheoryFragment theoryFragment;
    private ProcedureFragment procedureFragment;
    private StimulationFragment stimulationFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame,homeFragment).commit();
                    return true;
                case R.id.navigation_aim:
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame,aimFragment).commit();
                    return true;
                case R.id.navigation_theory:
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame,theoryFragment).commit();
                    return true;
                case R.id.navigation_procedure:
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame,procedureFragment).commit();
                    return true;

                case R.id.navigation_stimulation:
                    getFragmentManager().beginTransaction().replace(R.id.mainFrame,stimulationFragment).commit();
                    return true;
            }

            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFrame =(FrameLayout) findViewById(R.id.mainFrame);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        homeFragment= new HomeFragment();
        aimFragment= new AimFragment();
        theoryFragment= new TheoryFragment();
        procedureFragment= new ProcedureFragment();
        stimulationFragment= new StimulationFragment();



        getFragmentManager().beginTransaction().replace(R.id.mainFrame,homeFragment).commit();

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
