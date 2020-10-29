package com.example.voiceofdimension;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class WoShezhi extends Activity implements View.OnClickListener {

    private ImageButton shezhi_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wo_shezhi);

        //释放顶部空间
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
        }

        shezhi_back = findViewById(R.id.shezhi_back);
        shezhi_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shezhi_back:
                Intent intent_shezhi_back = new Intent(WoShezhi.this,Home.class);
                intent_shezhi_back.putExtra("id",3);
                startActivity(intent_shezhi_back);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
