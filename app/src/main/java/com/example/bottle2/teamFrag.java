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

import de.hdodenhof.circleimageview.CircleImageView;

public class teamFrag extends Fragment {

    private RecyclerView recyclerView;
    private List<team_manage> mem_list;
    private team_adapter teamAdapter;


    private OnFragmentInteractionListener mListener;

    public teamFrag() {}


    public static teamFrag newInstance(String param1, String param2) {
        teamFrag fragment = new teamFrag();
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
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        recyclerView = view.findViewById(R.id.team_rv);
        mem_list = new ArrayList<>();
        teamAdapter = new team_adapter(getActivity(), mem_list);

        RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(teamAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetch_members();

        return view;
    }

    private void fetch_members() {

        mem_list.clear();

        int imgSrc;
        team_manage tm;

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        tm = new team_manage(1, "Alpha", "CEO", "85", R.drawable.blank);
        mem_list.add(tm);

        teamAdapter.notifyDataSetChanged();

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
