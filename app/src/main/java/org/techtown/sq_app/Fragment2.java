package org.techtown.sq_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Fragment2 extends Fragment {
    RecyclerView recyclerView;
    TaskAdapter adapter;

    OnDatabaseCallback callback;
    static String title, content;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callback = (OnDatabaseCallback) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new TaskAdapter();
        recyclerView.setAdapter(adapter);

        ArrayList<TaskInfo> result = callback.selectAll();
        adapter.setItems(result);

        adapter.setOnItemClickListener(new OnTaskItemClickListener() {
            @Override
            public void onItemClick(TaskAdapter.ViewHolder holder, View view, int position) {
                Toast.makeText(getContext(), "문제 풀기 시작" , Toast.LENGTH_LONG).show();
                TaskInfo item = adapter.getItem(position);
                title = item.getName();
                content = item.getContents();
            }
        });


        return rootView;
    }

}

