package com.example.bottle2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class workspaceActivity extends AppCompatActivity {

    private RecyclerView ws_rv;
    private List<workspace_manage> ws_list;
    private workspace_adapter workspaceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workspace);

        ws_rv = findViewById(R.id.workspace_rv);
        ws_list = new ArrayList<>();
        workspaceAdapter = new workspace_adapter(workspaceActivity.this, ws_list);

        RecyclerView.LayoutManager lm = new GridLayoutManager(workspaceActivity.this, 1);
        ws_rv.setLayoutManager(lm);
        ws_rv.setItemAnimator(new DefaultItemAnimator());
        ws_rv.setAdapter(workspaceAdapter);
        ws_rv.setNestedScrollingEnabled(false);


        fetch_ws_items();
    }

    private void fetch_ws_items() {
        ws_list.clear();

        workspace_manage wm;

        wm = new workspace_manage(1, "Workspace 1");
        ws_list.add(wm);

        wm = new workspace_manage(2, "Workspace 2");
        ws_list.add(wm);

        wm = new workspace_manage(3, "Workspace 3");
        ws_list.add(wm);

        workspaceAdapter.notifyDataSetChanged();

    }

    public void add_ws(View v) {
        Toast.makeText(this, "Will Add Soon", Toast.LENGTH_SHORT).show();
    }
}
