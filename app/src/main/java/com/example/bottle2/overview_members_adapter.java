package com.example.bottle2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class overview_members_adapter extends RecyclerView.Adapter<overview_members_adapter.MyViewHolder> {

    private Context mContext;
    private List<overview_members_manage> mem_List;

    public overview_members_adapter(Context mContext, List<overview_members_manage> mem_List) {
        this.mContext = mContext;
        this.mem_List = mem_List;
    }

    @NonNull
    @Override
    public overview_members_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.overview_cardlayout, viewGroup, false);
        return new overview_members_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull overview_members_adapter.MyViewHolder myViewHolder, int i) {

        final overview_members_manage overviewMembersManage = mem_List.get(i);
        myViewHolder.mem_name.setText(overviewMembersManage.getMemName());
        myViewHolder.mem_img.setImageResource(overviewMembersManage.getMemImg());
        myViewHolder.mem_prcnt.setText(Integer.toString(overviewMembersManage.getMemPrcnt()));
    }

    @Override
    public int getItemCount() {
        return mem_List.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mem_name, mem_prcnt;
        public CircleImageView mem_img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mem_name =itemView.findViewById(R.id.member_name);
            mem_img = itemView.findViewById(R.id.member_image);
            mem_prcnt = itemView.findViewById(R.id.member_prcnt);
        }
    }
}
