package com.example.voiceofdimension;


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Tiezi_Ouni extends Activity implements View.OnClickListener {

    private ImageButton ouni_back;
    private ImageButton ouni__guanzhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiezi__ouni);

        //释放顶部空间
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
        }

        ouni_back = findViewById(R.id.ouni_back);
        ouni_back.setOnClickListener(this);

        ouni__guanzhu = findViewById(R.id.ouni_guanzhu);
        ouni__guanzhu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ouni_back:
                Intent intent_ouni = new Intent(Tiezi_Ouni.this,Home.class);
                startActivity(intent_ouni);
                break;
            case R.id.ouni_guanzhu:
                if(ouni__guanzhu.getTag().equals("unselect")){
                    ouni__guanzhu.setTag("select");
                    ouni__guanzhu.setImageResource(R.drawable.guanzhu_xin_1);
                } else {
                    ouni__guanzhu.setTag("unselect");
                    ouni__guanzhu.setImageResource(R.drawable.guanzhu_xin_0);
                }

                break;
            default:
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
