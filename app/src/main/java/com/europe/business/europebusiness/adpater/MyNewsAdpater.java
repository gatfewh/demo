package com.europe.business.europebusiness.adpater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.ui.activity.bean.MyNews;


import java.util.ArrayList;
import java.util.List;


public class MyNewsAdpater extends RecyclerView.Adapter<MyNewsAdpater.ViewHolder> {
    private List<MyNews> list=new ArrayList<>();

    public MyNewsAdpater(List<MyNews> list){
        this.list=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_information_item,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int img = list.get(i).getImg();
        if (img != 0) {
            viewHolder.img.setImageResource(img);
        }else {
            viewHolder.img.setVisibility(View.GONE);
        }
        viewHolder.title.setText(list.get(i).getTitle());
        viewHolder.time.setText(list.get(i).getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title,time;
      public ViewHolder(@NonNull View itemView) {
          super(itemView);
          img=itemView.findViewById(R.id.news_img);
          title=itemView.findViewById(R.id.news_title);
          time=itemView.findViewById(R.id.news_time);
      }
  }
}
