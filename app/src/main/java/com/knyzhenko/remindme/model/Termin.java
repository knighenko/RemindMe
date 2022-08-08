package com.knyzhenko.remindme.model;

import android.media.Image;

public class Termin {

    private int id,type,importance;
    private long date;
    private String title, desc;

    public Termin(int id, String title, String desc, int category, int importance, long date) {
        this.id = id;
        this.type = category;
        this.date = date;
        this.importance = importance;
        this.title = title;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
