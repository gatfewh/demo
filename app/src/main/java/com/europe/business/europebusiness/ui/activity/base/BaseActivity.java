package com.europe.business.europebusiness.ui.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();

    }

    protected void toast(String a){
        Toast.makeText(this,a,Toast.LENGTH_SHORT).show();

    }
    protected void intent(Class i){
        Intent intent=new Intent(this,i);
        startActivity(intent);
    }
    protected abstract int setLayout();

    protected void startAct(Class cls,Bundle bundle){
        Intent intent=new Intent();
        intent.putExtras(bundle);
        intent.setClass(this,cls);
        startActivity(intent);

    }
    protected abstract void initView();

}
