package com.zhongziyue.video.model;

public class VideoList {
    private Integer id;
    private String name;
    private String path;

    public VideoList() {
    }

    public Integer getId() {
        return id;
    }

    public VideoList setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public VideoList setName(String name) {
        this.name = name;
        return this;
    }

    public String getPath() {
        return path;
    }

    public VideoList setPath(String path) {
        this.path = path;
        return this;
    }
}