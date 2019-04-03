package com.example.bottle2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class profile_tasks_adapter extends RecyclerView.Adapter<profile_tasks_adapter.MyViewHolder> {

    private Context mContext;
    private List<profile_tasks_manage> persontasks_list;

    public profile_tasks_adapter(Context mContext, List<profile_tasks_manage> persontasks_list) {
        this.mContext = mContext;
        this.persontasks_list = persontasks_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.profile_tasks_cardlayout, viewGroup, false);

        return new profile_tasks_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final profile_tasks_manage profileTasksManage = persontasks_list.get(i);
        myViewHolder.persontasksName.setText(profileTasksManage.getpersontasksName());
        myViewHolder.personTasksDL.setText(profileTasksManage.getpersonTasksDL());
        myViewHolder.personTasksProject.setText(profileTasksManage.getpersonTasksProject());
    }

    @Override
    public int getItemCount() {
        return persontasks_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView persontasksName, personTasksDL, personTasksProject;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            persontasksName = itemView.findViewById(R.id.tv_persontaskName);
            personTasksDL = itemView.findViewById(R.id.tv_profile_tasks_DL);
            personTasksProject = itemView.findViewById(R.id.tv_profile_tasks_Proj);
        }
    }
}
