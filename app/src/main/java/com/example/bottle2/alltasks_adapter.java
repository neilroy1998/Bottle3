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

public class alltasks_adapter extends RecyclerView.Adapter<alltasks_adapter.MyViewHolder> {

    private Context mContext;
    private List<alltasks_manage> alltasks_list;

    public alltasks_adapter(Context mContext, List<alltasks_manage> alltasks_list) {
        this.mContext = mContext;
        this.alltasks_list = alltasks_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.alltasks_cardlayout, viewGroup, false);

        return new alltasks_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final alltasks_manage alltasksManage = alltasks_list.get(i);
        myViewHolder.alltasksName.setText(alltasksManage.getAlltasksName());
        myViewHolder.alltasksDL.setText(alltasksManage.getAllTasksDL());
        myViewHolder.alltasksProject.setText(alltasksManage.getAllTasksProject());

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, tasks_overview.class);
                i.putExtra("tName", alltasksManage.getAlltasksName());
                i.putExtra("tDL", alltasksManage.getAllTasksDL());
                i.putExtra("tProj", alltasksManage.getAllTasksProject());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alltasks_list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView alltasksName, alltasksDL, alltasksProject;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            alltasksName = itemView.findViewById(R.id.tv_alltaskName);
            alltasksDL = itemView.findViewById(R.id.tv_alltaskDL);
            alltasksProject = itemView.findViewById(R.id.tv_alltasksProj);
        }
    }
}
