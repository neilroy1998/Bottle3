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

public class tasks_by_me extends Fragment {

    private OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    private List<tasks_by_me_manage> bymetasks_list;
    private tasks_by_me_adapter tasksByMeAdapter;

    public tasks_by_me() {}

    public static tasks_by_me newInstance(String param1, String param2) {
        tasks_by_me fragment = new tasks_by_me();
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
        View view = inflater.inflate(R.layout.fragment_tasks_by_me, container, false);

        recyclerView = view.findViewById(R.id.tasks_by_me_rv);
        bymetasks_list = new ArrayList<>();
        tasksByMeAdapter = new tasks_by_me_adapter(getActivity(), bymetasks_list);

        RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tasksByMeAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetch_bymetasks();


        return view;
    }

    private void fetch_bymetasks() {

        bymetasks_list.clear();

        int imgSrc;
        tasks_by_me_manage tbmm;

        tbmm = new tasks_by_me_manage("Alpha1", "01-01-2700", "P1", "N1", 1);
        bymetasks_list.add(tbmm);

        tbmm = new tasks_by_me_manage("Alpha2", "01-01-2800", "P2", "N2", 2);
        bymetasks_list.add(tbmm);

        tbmm = new tasks_by_me_manage("Alpha3", "01-01-2900", "P3", "N3", 3);
        bymetasks_list.add(tbmm);

        tasksByMeAdapter.notifyDataSetChanged();

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
