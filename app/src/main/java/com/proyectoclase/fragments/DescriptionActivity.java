package com.proyectoclase.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.proyectoclase.fragments.fragments.DescriptionFragment;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vertical_layout);
        String description = getIntent().getStringExtra("DESCRIPCION");
        String os = getIntent().getStringExtra("OS");
        DescriptionFragment textFragment = DescriptionFragment.newInstance(description,os);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedor,textFragment).commit();

    }
}