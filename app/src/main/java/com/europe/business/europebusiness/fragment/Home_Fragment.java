package com.europe.business.europebusiness.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.adpater.MyEnterprise;
import com.europe.business.europebusiness.adpater.MyNewsAdpater;
import com.europe.business.europebusiness.adpater.MyfragmentAdapter;
import com.europe.business.europebusiness.fragment.base.BaseFragment;
import com.europe.business.europebusiness.ui.activity.bean.Enterprise;
import com.europe.business.europebusiness.ui.activity.bean.MyNews;


import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends BaseFragment {


    View view;
    private RecyclerView news_recy,news_recy1;
    private List<Enterprise> list=new ArrayList<>();
    private List<MyNews> list1=new ArrayList<>();
    private MyNewsAdpater myNewsAdpater;
    private MyEnterprise myEnterprise;
   @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(setLayout(),container,false);
        news_recy=view.findViewById(R.id.recommend_enterprise);
        news_recy1=view.findViewById(R.id.news_information);

        addNews();
        addEnterprise();

        return view;

    }

    public static Fragment newInstance(){
        Home_Fragment fragment=new Home_Fragment();
        return fragment;
    }


    private void addNews(){
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        news_recy.addItemDecoration(divider);
        list1Add();
        news_recy1.setLayoutManager(new LinearLayoutManager(getActivity()));
        myNewsAdpater=new MyNewsAdpater(list1);
        news_recy1.setAdapter(myNewsAdpater);


    }

    public void addEnterprise(){
        listAdd();
        LinearLayoutManager ms= new LinearLayoutManager(getActivity());
        ms.setOrientation(LinearLayoutManager.HORIZONTAL);
        news_recy.setLayoutManager(ms);
        myEnterprise=new MyEnterprise(list);
        news_recy.setAdapter(myEnterprise);
    }

    private void listAdd(){
        Enterprise enterprise=new Enterprise();
        enterprise.setImg(R.drawable.european_enterprises3_gone);
        enterprise.setName("我的企业");
        enterprise.setType("金融公司");
        enterprise.setCountry("中国");
        list.add(enterprise);

        enterprise.setImg(R.drawable.european_enterprises3_gone);
        enterprise.setName("我的企业");
        enterprise.setType("金融公司");
        enterprise.setCountry("中国");
        list.add(enterprise);

        enterprise.setImg(R.drawable.european_enterprises3_gone);
        enterprise.setName("我的企业");
        enterprise.setType("金融公司");
        enterprise.setCountry("中国");
        list.add(enterprise);

    }

    private void list1Add(){
        MyNews myNews=new MyNews();
        myNews.setImg(R.drawable.main_background);
        myNews.setTitle("123123");
        myNews.setTime("9-11");
        list1.add(myNews);


        myNews.setTitle("123123");
        myNews.setTime("9-11");
        list1.add(myNews);


        myNews.setImg(R.drawable.main_background);
        myNews.setTitle("123123");
        myNews.setTime("9-11");
        list1.add(myNews);


        myNews.setImg(R.drawable.main_background);
        myNews.setTitle("123123");
        myNews.setTime("9-11");
        list1.add(myNews);
    }




}
