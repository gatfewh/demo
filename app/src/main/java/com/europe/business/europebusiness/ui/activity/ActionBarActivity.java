package com.europe.business.europebusiness.ui.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.ui.activity.base.BaseActivity;

public abstract class ActionBarActivity extends BaseActivity {
    private android.support.v7.widget.Toolbar toolbar;
    private LinearLayout content;
    private TextView title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayout() {
        return R.layout.action_bar;
    }

    protected void initView(){
        initToolbar();
        content=findViewById(R.id.content);
        int layout=setMainContent();
        View view= LayoutInflater.from(this).inflate(layout,content,false);
        content.addView(view);

    }
    protected void initToolbar( ){
        toolbar=findViewById(R.id.toolbar);
        title=findViewById(R.id.title);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(R.drawable.back3);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    protected abstract int setMainContent();

    protected void setToolbarNavigationIcon(int drawable){
        toolbar.setNavigationIcon(drawable);
    }

    protected void setToolbarVisible(int visible){
        toolbar.setVisibility(visible);
    }
    protected void setTitle(String titleStr){
        title.setText(titleStr);
    }

    protected void setActionbarBackground(){
        toolbar.setBackgroundColor(getResources().getColor(R.color.white));
    }
    protected void setToolbarAlpha(){
        toolbar.getBackground().setAlpha(0);
    }


}
