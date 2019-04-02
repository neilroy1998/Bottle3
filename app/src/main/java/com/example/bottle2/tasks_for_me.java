package com.example.bottle2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class tasks_for_me extends Fragment {
    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private List<tasks_for_me_manage> formetasks_list;
    private tasks_for_me_adapter tasksForMeAdapter;

    public tasks_for_me() {}

    public static tasks_for_me newInstance(String param1, String param2) {
        tasks_for_me fragment = new tasks_for_me();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks_for_me, container, false);

        recyclerView = view.findViewById(R.id.tasks_for_me_rv);
        formetasks_list = new ArrayList<>();
        tasksForMeAdapter = new tasks_for_me_adapter(getActivity(), formetasks_list);

        RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tasksForMeAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetch_formetasks();

        return view;
    }

    private void fetch_formetasks() {

        formetasks_list.clear();

        int imgSrc;
        tasks_for_me_manage tfmm;

        tfmm = new tasks_for_me_manage("Alpha1", "01-01-2700", "P1", 1);
        formetasks_list.add(tfmm);

        tfmm = new tasks_for_me_manage("Alpha2", "01-01-2800", "P2", 2);
        formetasks_list.add(tfmm);

        tfmm = new tasks_for_me_manage("Alpha3", "01-01-2900", "P3", 3);
        formetasks_list.add(tfmm);

        tasksForMeAdapter.notifyDataSetChanged();


    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
