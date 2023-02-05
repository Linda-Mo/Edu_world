package com.education.edu_world.Fragments.Chat;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.education.edu_world.Activity.Chat.MessagingActivity;
import com.education.edu_world.Activity.Sign.StudentRegistration;
import com.education.edu_world.Adapter.AdapterListBasic;
import com.education.edu_world.Data.DataGenerator;
import com.education.edu_world.R;
import com.education.edu_world.model.People;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class MessageFragment extends Fragment {


    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterListBasic mAdapter;

    public MessageFragment() {
    }

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        parent_view = inflater.inflate(R.layout.fragment_message, container, false);
        initComponent();
        // Inflate the layout for this fragment
        return parent_view ;
    }

    private void initComponent() {
        recyclerView = (RecyclerView) parent_view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        List<People> items = DataGenerator.getPeopleData(getContext());
        items.addAll(DataGenerator.getPeopleData(getContext()));
        items.addAll(DataGenerator.getPeopleData(getContext()));

        //set data and list adapter
        mAdapter = new AdapterListBasic(getContext(), items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListBasic.OnItemClickListener() {
            @Override
            public void onItemClick(View view, People obj, int position) {
                startActivity(new Intent(getContext(), MessagingActivity.class));
            }
        });

    }

}