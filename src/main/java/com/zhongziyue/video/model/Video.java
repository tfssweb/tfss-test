package com.zhongziyue.video.model;

import java.io.File;

public class Video {
    private String name;
    private String path;
    private String type;

    public Video() {
    }

    public Video(File file) {
        this.name = file.getName();
        this.path = file.getName();
        this.type = "视频";
    }

    public Video(String file) {
        this.name = file;
        this.path = file;
        this.type = "目录";
    }

    public String getName() {
        return name;
    }

    public Video setName(String name) {
        this.name = name;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Video setPath(String path) {
        this.path = path;
        return this;
    }

    public String getType() {
        return type;
    }

    public Video setType(String type) {
        this.type = type;
        return this;
    }
}