package com.zhongziyue.video.service.dto;

public class VideoPlayDto {
    private String name;
    private String path;

    public VideoPlayDto() {
    }

    public String getName() {
        return name;
    }

    public VideoPlayDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPath() {
        return path;
    }

    public VideoPlayDto setPath(String path) {
        this.path = path;
        return this;
    }
}