package org.techtown.sq_app;

public class BookInfo {

    String name;
    String contents;

    public BookInfo(String name, String contents) {
        this.name = name;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "name='" + name + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }

}
