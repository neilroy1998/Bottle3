package com.example.bottle2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.support.v4.content.ContextCompat.startActivity;

public class team_adapter extends RecyclerView.Adapter<team_adapter.MyViewHolder> {

    private Context mContext;
    private List<team_manage> team_list;

    public team_adapter(Context mContext, List<team_manage> team_list) {
        this.mContext = mContext;
        this.team_list = team_list;
    }

    @NonNull
    @Override
    public team_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.team_layout, viewGroup, false);

        return new team_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final team_adapter.MyViewHolder myViewHolder, int i) {

        final team_manage teamManage = team_list.get(i);
        myViewHolder.mName.setText(teamManage.getteamName());
        myViewHolder.mDesc.setText(teamManage.getTeamDesc());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, teamOverviewActivity.class);
                i.putExtra("teamID", teamManage.getteamID()); // Integer
                i.putExtra("teamName", teamManage.getteamName());
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return team_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mName, mDesc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_team_Name);
            mDesc = itemView.findViewById(R.id.tv_team_desc);
        }
    }
}
