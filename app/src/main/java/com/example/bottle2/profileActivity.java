package com.example.bottle2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class profileActivity extends AppCompatActivity {

    String mem_name="", mem_prcnt="", mem_desc="";
    int mem_img=0;

    TextView person_name, person_prcnt, person_desc;
    CircleImageView person_img;
    RecyclerView recyclerView;
    List<profile_tasks_manage> persontasks_list;
    profile_tasks_adapter profileTasksAdapterArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        person_name = findViewById(R.id.tv_person_name);
        person_prcnt = findViewById(R.id.tv_overallPrcnt2);
        person_desc = findViewById(R.id.tv_personDetails);
        person_img = findViewById(R.id.person_image);

        mem_name = getIntent().getExtras().getString("Mem_Name");
        mem_prcnt = getIntent().getExtras().getString("Mem_Prcnt");
        mem_img = getIntent().getExtras().getInt("Mem_Img");
        mem_desc = getIntent().getExtras().getString("Mem_Desc");

        person_name.setText(mem_name);
        person_desc.setText(mem_desc);
        person_prcnt.setText(mem_prcnt);
        person_img.setImageResource(mem_img);

        recyclerView = findViewById(R.id.person_tasks_rv);
        persontasks_list = new ArrayList<>();
        profileTasksAdapterArrayAdapter = new profile_tasks_adapter(profileActivity.this, persontasks_list);

        RecyclerView.LayoutManager lm = new GridLayoutManager(profileActivity.this, 1);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(profileTasksAdapterArrayAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetch_persontasks();
    }

    private void fetch_persontasks() {

        persontasks_list.clear();

        profile_tasks_manage ptm;

        ptm = new profile_tasks_manage("Alpha1", "01-01-2700", "P1", 1);
        persontasks_list.add(ptm);

        ptm = new profile_tasks_manage("Alpha2", "01-01-2800", "P2",  2);
        persontasks_list.add(ptm);

        ptm = new profile_tasks_manage("Alpha3", "01-01-2900", "P3",  3);
        persontasks_list.add(ptm);

        profileTasksAdapterArrayAdapter.notifyDataSetChanged();

    }

    public void person_assign_tasks(View v){

    }
}
