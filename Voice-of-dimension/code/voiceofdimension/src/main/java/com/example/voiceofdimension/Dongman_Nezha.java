package com.example.voiceofdimension;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Dongman_Nezha extends Activity implements View.OnClickListener {

    private ImageButton nezhaBack;
    private ImageButton peiyin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dongman__nezha);

        //释放顶部空间
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
        }

        nezhaBack = findViewById(R.id.nezhe_back);
        peiyin = findViewById(R.id.peiyin_go);

        nezhaBack.setOnClickListener(this);
        peiyin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.nezhe_back:
                Intent intent_nezha = new Intent(Dongman_Nezha.this,Home.class);
                intent_nezha.putExtra("id",4);
//                intent_nezha.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //不再重新加载
                startActivity(intent_nezha);
                break;
            case R.id.peiyin_go:
                Intent intent_peiyin = new Intent(Dongman_Nezha.this,Peiyin_Nezha.class);
                startActivity(intent_peiyin);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
