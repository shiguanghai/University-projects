package com.example.voiceofdimension;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Wo extends Fragment implements View.OnClickListener{

    private ImageButton shezhi;


    public Wo() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wo, container, false);
        shezhi = view.findViewById(R.id.shezhi);
        shezhi.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shezhi:
                Intent intent_shezhi = new Intent(getActivity(),WoShezhi.class);
                startActivity(intent_shezhi);
                break;
            default:
                break;
        }
    }
}
