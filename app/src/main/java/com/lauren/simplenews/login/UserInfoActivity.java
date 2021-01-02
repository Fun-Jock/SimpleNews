package com.lauren.simplenews.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lauren.simplenews.App;
import com.lauren.simplenews.R;


public class UserInfoActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView name = (TextView) findViewById(R.id.username);
        name.setText(App.userBean.getName());

        TextView resetPW = (TextView) findViewById(R.id.modify_pw);
        resetPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserInfoActivity.this, ModifyPwActivity.class));
            }
        });
    }
}
