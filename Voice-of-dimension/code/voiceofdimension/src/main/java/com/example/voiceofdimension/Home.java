package com.example.voiceofdimension;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;


public class Home extends FragmentActivity implements View.OnClickListener {

    private List<Fragment> mFragmentList; //存储列表对象
    private SlideViewPager mviewPager;//实例
    private MyFragmentAdapter myFragmentAdapter;
    private List<Fragment> fragments;

    //底部四个linerlayout控件
    private LinearLayout shouyeTab;
    private LinearLayout bankuaiTab;
    private LinearLayout xiaoxiTab;
    private LinearLayout woTab;
    //添加按钮
    private ImageButton tianjia;
//    private ImageButton piaofuBeijing;

    //底部四个Tab:imagebutton
    private ImageButton shouyeImg;
    private ImageButton bankuaiImg;
    private ImageButton xiaoxiImg;
    private ImageButton woImg;

    //底部四个Tab:TextView
    private TextView shouyeText;
    private TextView bankuaiText;
    private TextView xiaoxiText;
    private TextView woText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //释放顶部空间
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
        }

        initView();
        initEvents();
        setSelect(0);//默认在首页运行

    }

    @Override
    protected void onResume() {
        int id = getIntent().getIntExtra("id",0);
        System.out.println(id);
        if(id==0){
//            Fragment fragmen = new Shouye();
//            FragmentManager fmanger = getSupportFragmentManager();
//            FragmentTransaction transaction = fmanger.beginTransaction();
//            transaction.replace(R.id.vp,fragmen);
//            transaction.commit();
            setSelect(0);
        }else if(id==1){
//            Fragment fragmen = new Bankuai();
//            FragmentManager fmanger = getSupportFragmentManager();
//            FragmentTransaction transaction = fmanger.beginTransaction();
//            transaction.replace(R.id.vp,fragmen);
//            transaction.commit();
            setSelect(1);
//            System.out.println("加载版块");
//            Intent ib = new Intent(Home.this,Bankuai.class);
//            ib.putExtra("id",1);
//            startActivity(ib);
        }else if(id==2){
//            Fragment fragmen = new Xiaoxi();
//            FragmentManager fmanger = getSupportFragmentManager();
//            FragmentTransaction transaction = fmanger.beginTransaction();
//            transaction.replace(R.id.vp,fragmen);
//            transaction.commit();
            setSelect(2);
        }else if(id==3){
//            Fragment fragmen =new Wo();
//            FragmentManager fmanger = getSupportFragmentManager();
//            FragmentTransaction transaction = fmanger.beginTransaction();
//            transaction.replace(R.id.vp,fragmen);
//            transaction.commit();
            setSelect(3);
        }else if(id==4){
            setSelect(1);
        }
        super.onResume();
    }

    @Override
    public void onClick(View v) {//导航栏点击事件 实现onclicklistener
       // resetImag();//点击事件，设置导航图标为灰色
        switch (v.getId()){
            case R.id.tab_shouye:
                setSelect(0);//点击首页
                break;
            case R.id.tab_bankuai:
                setSelect(1);//点击板块
                break;
            case R.id.tab_xiaoxi:
                setSelect(2);//点击消息
                break;
            case R.id.tab_wo:
                setSelect(3);//点击我
                break;
            case R.id.tianjia:
                //点击添加
                Intent intent_tianjia = new Intent(Home.this,Piaofu.class);
                if(shouyeImg.getTag().equals("select")){
                    intent_tianjia.putExtra("fu_id",0);
                }else if(bankuaiImg.getTag().equals("select")){
                    intent_tianjia.putExtra("fu_id",1);
                }else if(xiaoxiImg.getTag().equals("select")){
                    intent_tianjia.putExtra("fu_id",2);
                }else if(woImg.getTag().equals("select")){
                    intent_tianjia.putExtra("fu_id",3);
                }
//                finish();
                startActivity(intent_tianjia);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    //自定义一个适配器
    class MyFragmentAdapter extends FragmentPagerAdapter{

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
        }

        public MyFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragmentList = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

    private void initView(){
        mviewPager = findViewById(R.id.vp);

        //Tab
        shouyeTab = findViewById(R.id.tab_shouye);
        bankuaiTab = findViewById(R.id.tab_bankuai);
        xiaoxiTab = findViewById(R.id.tab_xiaoxi);
        woTab = findViewById(R.id.tab_wo);

        tianjia = findViewById(R.id.tianjia);
//        piaofuBeijing = findViewById(R.id.piaofu_beijing);

        //ImageButton
        shouyeImg = findViewById(R.id.shouye);
        bankuaiImg = findViewById(R.id.bankuai);
        xiaoxiImg = findViewById(R.id.xiaoxi);
        woImg = findViewById(R.id.wo);

        //TextView
        shouyeText = findViewById(R.id.shouye_text);
        bankuaiText = findViewById(R.id.bankuai_text);
        xiaoxiText = findViewById(R.id.xiaoxi_text);
        woText = findViewById(R.id.wo_text);


        //构造适配器
        fragments = new ArrayList<Fragment>();
        fragments.add(new Shouye());
        fragments.add(new Bankuai());
        fragments.add(new Xiaoxi());
        fragments.add(new Wo());
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),fragments);

        //设置加载适配器
        mviewPager.setAdapter(myFragmentAdapter);

        //作用是随着ViewPager的滑动，底部tabs也跟随变动
        mviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int currentItem = mviewPager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initEvents(){
        shouyeTab.setOnClickListener(this);
        bankuaiTab.setOnClickListener(this);
        xiaoxiTab.setOnClickListener(this);
        woTab.setOnClickListener(this);

        tianjia.setOnClickListener(this);
    }

    //根据位置i，设置对应的ImageButton和TextView设置为pressed
    private void setTab(int i){
        resetImag();//点击事件，设置导航图标为灰色
        resetText();//点击事件，设置导航描述为灰色
        switch (i){
            case 0:
                shouyeImg.setImageResource(R.drawable.shouye_1);
                shouyeImg.setTag("select");
//                piaofuBeijing.setImageResource(R.drawable.shouye_di);
                shouyeText.setTextColor(Color.BLACK);
                break;
            case 1:
                bankuaiImg.setImageResource(R.drawable.bankuai_1);
                bankuaiImg.setTag("select");
//                piaofuBeijing.setImageResource(R.drawable.bankuai_di);
                bankuaiText.setTextColor(Color.BLACK);
                break;
            case 2:
                xiaoxiImg.setImageResource(R.drawable.xiaoxi_1);
                xiaoxiImg.setTag("select");
//                piaofuBeijing.setImageResource(R.drawable.xiaoxi_di);
                xiaoxiText.setTextColor(Color.BLACK);
                break;
            case 3:
                woImg.setImageResource(R.drawable.wo_1);
                woImg.setTag("select");
//                piaofuBeijing.setImageResource(R.drawable.wo_di);
                woText.setTextColor(Color.BLACK);
                break;
            default:
                break;
        }
    }

    //底部四个ImageButton都置为normal
    private void resetImag(){
        shouyeImg.setImageResource(R.drawable.shouye_0);
        shouyeImg.setTag("unselect");
        bankuaiImg.setImageResource(R.drawable.bankuai_0);
        bankuaiImg.setTag("unselect");
        xiaoxiImg.setImageResource(R.drawable.xiaoxi_0);
        xiaoxiImg.setTag("unselect");
        woImg.setImageResource(R.drawable.wo_0);
        woImg.setTag("unselect");
    }

    //底部四个TextView都置为normal
    private void resetText(){
        shouyeText.setTextColor(Color.GRAY);
        bankuaiText.setTextColor(Color.GRAY);
        xiaoxiText.setTextColor(Color.GRAY);
        woText.setTextColor(Color.GRAY);
    }

    private void setSelect(int i){
        setTab(i);//改变点击的图标及描述
        mviewPager.setCurrentItem(i);//改变fragment
    }



    //以下均为OnTouch实现

    public interface MyTouchListner{
        boolean onTouchEvent(MotionEvent event);
    }
    //保存MyTouchListener接口列表
    private ArrayList<MyTouchListner> myTouchListners = new ArrayList<>();

    //提供给Fragment通过getActivity()方法来注册自己的触摸事件的方法
    public void registerMyTouchListener(MyTouchListner listner){
        myTouchListners.add(listner);
    }

    //提供给Fragment通过getActivity()方法来取消注册自己的触摸事件的方法
    public void unRegisterMyTouchListener(MyTouchListner listner){
        myTouchListners.remove(listner);
    }

    //分发触摸事件给所有注册了MyTouchListener的接口
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        for(MyTouchListner listner : myTouchListners){
            if(listner != null){
                mviewPager.setIsScanScroll(listner.onTouchEvent(ev));
            }
        }
        return super.dispatchTouchEvent(ev);
    }



}
