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


public class teamOverview_Overview extends Fragment {

    private RecyclerView recyclerView;
    private List<overview_members_manage> mem_list;
    private overview_members_adapter mem_adapter;

    private OnFragmentInteractionListener mListener;

    public teamOverview_Overview() {}

    public static teamOverview_Overview newInstance(String param1, String param2) {
        teamOverview_Overview fragment = new teamOverview_Overview();
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
        View view = inflater.inflate(R.layout.fragment_team_overview__overview, container, false);
        recyclerView =view.findViewById(R.id.overview_rv);
        mem_list =new ArrayList<>();
        mem_adapter = new overview_members_adapter(getActivity(), mem_list);

        RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mem_adapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetch_members();

        return view;
    }

    private void fetch_members() {

    mem_list.clear();

    overview_members_manage omm;

    omm = new overview_members_manage(1, 75, R.drawable.blank, "Frank Ocean");
    mem_list.add(omm);

    omm = new overview_members_manage(2, 84, R.drawable.blank, "Bon Iver");
    mem_list.add(omm);

    mem_adapter.notifyDataSetChanged();

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
