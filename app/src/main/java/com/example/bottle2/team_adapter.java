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

public class team_adapter extends RecyclerView.Adapter<team_adapter.MyViewHolder> {

    private Context mContext;
    private List<team_manage> mem_list;

    public team_adapter(Context mContext, List<team_manage> mem_list) {
        this.mContext = mContext;
        this.mem_list = mem_list;
    }

    @NonNull
    @Override
    public team_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.team_layout, viewGroup, false);

        return new team_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull team_adapter.MyViewHolder myViewHolder, int i) {

        team_manage teamManage = mem_list.get(i);
        myViewHolder.mCiv.setImageResource(teamManage.getMemImg());
        myViewHolder.mName.setText(teamManage.getMemName());
        myViewHolder.mPos.setText(teamManage.getMemPos());
        myViewHolder.mPrcnt.setText(teamManage.getMemPrcnt() + "%");

    }

    @Override
    public int getItemCount() {
        return mem_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mName, mPos, mPrcnt;
        public CircleImageView mCiv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mCiv = itemView.findViewById(R.id.member_image);
            mName = itemView.findViewById(R.id.member_name);
            mPos = itemView.findViewById(R.id.member_position);
            mPrcnt = itemView.findViewById(R.id.member_prcnt);
        }
    }
}
