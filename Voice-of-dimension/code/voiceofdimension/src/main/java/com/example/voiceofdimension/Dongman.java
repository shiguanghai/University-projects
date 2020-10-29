package com.example.voiceofdimension;


import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dongman extends Fragment implements View.OnClickListener{

    private ConstraintLayout nezha;

    public Dongman() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dongman, container, false);
        // Inflate the layout for this fragment

        nezha = view.findViewById(R.id.dongman_nezha);
        nezha.setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dongman_nezha:
                //点击哪吒版区
                Intent intent_nezha = new Intent(getActivity(),Dongman_Nezha.class);
                startActivity(intent_nezha);
                break;
            default:
                break;
        }
    }
}
