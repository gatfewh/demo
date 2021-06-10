package com.europe.business.europebusiness.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.adpater.MyEnterprise;
import com.europe.business.europebusiness.adpater.MyNewsAdpater;
import com.europe.business.europebusiness.fragment.base.BaseFragment;
import com.europe.business.europebusiness.ui.activity.bean.Enterprise;
import com.europe.business.europebusiness.ui.activity.bean.MyNews;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

public class Eu_Fragment extends BaseFragment {

    View view;
    private NiceSpinner niceSpinner1,niceSpinner2,niceSpinner3,niceSpinner4;
    private List<String> dataList=new ArrayList<>();
    private RecyclerView recyclerView;
    private List<MyNews> list=new ArrayList<>();
    @Override
    protected int setLayout() {
        return R.layout.fragment_eu;
    }

    public static Fragment newInstance(){
        Eu_Fragment fragment=new Eu_Fragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(setLayout(),container,false);
        recyclerView=view.findViewById(R.id.eu_context);
        niceSpinner1=view.findViewById(R.id.eu_food);
        niceSpinner2=view.findViewById(R.id.eu_regin);
        niceSpinner3=view.findViewById(R.id.eu_type);
        niceSpinner4=view.findViewById(R.id.eu_scale);

        addniceSpinner1();
        addniceSpinner2();
        addniceSpinner3();
        addniceSpinner4();
        addList();
        return view;

    }
    private void addniceSpinner1(){
        dataList=new ArrayList<>();
        dataList.add("食品加工哈哈");
        dataList.add("不限");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        niceSpinner1.attachDataSource(dataList);
    }
    private void addniceSpinner2(){
        dataList=new ArrayList<>();
        dataList.add("地区");
        dataList.add("不限");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        niceSpinner2.attachDataSource(dataList);
    }
    private void addniceSpinner3(){
        dataList=new ArrayList<>();
        dataList.add("类别");
        dataList.add("不限");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        niceSpinner3.attachDataSource(dataList);
    }
    private void addniceSpinner4(){
        dataList=new ArrayList<>();
        dataList.add("规模");
        dataList.add("不限");
        dataList.add("农业和养殖");
        dataList.add("农业和养殖");
        niceSpinner4.attachDataSource(dataList);
    }

    private void addList(){
        listAdd();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyNewsAdpater myNewsAdpater=new MyNewsAdpater(list);
        recyclerView.setAdapter(myNewsAdpater);
    }
    private void listAdd(){

        MyNews myNews=new MyNews();
        myNews.setImg(R.drawable.european_enterprises3_gone);
        myNews.setTitle("我的企业");
        myNews.setTime("金融公司");
        list.add(myNews);


        myNews.setImg(R.drawable.european_enterprises3_gone);
        myNews.setTitle("我的企业");
        myNews.setTime("金融公司");
        list.add(myNews);


        myNews.setImg(R.drawable.european_enterprises3_gone);
        myNews.setTitle("我的企业");
        myNews.setTime("金融公司");
        list.add(myNews);

        myNews.setImg(R.drawable.european_enterprises3_gone);
        myNews.setTitle("我的企业");
        myNews.setTime("金融公司");
        list.add(myNews);

        myNews.setImg(R.drawable.european_enterprises3_gone);
        myNews.setTitle("我的企业");
        myNews.setTime("金融公司");
        list.add(myNews);

        myNews.setImg(R.drawable.european_enterprises3_gone);
        myNews.setTitle("我的企业");
        myNews.setTime("金融公司");
        list.add(myNews);

        myNews.setImg(R.drawable.european_enterprises3_gone);
        myNews.setTitle("我的企业");
        myNews.setTime("金融公司");
        list.add(myNews);

    }
}
