package com.example.voiceofdimension;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Xiaoxi extends Fragment {


    public Xiaoxi() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_xiaoxi, container, false);

        //将myTouchListener注册到分发列表
//        ((Home)this.getActivity()).registerMyTouchListener(myTouchListner);
        return view;
    }

//    Home.MyTouchListner myTouchListner = new Home.MyTouchListner() {
//        @Override
//        public boolean onTouchEvent(MotionEvent event) {
//            System.out.println("3触摸区域不是轮播图 返回t能翻页");
//
//            return true;
//        }
//    };

}
