package com.europe.business.europebusiness.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.ui.activity.bean.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends ActionBarActivity implements View.OnClickListener {
    private Button login;
    private LinearLayout msg,pass,msg_content,pass_content;
    private TextView line1,line2;
    private EditText input_phoneoremail,input_code;
    private static final String url="http://115.28.211.9:8080/exame/login_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucentStatus(this);

        login=findViewById(R.id.login);
        login.setOnClickListener(this);
        msg=findViewById(R.id.msg_login);
        msg.setOnClickListener(this);
        pass=findViewById(R.id.pass_login);
        pass.setOnClickListener(this);
        msg_content=findViewById(R.id.msg_content);
        pass_content=findViewById(R.id.pass_content);
        line1=findViewById(R.id.msg_line);
        line2=findViewById(R.id.pass_line);
        input_phoneoremail=findViewById(R.id.input_phoneoremail);
        input_code=findViewById(R.id.input_verification);
        setActionbarBackground();

    }

    @Override
    protected int setMainContent() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                /*String phoneoremail=input_phoneoremail.getText().toString();
                String code=input_code.getText().toString();
                if (TextUtils.isEmpty(phoneoremail)||TextUtils.isEmpty(code)){
                    toast("请检查");
                    return;

                }*/
                /*postrequest(phoneoremail,code);*/
                intent(MainActivity.class);
                break;
            case R.id.msg_login:
                line1.setVisibility(View.VISIBLE);
                line2.setVisibility(View.GONE);
                msg_content.setVisibility(View.VISIBLE);
                pass_content.setVisibility(View.GONE);
                break;
            case R.id.pass_login:
                line1.setVisibility(View.GONE);
                line2.setVisibility(View.VISIBLE);
                msg_content.setVisibility(View.GONE);
                pass_content.setVisibility(View.VISIBLE);
                break;
        }
    }
    private void postrequest(String phoneoremail,String code){
        OkHttpClient okHttpClient=new OkHttpClient();
        RequestBody requestBody=new FormBody.Builder()
                .add("name",phoneoremail)
                .add("password",code)
                .build();
        Request request=new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                toast("失败");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String str=response.body().string();
                runOnUiThread(new Runnable() {
                    Gson gson=new Gson();
                    final Result result=gson.fromJson(str,new TypeToken<Result>(){}.getType());
                    @Override
                    public void run() {
                        intent(MainActivity.class);
                        toast(result.getMessage());
                    }
                });
            }
        });




    }
}
