package com.lauren.simplenews.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lauren.simplenews.App;
import com.lauren.simplenews.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseAppCompatActivity implements View.OnClickListener {
    @Bind(R.id.username)
    EditText username;
    @Bind(R.id.pass_word)
    EditText passWord;
    @Bind(R.id.confirm)
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);
        ButterKnife.bind(this);

        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.confirm:
                showProgressDg("正在加载中", true);
                final String passWordStr = passWord.getText().toString();
                final String userNameStr = username.getText().toString();

                if (TextUtils.isEmpty(userNameStr)) {
                    showInfo("账号不能为空");
                    return;
                }

                if (TextUtils.isEmpty(passWordStr)) {
                    showInfo("密码不能为空");
                    return;
                }


                Map<String, String> map = new HashMap<>();
                map.put("name", userNameStr);
                map.put("password", passWordStr);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserBean userBean = new UserBean();
                        userBean.setName(userNameStr);
                        userBean.setPassword(passWordStr);
                        App.instance.getAppDataBase().userDao().inserUser(userBean);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dismiss();
                                Toast.makeText(RegisterActivity.this, "提交成功！", Toast.LENGTH_SHORT).show();
                            }
                        });

                        finish();
                    }
                }).start();

//                SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString(userNameStr, passWordStr);
//                editor.apply();




//                ApiHelper.getInstance().insert(map).subscribe(new Subscriber<UserBean>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(UserBean userBean) {
//                        dismiss();
//                        Toast.makeText(RegisterActivity.this,"提交成功！",Toast.LENGTH_SHORT).show();
//                        username.setText("");
//                        passWord.setText("");
//                    }
//                });
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
