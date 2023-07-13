package org.techtown.sq_app;

import java.util.ArrayList;

public interface OnDatabaseCallback {
    public void insert(String name, String contents);
    public ArrayList<BookInfo> selectAll();
}
