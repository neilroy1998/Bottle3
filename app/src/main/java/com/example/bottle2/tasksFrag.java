package com.example.bottle2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class tasksFrag extends Fragment {

    private RecyclerView recyclerView;
    private List<todo_manage> todo_list;
    private todo_adapter todo_adapter;

    private OnFragmentInteractionListener mListener;

    public tasksFrag() {
    }

    public static tasksFrag newInstance(String param1, String param2) {
        tasksFrag fragment = new tasksFrag();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        recyclerView = view.findViewById(R.id.todo_recyclerView);
        todo_list = new ArrayList<>();
        todo_adapter = new todo_adapter(getActivity(), todo_list);

        Button addnew = view.findViewById(R.id.button_add_task);

        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(getContext(), "New Addition Soon", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(todo_adapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetch_todo_items();

        return view;
    }

    private void fetch_todo_items() {
        try {
            todo_list.clear();
            String sdate = null;
            Date dDate;
            todo_manage tm;

            sdate = "1990-01-01";
            dDate = new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
            tm = new todo_manage(1, "Task 1", "A\nB\nC\nD", dDate);
            todo_list.add(tm);

            sdate = "1991-01-01";
            dDate = new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
            tm = new todo_manage(2, "Task 2", "A\nB", dDate);
            todo_list.add(tm);

            sdate = "1992-01-01";
            dDate = new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
            tm = new todo_manage(3, "Task 3", "A\nB\nC", dDate);
            todo_list.add(tm);

            sdate = "2019-03-20";
            dDate = new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
            tm = new todo_manage(4, "Task 4", "A\nB\nC\nD", dDate);
            todo_list.add(tm);

            sdate = "1993-01-01";
            dDate = new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
            tm = new todo_manage(5, "Task 5", "A", dDate);
            todo_list.add(tm);

            todo_adapter.notifyDataSetChanged();

        }

        catch (Exception e) {
            // Pass
        }

    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
