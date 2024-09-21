package com.example.pmdm_2324.ut04_Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.pmdm_2324.R;

public class ut403MainPingPong extends AppCompatActivity {
    Fragment partido1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut403_main_ping_pong);
        partido1=(ut403PingPong)getSupportFragmentManager().findFragmentById(R.id.ut403idfrPartido1);

    }
}