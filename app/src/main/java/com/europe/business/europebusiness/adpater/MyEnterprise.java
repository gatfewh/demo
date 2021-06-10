package com.europe.business.europebusiness.adpater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.europe.business.europebusiness.R;
import com.europe.business.europebusiness.ui.activity.bean.Enterprise;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MyEnterprise extends RecyclerView.Adapter<MyEnterprise.ViewHolder> {
    private List<Enterprise> list=new ArrayList<>();
    public MyEnterprise(List<Enterprise> list){
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.enterprise_item,viewGroup,false);
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
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.type.setText(list.get(i).getType());
        viewHolder.country.setText(list.get(i).getCountry());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name,type,country;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.enterprise_logo);
            name=itemView.findViewById(R.id.enterprise_name);
            type=itemView.findViewById(R.id.enterprise_type);
            country=itemView.findViewById(R.id.enterprise_country);
        }
    }


}
