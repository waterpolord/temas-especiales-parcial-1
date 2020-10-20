package com.proyectoclase.fragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.proyectoclase.fragments.R;

public class DescriptionFragment extends Fragment {
    TextView txt,vers;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.description_fragment_layout,container,false);
        txt =    view.findViewById(R.id.txtName);
        vers =  view.findViewById(R.id.txtDescription);
        try {
            String description = getArguments().getString("DESCRIPCION");
            String os = getArguments().getString("OS");
            txt.setText(os);
            vers.setText(description);
        }catch (Exception e){
           /* txt.setText("os");
            vers.setText("description");*/
        }

        return view;
    }

    public static DescriptionFragment newInstance(String description,String os){

        DescriptionFragment descriptionFragment = new DescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DESCRIPCION",description);
        bundle.putString("OS",os);
        descriptionFragment.setArguments(bundle);
        return descriptionFragment;
    }

    public void change(String str1,String str2){
        txt.setText(str1);
        vers.setText(str2);
    }
}
