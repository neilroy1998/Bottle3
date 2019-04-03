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

        final tasks_by_me_manage tasksByMeManage = bymetasks_list.get(i);
        myViewHolder.bymetasksName.setText(tasksByMeManage.getBymetasksName());
        myViewHolder.bymeTasksDL.setText(tasksByMeManage.getBymeTasksDL());
        myViewHolder.bymeTasksProject.setText(tasksByMeManage.getBymeTasksProject());
        myViewHolder.bymeTasksTo.setText(tasksByMeManage.getBymeTasksTo());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, tasks_overview.class);
                i.putExtra("tName", tasksByMeManage.getBymetasksName());
                i.putExtra("tDL", tasksByMeManage.getBymeTasksDL());
                i.putExtra("tProj", tasksByMeManage.getBymeTasksProject());
                i.putExtra("tTo", tasksByMeManage.getBymeTasksTo());
                mContext.startActivity(i);
            }
        });

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
