package com.example.voiceofdimension;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends Activity {
    private TextView tvTitle;
    private TextView tvForgetPwd;
    private TextView tvNewUser;
    private Button btnBack;
    private Button btnLogin;
    private Button btnRegister;
    private EditText etUsername;
    private EditText etPassword;

    //选项菜单就走onMenuItemSelected，如果是上下文菜单就走onContextItemSelected,onMenuItemSelected是通用的方法
    public boolean onMenuItemSelected(int featureId, android.view.MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            default:
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.CustomTheme);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_login);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        btnBack = (Button) findViewById(R.id.btn_first);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_second);
        tvForgetPwd = (TextView) findViewById(R.id.tv_forgetPassword);
        tvNewUser = (TextView) findViewById(R.id.tv_newUser);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvTitle.setText("登录");
        btnBack.setBackgroundResource(R.drawable.img_back);
        btnRegister.setText("注册");

        //实例化登录页面的监听器对象
        LoginOnClickListener loginOnClickListener = new LoginOnClickListener();
        //为可能点击的按钮绑定监听器
        btnBack.setOnClickListener(loginOnClickListener); //为【返回按钮】绑定监听器对象
        btnLogin.setOnClickListener(loginOnClickListener); //为【登录按钮】绑定监听器对象
        btnRegister.setOnClickListener(loginOnClickListener); //为【注册按钮】绑定监听器对象
        tvForgetPwd.setOnClickListener(loginOnClickListener); //为【忘记密码文本域】绑定监听器对象
        tvNewUser.setOnClickListener(loginOnClickListener); //为【新用户文本域】绑定监听器对象

    }

    private class LoginOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //控件被点击后执行的代码
            if(v.getId() == R.id.btn_first) { //返回上一级的按钮被单击
                Intent intent = new Intent(LoginActivity.this, Home.class);
                startActivity(intent);
                overridePendingTransition(R.anim.down_out, R.anim.down_in);
            }
            else if(v.getId() == R.id.btn_second || v.getId() == R.id.tv_newUser) { //用户注册的按钮或新用户的文本域被单击
//                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.go_in, R.anim.go_out);
            }
            else if(v.getId() == R.id.tv_forgetPassword) { //忘记密码的文本域被单击
//                Intent intent = new Intent(LoginActivity.this, ForgetPwdActivity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.go_in, R.anim.go_out);
            }
            else if(v.getId() == R.id.btn_login) { //用户登录的按钮被单击
                final String userName = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
//                Toast.makeText(LoginActivity.this,"用户名"+userName,Toast.LENGTH_LONG).show();
                if (userName.equals("") || password.equals("")) { //用户名或者密码未填写
                    Toast.makeText(getApplicationContext(), "请将用户名密码填写完全后再登录", Toast.LENGTH_LONG).show();
                } else {
                    //用户名密码均已正确填写
                    //登录过程
                    OkHttpClient client = new OkHttpClient();
                    RequestBody body = new FormBody.Builder()
                            .add("username",userName)
                            .add("password",password).build();
                    final Request request = new Request.Builder()
                            .url("http://shiguanghai.top/login.action")
                            .post(body).build();
                    Call call = client.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d("11111111111122","<<<<d="+e);
                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {

                            if (response.isSuccessful()){
                                String d = response.body().string();
                                Log.d("111111111111111","<<<<d="+d);
                                if (d.equals("user")){
                                    Intent intent = new Intent(LoginActivity.this,Home.class);
                                    startActivity(intent);
                                }
                                else {
                                    //子线程里面不能直接使用Toast
                                    Looper.prepare();
                                    Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
                                    Looper.loop();

                                }
                            }
                        }
                    });

                    //https://www.imooc.com/article/267877?block_id=tuijian_wz
                }
            }
        }
    }
}

