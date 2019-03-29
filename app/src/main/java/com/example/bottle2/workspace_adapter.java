package com.example.bottle2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class workspace_adapter extends RecyclerView.Adapter<workspace_adapter.MyViewHolder>  {

    private Context mContext;
    private List<workspace_manage> ws_list;

    public workspace_adapter(Context mContext, List<workspace_manage> ws_list) {
        this.mContext = mContext;
        this.ws_list = ws_list;
    }

    @NonNull
    @Override
    public workspace_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.workspace_cardlayout, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final workspace_adapter.MyViewHolder myViewHolder, int i) {
        final workspace_manage workspaceManage = ws_list.get(i);
        myViewHolder.ws_name.setText(workspaceManage.getWorkspace_name());

        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu pm = new PopupMenu(mContext, myViewHolder.itemView);
                pm.getMenuInflater().inflate(R.menu.ws_manage_menu, pm.getMenu());
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit_ws:
                                Toast.makeText(mContext, "Edit " + workspaceManage.getWorkspace_name(), Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.del_ws:
                                Toast.makeText(mContext, "Del " + workspaceManage.getWorkspace_name(), Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                pm.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return ws_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView ws_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ws_name = itemView.findViewById(R.id.workspace_name);
        }
    }
}
