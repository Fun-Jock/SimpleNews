package com.lauren.simplenews.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lauren.simplenews.App;
import com.lauren.simplenews.R;


public class ModifyPwActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_pw);

        final TextView pw = (TextView) findViewById(R.id.pass_word);

        final TextView pwc = (TextView) findViewById(R.id.pass_word_comfirm);

        Button btn = (Button) findViewById(R.id.confirm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pws = pw.getText().toString();
                String pwcs = pwc.getText().toString();

                if (TextUtils.isEmpty(pws) || TextUtils.isEmpty(pwcs)) {
                    Toast.makeText(ModifyPwActivity.this, "输入内容不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.equals(pws, pwcs)) {
                    SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(App.userBean.getName(), pwcs);
                    editor.apply();

                    Toast.makeText(ModifyPwActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ModifyPwActivity.this, "两次输入不一致！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
