package com.example.voiceofdimension;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Piaofu extends Activity implements View.OnClickListener{
    private ImageButton guanbi;
    private ImageView piaofuBeijing;
    static int id_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piaofu);

        //释放顶部空间
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
        }

        piaofuBeijing = findViewById(R.id.piaofu_beijing);

        guanbi = findViewById(R.id.fudong_guanbi);
        guanbi.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        int id = getIntent().getIntExtra("fu_id",0);
        id_back=id;
        if(id_back==0){
            piaofuBeijing.setImageResource(R.drawable.shouye_di);
        }else if(id_back==1){
            piaofuBeijing.setImageResource(R.drawable.bankuai_di);
        }else if(id_back==2){
            piaofuBeijing.setImageResource(R.drawable.xiaoxi_di);
        }else if(id_back==3){
            piaofuBeijing.setImageResource(R.drawable.wo_di);
        }
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fudong_guanbi:
                Intent intent_guanbi = new Intent(Piaofu.this,Home.class);
                System.out.println(id_back);
                if(id_back==0){
                    intent_guanbi.putExtra("id",0);
                }else if(id_back==1){
                    intent_guanbi.putExtra("id",1);
                }else if(id_back==2){
                    intent_guanbi.putExtra("id",2);
                }else if(id_back==3){
                    intent_guanbi.putExtra("id",3);
                }
                startActivity(intent_guanbi);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
