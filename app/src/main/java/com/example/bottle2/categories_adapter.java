package com.example.bottle2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class categories_adapter extends RecyclerView.Adapter<categories_adapter.MyViewHolder> {

    private Context mContext;
    private List<categories_manage> cat_list;

    public categories_adapter(Context mContext, List<categories_manage> cat_list) {
        this.mContext = mContext;
        this.cat_list = cat_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.categories_cardlayout, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        categories_manage category = cat_list.get(i);
        myViewHolder.cat.setText(category.getCategoryName());
        myViewHolder.prcnt.setText(category.getPercent());
    }

    @Override
    public int getItemCount() {
        return cat_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView cat, prcnt, extra;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cat = (TextView) itemView.findViewById(R.id.cat_cat);
            prcnt = (TextView) itemView.findViewById(R.id.tv_team_desc);
        }
    }

}
