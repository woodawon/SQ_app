package org.techtown.sq_app;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>
                            implements OnTaskItemClickListener {
    ArrayList<TaskInfo> items = new ArrayList<TaskInfo>();

    OnTaskItemClickListener listener;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.book_item, viewGroup, false);

        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TaskInfo item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(TaskInfo item) {
        items.add(item);
    }

    public void setItems(ArrayList<TaskInfo> items) {
        this.items = items;
    }

    public TaskInfo getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, TaskInfo item) {
        items.set(position, item);
    }

    public void setOnItemClickListener(OnTaskItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder(View itemView, final OnTaskItemClickListener listener) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });

        }

        public void setItem(TaskInfo item) {
            textView.setText(item.getName());
        }


    }

}
