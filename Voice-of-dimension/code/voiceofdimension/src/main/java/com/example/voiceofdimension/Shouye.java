package com.example.voiceofdimension;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class Shouye extends Fragment implements View.OnClickListener{

    private ViewFlipper lunbo_filpper;
    private GestureDetector lunbo_gd;
    private ConstraintLayout tiezi_2;//首页关注安静欧尼帖子
    private ImageButton shoucang2;//欧尼收藏
    private TextView shoucang2_num;
    private ImageButton pinglun2;//欧尼评论
    private TextView pinglun2_num;
    private ImageButton dianzan2;//欧尼点赞
    private TextView dianzan2_num;
    private ImageButton fenxiang2;//欧尼分享
    private TextView fenxiang2_num;
    private boolean use_lunbotu;
    public Shouye() {

        // Required empty public constructor
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            //此界面可见
            use_lunbotu=true;
        }else {
            //此界面不可见
            use_lunbotu=false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_shouye, container, false);

        //将欧尼帖子注册监听
        tiezi_2=view.findViewById(R.id.shouye_guanzhu_2);
        tiezi_2.setOnClickListener(this);

        //给欧尼点赞收藏注册监听
        shoucang2 = view.findViewById(R.id.shoucang02);
        shoucang2_num = view.findViewById(R.id.shoucang02_num);
        pinglun2 = view.findViewById(R.id.pinglun02);
        pinglun2_num = view.findViewById(R.id.pinglun02_num);
        dianzan2 = view.findViewById(R.id.dianzan02);
        dianzan2_num = view.findViewById(R.id.dianzan02_num);
        fenxiang2 = view.findViewById(R.id.fenxiang02);
        fenxiang2_num = view.findViewById(R.id.fenxaing02_num);
        shoucang2.setOnClickListener(this);
        pinglun2.setOnClickListener(this);
        dianzan2.setOnClickListener(this);
        fenxiang2.setOnClickListener(this);

        //将myTouchListener注册到分发列表
        ((Home)this.getActivity()).registerMyTouchListener(myTouchListner);

        lunbo_filpper=view.findViewById(R.id.lunbotu);
        //创建检测器
        lunbo_gd= new GestureDetector(getContext(),new GestureListener());

        lunbo_filpper.setInAnimation(getContext(),R.anim.lunbo_in);
        lunbo_filpper.setOutAnimation(getContext(),R.anim.lunbo_out);
        lunbo_filpper.setFlipInterval(5000);
        lunbo_filpper.startFlipping();

        return view;
    }

    //轮播图手势操作
    private class GestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e2.getX()>e1.getX()){//右滑
                lunbo_filpper.setInAnimation(getContext(),R.anim.lunbo_in2);
                lunbo_filpper.setOutAnimation(getContext(),R.anim.lunbo_out2);
                lunbo_filpper.showPrevious();
            } else if(e1.getX()>e2.getX()){//左滑
                lunbo_filpper.setInAnimation(getContext(),R.anim.lunbo_in);
                lunbo_filpper.setOutAnimation(getContext(),R.anim.lunbo_out);
                lunbo_filpper.showNext();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    //Fragment中，注册接收Home的Touch回调的对象
    //重写其中的onTouchEvent函数，并进行该Fragment的逻辑处理
    Home.MyTouchListner myTouchListner = new Home.MyTouchListner() {
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //如果区域为轮播图则处理轮播图手势事件
            if(!inRangeOfView(lunbo_filpper,event)&&use_lunbotu){
                //区域是轮播图且fragment为shouye
                lunbo_gd.onTouchEvent(event);
                return false;//拖拽轮播图则返回false不能换页
            } else {
                //区域不是轮播图
                return true;//未拖拽轮播图则返回true能换页
            }
        }
    };

    //判断当前View 是否处于touch中
    public static boolean inRangeOfView(View view,MotionEvent ev){
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];

        if(ev.getX()<x || ev.getX()>(x+view.getWidth()) || ev.getY()<y+view.getHeight()){
            return false;
        }
        return true;
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.shouye_guanzhu_2:
                //点击安静安妮帖子
                Intent intent = new Intent(getActivity(),Tiezi_Ouni.class);
                startActivity(intent);
                break;
            case R.id.shoucang02:
                //收藏
                String num1 = shoucang2_num.getText().toString();
                int S_num1 = Integer.parseInt(num1);
                if(shoucang2.getTag().equals("unselect")){
                    shoucang2.setTag("select");
                    shoucang2.setImageResource(R.drawable.shoucang_1);
                    shoucang2_num.setText(S_num1+1+"");
                }else {
                    shoucang2.setTag("unselect");
                    shoucang2.setImageResource(R.drawable.shoucang_0);
                    shoucang2_num.setText(S_num1-1+"");
                }
                break;
            case R.id.pinglun02:
                //评论
                String num2 = pinglun2_num.getText().toString();
                int S_num2 = Integer.parseInt(num2);
                if(pinglun2.getTag().equals("unselect")){
                    pinglun2.setTag("select");
                    pinglun2.setImageResource(R.drawable.pinglun_1);
                    pinglun2_num.setText(S_num2+1+"");
                }
                break;
            case R.id.dianzan02:
                //点赞
                String num3 = dianzan2_num.getText().toString();
                int S_num3 = Integer.parseInt(num3);
                if(dianzan2.getTag().equals("unselect")){
                    dianzan2.setTag("select");
                    dianzan2.setImageResource(R.drawable.dianzan_1);
                    dianzan2_num.setText(S_num3+1+"");
                }else {
                    dianzan2.setTag("unselect");
                    dianzan2.setImageResource(R.drawable.dianzan_0);
                    dianzan2_num.setText(S_num3-1+"");
                }
                break;
            case R.id.fenxiang02:
                //分享
                String num4 = fenxiang2_num.getText().toString();
                int S_num4 = Integer.parseInt(num4);
                if(fenxiang2.getTag().equals("unselect")){
                    fenxiang2.setTag("select");
                    fenxiang2.setImageResource(R.drawable.fenxiang_1);
                    fenxiang2_num.setText(S_num4+1+"");
                }
                break;
            default:
                break;
        }
    }





}
