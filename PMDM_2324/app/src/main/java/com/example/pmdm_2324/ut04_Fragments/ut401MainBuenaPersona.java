package com.example.pmdm_2324.ut04_Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class ut401MainBuenaPersona extends AppCompatActivity {

    Fragment frameSinFumar, frameSinInsultar, frameSinPegar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut401_main_buena_persona);
        frameSinFumar = getSupportFragmentManager().findFragmentById(R.id.ut401idFragmentFumar);
        frameSinInsultar = getSupportFragmentManager().findFragmentById(R.id.ut401FragmentInsultar);
        frameSinPegar = getSupportFragmentManager().findFragmentById(R.id.ut401FragmentPegar);
    }
}