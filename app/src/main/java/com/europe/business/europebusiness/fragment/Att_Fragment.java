package com.europe.business.europebusiness.fragment;

import android.support.v4.app.Fragment;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.fragment.base.BaseFragment;

public class Att_Fragment extends BaseFragment {

    @Override
    protected int setLayout() {
        return R.layout.fragment_att;
    }

    public static Fragment newInstance(){
        Att_Fragment fragment=new Att_Fragment();
        return fragment;
    }
}
