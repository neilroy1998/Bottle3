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

import java.util.ArrayList;
import java.util.List;


public class teamOverview_allTasks extends Fragment {

    private RecyclerView recyclerView;
    private List<alltasks_manage> alltasks_list;
    private alltasks_adapter alltasksAdapter;

    private OnFragmentInteractionListener mListener;

    public teamOverview_allTasks() {}


    public static teamOverview_allTasks newInstance(String param1, String param2) {
        teamOverview_allTasks fragment = new teamOverview_allTasks();
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
        View view = inflater.inflate(R.layout.fragment_team_overview_all_tasks, container, false);
        recyclerView = view.findViewById(R.id.alltasks_rv);
        alltasks_list = new ArrayList<>();
        alltasksAdapter = new alltasks_adapter(getActivity(), alltasks_list);

        RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(alltasksAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetch_alltasks();

        return view;
    }

    private void fetch_alltasks() {

        alltasks_list.clear();

        alltasks_manage atm;

        atm = new alltasks_manage("Task Cat", "02-08-2020", "Project Kitty", 1);
        alltasks_list.add(atm);

        atm = new alltasks_manage("Task Dog", "09-08-2021", "Project Doggy", 2);
        alltasks_list.add(atm);

        atm = new alltasks_manage("Task Cow", "05-10-2019", "Project Bell", 3);
        alltasks_list.add(atm);

        alltasksAdapter.notifyDataSetChanged();
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
