package com.example.voiceofdimension;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;



import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Bankuai extends Fragment implements View.OnClickListener {

    private List<Fragment> bankuai_FragmentList; //存储列表对象
    private FragmentPagerAdapter bankuai_Adapter;
    private List<Fragment> bankuai_fragments;
    private SlideViewPager bankuai_viewPager;//实例

    //版块三个实现
    private LinearLayout piaTab;
    private LinearLayout qingTab;
    private LinearLayout dongTab;

    //版块三个图片
    private ImageButton piaImg;
    private ImageButton qingImg;
    private ImageButton dongImg;



    public Bankuai() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_bankuai, container, false);

        bankuai_viewPager=view.findViewById(R.id.bankuai_piaxi);
//        bankuai_viewPager.setOffscreenPageLimit(6);
        piaTab = view.findViewById(R.id.tab_pia);
        qingTab = view.findViewById(R.id.tab_qing);
        dongTab = view.findViewById(R.id.tab_dong);

        piaImg = view.findViewById(R.id.pia_img);
        qingImg = view.findViewById(R.id.qing_img);
        dongImg = view.findViewById(R.id.dong_img);
        initView();
        piaTab.setOnClickListener(this);
        qingTab.setOnClickListener(this);
        dongTab.setOnClickListener(this);
        setSelect(0);
//        bankuai_viewPager.setOffscreenPageLimit(6);

        return view;
    }


    @Override
    public void onResume() {
        int id = getActivity().getIntent().getIntExtra("id",0);
        System.out.println("版块id"+id);
        if(id==4){
//            Fragment fragmen = new Dongman();
//            FragmentManager fmanger = getFragmentManager();
//            FragmentTransaction transaction = fmanger.beginTransaction();
//            transaction.replace(R.id.bankuai_piaxi,fragmen);
//            transaction.commit();
            setSelect(2);
//            System.out.println("加载动漫");
        }
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tab_pia:
                setSelect(0);
                System.out.println("111");
                break;
            case R.id.tab_qing:
                setSelect(1);
                System.out.println("222");
                break;
            case R.id.tab_dong:
                setSelect(2);
                System.out.println("333");
                break;
            default:
                break;
        }
    }




//    //自定义一个适配器
    class BankuaiFragmentAdapter extends FragmentPagerAdapter{

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
    }

    public BankuaiFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            bankuai_FragmentList = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return bankuai_FragmentList.get(position);
        }

        @Override
        public int getCount() {
            return bankuai_FragmentList.size();
        }
    }

    private void initView(){

//        bankuai_viewPager = getView().findViewById(R.id.bankuai_piaxi);

//        piaTab = getActivity().findViewById(R.id.tab_pia);
//        qingTab = getActivity().findViewById(R.id.tab_qing);
//        dongTab = getActivity().findViewById(R.id.tab_dong);
//
//        piaImg = getActivity().findViewById(R.id.pia_img);
//        qingImg = getActivity().findViewById(R.id.qing_img);
//        dongImg = getActivity().findViewById(R.id.dong_img);

        bankuai_fragments = new ArrayList<Fragment>();
        bankuai_fragments.add(new PiaXi());
        bankuai_fragments.add(new Qingganshuo());
        bankuai_fragments.add(new Dongman());


        bankuai_Adapter = new BankuaiFragmentAdapter(getFragmentManager(),bankuai_fragments);

        //设置加载适配器
        bankuai_viewPager.setAdapter(bankuai_Adapter);




        //作用是随着ViewPager的滑动，底部tabs也跟随变动
        bankuai_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int currentItem = bankuai_viewPager.getCurrentItem();
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


    private void setTab(int i){
        resetImag();
        switch (i){
            case 0:
                piaImg.setImageResource(R.drawable.pia1);
                break;
            case 1:
                qingImg.setImageResource(R.drawable.qingganshuo1);
                break;
            case 2:
                dongImg.setImageResource(R.drawable.dongman1);
                break;
            default:
                break;
        }

    }

    private void resetImag(){
        piaImg.setImageResource(R.drawable.pia);
        qingImg.setImageResource(R.drawable.qingganshuo);
        dongImg.setImageResource(R.drawable.dongman);
    }

    private void setSelect(int i){
        setTab(i);
        bankuai_viewPager.setCurrentItem(i);
    }

}
