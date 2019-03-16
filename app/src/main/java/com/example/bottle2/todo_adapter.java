package com.example.bottle2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class todo_adapter extends RecyclerView.Adapter<todo_adapter.MyViewHolder> {

    private Context mContext;
    private List<todo_manage> todo_list;

    public todo_adapter(Context mContext, List<todo_manage> todo_list) {
        this.mContext = mContext;
        this.todo_list = todo_list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tHead, tContents, tDate;
        public Button bDone, bDel, bErr;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tHead = itemView.findViewById(R.id.tasks_head);
            tContents = itemView.findViewById(R.id.tasks_content);
            tDate = itemView.findViewById(R.id.tasks_date);
            bDone = itemView.findViewById(R.id.button_done);
            bDel = itemView.findViewById(R.id.button_del);
            bErr = itemView.findViewById(R.id.button_err);
        }
    }

    @NonNull
    @Override
    public todo_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.todo_layout, viewGroup, false);

        return new todo_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final todo_manage todo = todo_list.get(i);
        myViewHolder.tHead.setText(todo.getTaskHead());

        // TODO : check visibility
        myViewHolder.bErr.setVisibility(View.INVISIBLE);

        Date date = todo.getTasksDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        myViewHolder.tDate.setText(dateFormat.format(date));

        myViewHolder.tContents.setText(todo.getTaskContents());

        myViewHolder.bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, todo.getTaskHead() + " Done", Toast.LENGTH_SHORT).show();
            }
        });

        myViewHolder.bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, todo.getTaskHead() + " Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        Date curr_date = null;
        try {
            curr_date = Calendar.getInstance().getTime();

            if (todo.getTasksDate().getTime() - curr_date.getTime() <= -259200000) { // 3 days in ms
                myViewHolder.bErr.setVisibility(View.VISIBLE);
            }
            else {
                myViewHolder.bErr.setVisibility(View.INVISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return todo_list.size();
    }
}
