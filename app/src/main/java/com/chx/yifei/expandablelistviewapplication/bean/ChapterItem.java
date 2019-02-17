package com.chx.yifei.expandablelistviewapplication.bean;

public class ChapterItem {
    private int id;
    private String name;

    public ChapterItem(){}

    public ChapterItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int pid;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
