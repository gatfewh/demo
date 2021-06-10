package com.europe.business.europebusiness.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyfragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list=new ArrayList<>();

    public MyfragmentAdapter(FragmentManager fm,List<Fragment> list){

        super(fm);
        this.list=list;
    }

    public void addFragment(Fragment fragment){
        list.add(fragment);
    }
    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
