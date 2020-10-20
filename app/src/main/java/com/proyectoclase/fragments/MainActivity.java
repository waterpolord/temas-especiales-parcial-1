package com.proyectoclase.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.proyectoclase.fragments.fragments.ComponentFragment;

public class MainActivity extends FragmentActivity {
    ComponentFragment componentFragment;
    String[] androidOS = new String[]{"Cupcake","Donut","Eclair","Froyo"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == 1) {
            setContentView(R.layout.vertical_layout);
            componentFragment = ComponentFragment.newInstance(androidOS);
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor,componentFragment).commit();
        }
        else{
            setContentView(R.layout.horizontal_layout);
        }


    }




}