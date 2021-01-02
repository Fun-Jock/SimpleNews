package com.lauren.simplenews.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lauren.simplenews.App;
import com.lauren.simplenews.R;
import com.lauren.simplenews.main.widget.MainActivity;

import java.util.HashMap;
import java.util.Map;



public class LoginActivity extends BaseAppCompatActivity {
    private static final String TAG = "LoginActivity";

    private EditText textUserName;
    private EditText textPassWord;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textUserName = (EditText) findViewById(R.id.username);
        textPassWord = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);

        Button reg = (Button) findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String uName = textUserName.getText().toString();
                final String pw = textPassWord.getText().toString();

                if (TextUtils.isEmpty(uName) || TextUtils.isEmpty(pw)) {
                    Toast.makeText(LoginActivity.this, "用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                showProgressDg("正在加载中。。。", true);

                Map<String, String> map = new HashMap<>();
                map.put("name", uName);
                map.put("passWord", pw);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final UserBean userBean = App.instance.getAppDataBase().userDao().login(uName, pw);
                        if (userBean != null){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    dismiss();
                            Log.e(TAG, "onNext: 333");
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            App.userBean = userBean;
                        }
                    });





                        }
                    }
                }).start();

//                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
//                String sp_pw = sharedPreferences.getString(uName, "");
//
//                if (!TextUtils.isEmpty(sp_pw)&&sp_pw.equals(pw)) {
//                    dismiss();
//                    Log.e(TAG, "onNext: 333");
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//
//                    UserBean userBean =new UserBean();
//                    userBean.setName(uName);
//                    App.userBean = userBean;
//                }


//                ApiHelper.getInstance().login(map).subscribe(new Subscriber<UserBean>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.e(TAG, "onCompleted: 111");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: 222");
//                    }
//
//                    @Override
//                    public void onNext(UserBean userBean) {
//                        dismiss();
//                        Log.e(TAG, "onNext: 333");
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        finish();
//
//                        App.userBean = userBean;
//                    }
//                });
            }
        });
    }

}
