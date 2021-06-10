package com.europe.business.europebusiness.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.fragment.Att_Fragment;
import com.europe.business.europebusiness.fragment.Cn_Fragment;
import com.europe.business.europebusiness.fragment.Eu_Fragment;
import com.europe.business.europebusiness.fragment.Home_Fragment;
import com.europe.business.europebusiness.fragment.My_Fragment;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private LinearLayout mcontrainer;
    private RadioGroup mRg;
    Fragment mfragment;
    private String[] mFragmentTag={"HomeFragment","EuFragment","CnFragment","AttFragment","MyFragment"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucentStatus(this);
        initFragment(0);
        setNavRadioButonChecked(0);

    }

    @Override
    protected int setMainContent() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        setToolbarVisible(View.GONE);
        mcontrainer=findViewById(R.id.container);
        mRg=findViewById(R.id.myRadio);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index=-1;
                switch (checkedId){
                    case R.id.main_btn:
                        index=0;

                        break;
                    case R.id.european_btn:
                        index=1;

                        break;
                    case R.id.chinese_btn:

                        index=2;
                        break;
                    case R.id.follow_btn:
                        index=3;
                        break;
                    case R.id.mine_btn:
                        index=4;
                        break;
                }
                initFragment(index);
            }
        });

    }

    private void initFragment(int index){
        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=fragmentManager.findFragmentByTag(mFragmentTag[index]);
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        if (null==fragment){
            switch (index){
                case 0:
                    fragment=Home_Fragment.newInstance();
                    fragmentTransaction.add(R.id.container,fragment,mFragmentTag[index]);

                    break;
                case 1:
                    fragment=Eu_Fragment.newInstance();
                    fragmentTransaction.add(R.id.container,fragment,mFragmentTag[index]);


                    break;
                case 2:
                    fragment=Cn_Fragment.newInstance();
                    fragmentTransaction.add(R.id.container,fragment,mFragmentTag[index]);
                    break;
                case 3:
                    fragment=Att_Fragment.newInstance();
                    fragmentTransaction.add(R.id.container,fragment,mFragmentTag[index]);
                    break;
                case 4:
                    fragment=My_Fragment.newInstance();
                    fragmentTransaction.add(R.id.container,fragment,mFragmentTag[index]);
                    break;
            }
        }
        if (mfragment != null){
            fragmentTransaction.hide(mfragment);
        }
        mfragment=fragment;
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();

    }

    private void setNavRadioButonChecked(int index){
        int viewId=-1;
        switch (index){
            case 0:
                viewId=R.id.main_btn;
                break;
            case 1:
                viewId=R.id.european_btn;
                break;
            case 2:
                viewId=R.id.chinese_btn;
                break;
            case 3:
                viewId=R.id.follow_btn;
                break;
            case 4:
                viewId=R.id.mine_btn;
                break;
        }
        if (viewId==-1){
            return;
        }
        ((RadioButton)findViewById(viewId)).setChecked(true);
    }
    @Override
    public void onClick(View v) {

    }


}
