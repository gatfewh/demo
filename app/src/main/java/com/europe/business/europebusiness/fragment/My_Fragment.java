package com.europe.business.europebusiness.fragment;

import android.support.v4.app.Fragment;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.fragment.base.BaseFragment;

public class My_Fragment extends BaseFragment {


    @Override
    protected int setLayout() {
        return R.layout.fragment_my;
    }

    public static Fragment newInstance(){
        My_Fragment fragment=new My_Fragment();
        return fragment;
    }

}
