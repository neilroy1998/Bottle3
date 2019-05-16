package com.example.bottle2;

import android.content.Context;
import android.content.Intent;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link homeFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link homeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFrag extends Fragment {
    private RecyclerView recyclerView;
    private List<categories_manage> cat_list;
    private categories_adapter cat_adapter;


    private OnFragmentInteractionListener mListener;

    public homeFrag() {}

    public static homeFrag newInstance(String param1, String param2) {
        homeFrag fragment = new homeFrag();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.cat_rv);
        cat_list = new ArrayList<>();
        cat_adapter = new categories_adapter(getActivity(), cat_list);

        CircleImageView civ = view.findViewById(R.id.my_image);
        civ.setImageResource(R.drawable.profile);

        RecyclerView.LayoutManager lm = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cat_adapter);
        recyclerView.setNestedScrollingEnabled(false);

        fetch_cat_items();

        civ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), workspaceActivity.class);
                startActivity(i);
            }
        });
        
        return view;
    }

    private void fetch_cat_items() {

        cat_list.clear();

        categories_manage cm = new categories_manage(1, "Overall\nStatistics", Integer.toString(75));
        cat_list.add(cm);

        cm = new categories_manage(2, "Other\nStatistics", Integer.toString(87));
        cat_list.add(cm);

        cat_adapter.notifyDataSetChanged();
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
