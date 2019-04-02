package com.example.bottle2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class tasks_for_me_adapter extends RecyclerView.Adapter<tasks_for_me_adapter.MyViewHolder> {

    private Context mContext;
    private List<tasks_for_me_manage> formetasks_list;

    public tasks_for_me_adapter(Context mContext, List<tasks_for_me_manage> formetasks_list) {
        this.mContext = mContext;
        this.formetasks_list = formetasks_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.formetasks_cardlayout, viewGroup, false);

        return new tasks_for_me_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final tasks_for_me_manage tasksForMeManage = formetasks_list.get(i);
        myViewHolder.formetasksName.setText(tasksForMeManage.getFormetasksName());
        myViewHolder.formeTasksDL.setText(tasksForMeManage.getFormeTasksDL());
        myViewHolder.formeTasksProject.setText(tasksForMeManage.getFormeTasksProject());
    }

    @Override
    public int getItemCount() {
        return formetasks_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView formetasksName, formeTasksDL, formeTasksProject;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            formetasksName = itemView.findViewById(R.id.tv_formetaskName);
            formeTasksDL = itemView.findViewById(R.id.tv_formetaskDL);
            formeTasksProject = itemView.findViewById(R.id.tv_formetasksProj);
        }
    }
}
