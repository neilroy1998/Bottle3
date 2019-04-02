package com.example.bottle2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class tasks_by_me_adapter extends RecyclerView.Adapter<tasks_by_me_adapter.MyViewHolder> {

    private Context mContext;
    private List<tasks_by_me_manage> bymetasks_list;

    public tasks_by_me_adapter(Context mContext, List<tasks_by_me_manage> bymetasks_list) {
        this.mContext = mContext;
        this.bymetasks_list = bymetasks_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bymetasks_cardlayout, viewGroup, false);

        return new tasks_by_me_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        final tasks_by_me_manage tasksForMeManage = bymetasks_list.get(i);
        myViewHolder.bymetasksName.setText(tasksForMeManage.getBymetasksName());
        myViewHolder.bymeTasksDL.setText(tasksForMeManage.getBymeTasksDL());
        myViewHolder.bymeTasksProject.setText(tasksForMeManage.getBymeTasksProject());
        myViewHolder.bymeTasksTo.setText(tasksForMeManage.getBymeTasksTo());

    }

    @Override
    public int getItemCount() {
        return bymetasks_list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView bymetasksName, bymeTasksDL, bymeTasksProject, bymeTasksTo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bymetasksName = itemView.findViewById(R.id.tv_bymetaskName);
            bymeTasksDL = itemView.findViewById(R.id.tv_bymetaskDL);
            bymeTasksProject = itemView.findViewById(R.id.tv_bymetasksProj);
            bymeTasksTo = itemView.findViewById(R.id.tv_bymetasksto);
        }
    }
}
