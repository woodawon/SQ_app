package org.techtown.sq_app;

import android.view.View;

public interface OnTaskItemClickListener {
    public void onItemClick(TaskAdapter.ViewHolder holder, View view, int position);
}
